package mariculture.core.handlers;

import java.util.Random;

import mariculture.core.Core;
import mariculture.core.config.WorldGeneration.OreGen;
import mariculture.core.config.WorldGeneration.WorldGen;
import mariculture.core.lib.RockMeta;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WorldEventHandler {
    public static boolean isBlacklisted(int i) {
        for (int j : WorldGen.OCEAN_BLACKLIST) {
            if (i == j) return true;
        }

        return false;
    }

    //Core, Replacing Gravel with Sand and Limestone in Oceans
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onReplaceBiomeBlocks(ReplaceBiomeBlocks event) {
        if (event.metaArray == null || event.world == null || isBlacklisted(event.world.provider.dimensionId)) {
            return;
        } else if (event.world.getChunkProvider() instanceof ChunkProviderServer) {
            ChunkProviderServer server = (ChunkProviderServer) event.world.getChunkProvider();
            if (server.currentChunkProvider instanceof ChunkProviderGenerate) {
                ChunkProviderGenerate provider = (ChunkProviderGenerate) server.currentChunkProvider;
                double d0 = 0.03125D;
                provider.stoneNoise = provider.field_147430_m.func_151599_a(provider.stoneNoise, (double) (event.chunkX * 16), (double) (event.chunkZ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
                for (int k = 0; k < 16; ++k) {
                    for (int l = 0; l < 16; ++l) {
                        BiomeGenBase biome = event.biomeArray[l * 16 + k];
                        if (BiomeDictionary.isBiomeOfType(biome, Type.WATER) || BiomeDictionary.isBiomeOfType(biome, Type.BEACH)) {
                            if (WorldGen.VARYING_LIMESTONE) {
                                if (BiomeDictionary.isBiomeOfType(biome, Type.BEACH)) {
                                    genBiomeTerrain(event, k, l, biome, WorldGen.BEACH_LIMESTONE, provider.stoneNoise);
                                } else if (biome == BiomeGenBase.deepOcean) {
                                    genBiomeTerrain(event, k, l, biome, WorldGen.OCEAN_DEEP_LIMESTONE, provider.stoneNoise);
                                } else if (biome instanceof BiomeGenRiver) {
                                    genBiomeTerrain(event, k, l, biome, WorldGen.RIVER_LIMESTONE, provider.stoneNoise);
                                } else {
                                    genBiomeTerrain(event, k, l, biome, WorldGen.OCEAN_LIMESTONE, provider.stoneNoise);
                                }
                            } else {
                                genBiomeTerrain(event, k, l, biome, WorldGen.OCEAN_LIMESTONE, provider.stoneNoise);
                            }
                        } else {
                            biome.genTerrainBlocks(event.world, event.world.rand, event.blockArray, event.metaArray, event.chunkX * 16 + k, event.chunkZ * 16 + l, provider.stoneNoise[l + k * 16]);
                        }
                    }
                }

                event.setResult(Result.DENY);
            }
        }
    }

    private void genBiomeTerrain(ReplaceBiomeBlocks event, int k, int l, BiomeGenBase biome, double depth, double[] noise) {
        genBiomeTerrain(event.world, event.world.rand, event.blockArray, event.metaArray, event.chunkX * 16 + k, event.chunkZ * 16 + l, noise[l + k * 16], biome, WorldGen.OCEAN_LIMESTONE);
    }

    public static final void genBiomeTerrain(World world, Random rand, Block[] blocksArray, byte[] metaArray, int x, int z, double noise, BiomeGenBase biome, double depth) {
        Block seabed = WorldGen.LIMESTONE_FLOOR ? Core.limestone : Blocks.sandstone;
        Block topBlock = Blocks.grass;
        Block fillerBlock = Blocks.dirt;
        boolean flag = true;
        Block block = topBlock;
        byte b0 = 0;
        Block block1 = fillerBlock;
        int k = -1;
        int l = (int) (noise / depth + depth + rand.nextDouble() * 0.25D);
        int i1 = x & 15;
        int j1 = z & 15;
        int k1 = blocksArray.length / 256;

        for (int l1 = 255; l1 >= 0; --l1) {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + rand.nextInt(5)) {
                blocksArray[i2] = Blocks.bedrock;
            } else {
                Block block2 = blocksArray[i2];

                if (block2 != null && block2.getMaterial() != Material.air) {
                    if (block2 == Blocks.stone) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block1 = Blocks.stone;
                            } else if (l1 >= 59 && l1 <= 64) {
                                block = topBlock;
                                b0 = (byte) 0;
                                block1 = fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (biome.getFloatTemperature(x, l1, z) < 0.15F) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                } else {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62) {
                                blocksArray[i2] = block;
                                metaArray[i2] = b0;
                            } else if (l1 < 61 - l) {
                                block = null;
                                block1 = seabed;
                                blocksArray[i2] = Blocks.sand;
                            } else {
                                blocksArray[i2] = block1;
                            }
                        } else if (k > 0) {
                            --k;

                            int chance = biome instanceof BiomeGenRiver ? OreGen.RUTILE_SPAWN_CHANCE / 2 : OreGen.RUTILE_SPAWN_CHANCE;
                            if (block1 == seabed && OreGen.RUTILE_ON && world.rand.nextInt(chance) == 0) {
                                blocksArray[i2] = Core.rocks;
                                metaArray[i2] = RockMeta.RUTILE;
                            } else blocksArray[i2] = block1;

                            if (k == 0 && block1 == Blocks.sand) {
                                k = rand.nextInt(4) + Math.max(0, l1 - 63);
                                block1 = Blocks.sandstone;
                            }
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }
    }
}
