package mariculture.core.lib;

import mariculture.api.core.MaricultureHandlers;
import mariculture.core.Core;
import mariculture.fishery.Fish;
import mariculture.fishery.Fishery;
import maritech.extensions.modules.ExtensionFactory;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MCLib {
    /** Vanilla shortcuts for stacks **/
    public static final ItemStack ink = new ItemStack(Items.dye, 1, Dye.INK);
    public static final ItemStack bonemeal = new ItemStack(Items.dye, 1, Dye.BONE);
    public static final ItemStack lapis = new ItemStack(Items.dye, 1, Dye.LAPIS);
    public static final ItemStack coal = new ItemStack(Items.coal, 1, 0);
    public static final ItemStack blueWool = new ItemStack(Blocks.wool, 1, 11);
    public static final ItemStack pinkWool = new ItemStack(Blocks.wool, 1, 6);
    public static final ItemStack wool = new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE);
    public static final ItemStack quartzSlab = new ItemStack(Blocks.stone_slab, 1, 7);
    public static final ItemStack stoneSlab = new ItemStack(Blocks.stone_slab, 1, 0);
    public static final ItemStack skull = new ItemStack(Items.skull, 1, 0);
    public static final ItemStack witherSkull = new ItemStack(Items.skull, 1, 1);
    public static final ItemStack zombie = new ItemStack(Items.skull, 1, 2);
    public static final ItemStack cyanDye = new ItemStack(Items.dye, 1, Dye.CYAN);
    public static final ItemStack greyDye = new ItemStack(Items.dye, 1, Dye.GREY);
    public static final ItemStack limeDye = new ItemStack(Items.dye, 1, Dye.LIME);
    public static final ItemStack lightBlueDye = new ItemStack(Items.dye, 1, Dye.LIGHT_BLUE);
    public static final ItemStack lightGreyDye = new ItemStack(Items.dye, 1, Dye.LIGHT_GREY);
    public static final ItemStack orangeDye = new ItemStack(Items.dye, 1, Dye.ORANGE);
    public static final ItemStack purpleDye = new ItemStack(Items.dye, 1, Dye.PURPLE);
    public static final ItemStack magentaDye = new ItemStack(Items.dye, 1, Dye.MAGENTA);
    public static final ItemStack pinkDye = new ItemStack(Items.dye, 1, Dye.PINK);
    public static final ItemStack cactusGreen = new ItemStack(Items.dye, 1, Dye.GREEN);
    public static final ItemStack waterBottle = new ItemStack(Items.potionitem, 1, 0);
    public static final ItemStack dandelionDye = new ItemStack(Items.dye, 1, Dye.YELLOW);
    public static final ItemStack roseDye = new ItemStack(Items.dye, 1, Dye.RED);
    public static final ItemStack greyClay = new ItemStack(Blocks.stained_hardened_clay, 1, 3);
    public static final ItemStack whiteClay = new ItemStack(Blocks.stained_hardened_clay, 1, 0);
    public static final ItemStack healthPotion = new ItemStack(Items.potionitem, 1, 8197);

    /** Vanilla shortcuts for blocks **/
    public static final Block enchant = Blocks.enchanting_table;
    public static final Block tnt = Blocks.tnt;
    public static final Block bookshelf = Blocks.bookshelf;
    public static final Block snow = Blocks.snow;
    public static final Block blockClay = Blocks.clay;
    public static final Block blockSnow = Blocks.snow;
    public static final Block chest = Blocks.chest;
    public static final Block rose = Blocks.red_flower;
    public static final Block dandelion = Blocks.yellow_flower;
    public static final Block ironBars = Blocks.iron_bars;
    public static final Block hopper = Blocks.hopper;
    public static final Block piston = Blocks.piston;
    public static final Block emeraldBlock = Blocks.emerald_block;
    public static final Block dragonEgg = Blocks.dragon_egg;
    public static final Block sand = Blocks.sand;
    public static final Block glass = Blocks.glass;
    public static final Block glassPane = Blocks.glass_pane;
    public static final Block ice = Blocks.ice;
    public static final Block grass = Blocks.grass;
    public static final Block dirt = Blocks.dirt;
    public static final Block lily = Blocks.waterlily;
    public static final Block netherrack = Blocks.netherrack;
    public static final Block stone = Blocks.stone;
    public static final Block obsidian = Blocks.obsidian;
    public static final Block fence = Blocks.fence;
    public static final Block netherBrick = Blocks.nether_brick;
    public static final Block redstoneTorch = Blocks.redstone_torch;
    public static final Block goldRail = Blocks.golden_rail;
    public static final Block redMushroom = Blocks.red_mushroom;
    public static final Block brownMushroom = Blocks.brown_mushroom;
    public static final Block log = Blocks.log;
    public static final Block planks = Blocks.planks;
    public static final Block craftingTable = Blocks.crafting_table;
    public static final Block endstone = Blocks.end_stone;
    public static final Block cobblestone = Blocks.cobblestone;

    /** Vanilla shortcuts for items **/
    public static final Item repeater = Items.repeater;
    public static final Item quartz = Items.quartz;
    public static final Item comparator = Items.comparator;
    public static final Item cookedFish = Items.cooked_fished;
    public static final Item vanillaFish = Items.fish;
    public static final Item leather = Items.leather;
    public static final Item reeds = Items.reeds;
    public static final Item seeds = Items.wheat_seeds;
    public static final Item diamond = Items.diamond;
    public static final Item diamondBoots = Items.diamond_boots;
    public static final Item enderPearl = Items.ender_pearl;
    public static final Item eyeOfEnder = Items.ender_eye;
    public static final Item ghastTear = Items.ghast_tear;
    public static final Item bookAndQuill = Items.writable_book;
    public static final Item feather = Items.feather;
    public static final Item ironAxe = Items.iron_axe;
    public static final Item redstone = Items.redstone;
    public static final Item carrot = Items.carrot;
    public static final Item potato = Items.potato;
    public static final Item paper = Items.paper;
    public static final Item glowstone = Items.glowstone_dust;
    public static final Item bread = Items.bread;
    public static final Item rawFish = Items.fish;
    public static final Item bowl = Items.bowl;
    public static final Item snowball = Items.snowball;
    public static final Item string = Items.string;
    public static final Item blazeRod = Items.blaze_rod;
    public static final Item blazePowder = Items.blaze_powder;
    public static final Item gunpowder = Items.gunpowder;
    public static final Item bone = Items.bone;
    public static final Item goldNugget = Items.gold_nugget;
    public static final Item slimeBall = Items.slime_ball;
    public static final Item netherWart = Items.nether_wart;
    public static final Item rottenFlesh = Items.rotten_flesh;
    public static final Item spiderEye = Items.spider_eye;
    public static final Item fermentedEye = Items.fermented_spider_eye;
    public static final Item book = Items.book;
    public static final Item xpBottle = Items.experience_bottle;
    public static final Item nameTag = Items.name_tag;
    public static final Item netherStar = Items.nether_star;
    public static final Item stick = Items.stick;
    public static final Item clay = Items.clay_ball;
    public static final Item beef = Items.beef;
    public static final Item pork = Items.porkchop;
    public static final Item wheat = Items.wheat;
    public static final Item egg = Items.egg;
    public static final Item lava = Items.lava_bucket;
    public static final Item water = Items.water_bucket;
    public static final Item brick = Items.brick;
    public static final Item sugar = Items.sugar;
    public static final Item ingotIron = Items.iron_ingot;
    public static final Item compass = Items.compass;
    public static final Item nettherackBrick = Items.netherbrick;
    public static final Item poisonPotato = Items.poisonous_potato;
    public static final Item leatherCap = Items.leather_helmet;

    /** ItemStack always based blocks **/
    public static final ItemStack pearlBlock = new ItemStack(Core.pearlBlock, 1, OreDictionary.WILDCARD_VALUE);
    public static final ItemStack oyster = new ItemStack(Core.water, 1, WaterMeta.OYSTER);
    public static final ItemStack limestone = new ItemStack(Core.limestone, 1, LimestoneMeta.RAW);
    public static final ItemStack limestoneSmooth = new ItemStack(Core.limestone, 1, LimestoneMeta.SMOOTH);
    public static final ItemStack blockAluminum = new ItemStack(Core.metals, 1, MetalMeta.ALUMINUM_BLOCK);
    public static final ItemStack blockTitanium = new ItemStack(Core.metals, 1, MetalMeta.TITANIUM_BLOCK);
    public static final ItemStack blockMagnesium = new ItemStack(Core.metals, 1, MetalMeta.MAGNESIUM_BLOCK);
    public static final ItemStack blockCopper = new ItemStack(Core.metals, 1, MetalMeta.COPPER_BLOCK);
    public static final ItemStack blockRutile = new ItemStack(Core.metals, 1, MetalMeta.RUTILE_BLOCK);
    public static final ItemStack oreCopper = new ItemStack(Core.rocks, 1, RockMeta.COPPER);
    public static final ItemStack transparent = new ItemStack(Core.transparent, 1, TransparentMeta.PLASTIC);
    public static final ItemStack tank = new ItemStack(Core.tanks, 1, TankMeta.TANK);
    public static final ItemStack tankAluminum = new ItemStack(Core.tanks, 1, TankMeta.TANK_ALUMINUM);
    public static final ItemStack tankTitanium = new ItemStack(Core.tanks, 1, TankMeta.TANK_TITANIUM);
    public static final ItemStack gasTank = new ItemStack(Core.tanks, 1, TankMeta.TANK_GAS);
    public static final ItemStack fishTank = new ItemStack(Core.tanks, 1, TankMeta.FISH);
    public static final ItemStack baseBrick = new ItemStack(Core.rocks, 1, RockMeta.BASE_BRICK);
    public static final ItemStack baseIron = new ItemStack(Core.metals, 1, MetalMeta.BASE_IRON);
    public static final ItemStack baseWood = new ItemStack(Core.woods, 1, WoodMeta.BASE_WOOD);
    public static final ItemStack autodictionary = new ItemStack(Core.machines, 1, MachineMeta.DICTIONARY_ITEM);
    public static final ItemStack fishSorter = new ItemStack(Core.machines, 1, MachineMeta.FISH_SORTER);
    public static final ItemStack sawmill = new ItemStack(Core.machines, 1, MachineMeta.SAWMILL);
    public static final ItemStack unpacker = new ItemStack(Core.machines, 1, MachineMeta.UNPACKER);
    public static final ItemStack fishFeeder = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.FISH_FEEDER);
    public static final ItemStack hatchery = new ItemStack(Core.tanks, 1, TankMeta.HATCHERY);
    public static final ItemStack polishedLog = new ItemStack(Core.woods, 1, WoodMeta.POLISHED_LOG);
    public static final ItemStack polishedPlank = new ItemStack(Core.woods, 1, WoodMeta.POLISHED_PLANK);
    public static final ItemStack heatglass = new ItemStack(Core.glass, 1, GlassMeta.HEAT);
    public static final ItemStack airPump = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.AIR_PUMP);
    public static final ItemStack storageBookshelf = new ItemStack(Core.machines, 1, MachineMeta.BOOKSHELF);
    public static final ItemStack crucible = new ItemStack(Core.machinesMulti, 1, MachineMultiMeta.CRUCIBLE);
    public static final ItemStack anvil = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.ANVIL);
    public static final ItemStack autohammer = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.AUTO_HAMMER);
    public static final ItemStack vat = new ItemStack(Core.renderedMachinesMulti, 1, MachineRenderedMultiMeta.VAT);
    public static final ItemStack ingotCaster = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.INGOT_CASTER);
    public static final ItemStack blockCaster = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.BLOCK_CASTER);
    public static final ItemStack nuggetCaster = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.NUGGET_CASTER);
    public static final ItemStack sifter = new ItemStack(Core.renderedMachinesMulti, 1, MachineRenderedMultiMeta.SIFTER);
    public static final ItemStack geyser = new ItemStack(Core.renderedMachines, 1, MachineRenderedMeta.GEYSER);

    /** ItemStack always based items **/
    public static final ItemStack kelpWrap = new ItemStack(Core.food, 1, FoodMeta.KELP_WRAP);
    public static final ItemStack hammer = new ItemStack(Core.hammer);
    public static final ItemStack ladle = new ItemStack(Core.ladle);
    public static final ItemStack titaniumBucket = new ItemStack(Core.bucketTitanium);
    public static final ItemStack dustSalt = new ItemStack(Core.materials, 1, MaterialsMeta.DUST_SALT);
    public static final ItemStack ingotTitanium = new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_TITANIUM);
    public static final ItemStack ingotMagnesium = new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_MAGNESIUM);
    public static final ItemStack ingotRutile = new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_RUTILE);
    public static final ItemStack ingotCopper = new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_COPPER);
    public static final ItemStack ingotAluminum = new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_ALUMINUM);
    public static final ItemStack nuggetIron = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_IRON);
    public static final ItemStack nuggetCopper = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_COPPER);
    public static final ItemStack nuggetRutile = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_RUTILE);
    public static final ItemStack nuggetTitanium = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_TITANIUM);
    public static final ItemStack nuggetMagnesium = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_MAGNESIUM);
    public static final ItemStack nuggetAluminum = new ItemStack(Core.materials, 1, MaterialsMeta.NUGGET_ALUMINUM);
    public static final ItemStack burntBrick = new ItemStack(Core.crafting, 1, CraftingMeta.BURNT_BRICK);
    public static final ItemStack eternalMale = new ItemStack(Core.upgrade, 1, UpgradeMeta.ETERNAL_MALE);
    public static final ItemStack eternalFemale = new ItemStack(Core.upgrade, 1, UpgradeMeta.ETERNAL_FEMALE);
    public static final ItemStack filtrator = new ItemStack(Core.upgrade, 1, UpgradeMeta.FILTER);
    public static final ItemStack salinator = new ItemStack(Core.upgrade, 1, UpgradeMeta.SALINATOR);
    public static final ItemStack pearls = new ItemStack(Core.pearls, 1, OreDictionary.WILDCARD_VALUE);
    public static final ItemStack ironWheel = new ItemStack(Core.crafting, 1, CraftingMeta.WHEEL);
    public static final ItemStack aluminumSheet = new ItemStack(Core.crafting, 1, CraftingMeta.ALUMINUM_SHEET);
    public static final ItemStack titaniumSheet = new ItemStack(Core.crafting, 1, CraftingMeta.TITANIUM_SHEET);
    public static final ItemStack titaniumRod = new ItemStack(Core.crafting, 1, CraftingMeta.TITANIUM_ROD);
    public static final ItemStack glassLens = new ItemStack(Core.crafting, 1, CraftingMeta.LENS_GLASS);
    public static final ItemStack life = new ItemStack(Core.crafting, 1, CraftingMeta.LIFE_CORE);
    public static final ItemStack plan = new ItemStack(Core.crafting, 1, CraftingMeta.BLANK_PLAN);
    public static final ItemStack wicker = new ItemStack(Core.crafting, 1, CraftingMeta.WICKER);
    public static final ItemStack goldSilk = new ItemStack(Core.crafting, 1, CraftingMeta.GOLDEN_SILK);
    public static final ItemStack goldThread = new ItemStack(Core.crafting, 1, CraftingMeta.GOLDEN_THREAD);
    public static final ItemStack custard = new ItemStack(Core.food, 1, FoodMeta.CUSTARD);
    public static final ItemStack fishFinger = new ItemStack(Core.food, 1, FoodMeta.FISH_FINGER);
    public static final ItemStack fishNCustard = new ItemStack(Core.food, 1, FoodMeta.FISH_N_CUSTARD);
    public static final ItemStack fishMeal = new ItemStack(Core.materials, 1, MaterialsMeta.FISH_MEAL);
    public static final ItemStack calamari = new ItemStack(Core.food, 1, FoodMeta.CALAMARI);
    public static final ItemStack dropletAny = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, OreDictionary.WILDCARD_VALUE) : null;
    public static final ItemStack dropletAqua = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.AQUA) : null;
    public static final ItemStack dropletDestroy = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.ATTACK) : null;
    public static final ItemStack dropletEarth = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.EARTH) : null;
    public static final ItemStack dropletEnder = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.ENDER) : null;
    public static final ItemStack dropletFlux = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.ELECTRIC) : null;
    public static final ItemStack dropletFrozen = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.FROZEN) : null;
    public static final ItemStack dropletMagic = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.MAGIC) : null;
    public static final ItemStack dropletNether = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.NETHER) : null;
    public static final ItemStack dropletPlant = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.PLANT) : null;
    public static final ItemStack dropletPoison = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.POISON) : null;
    public static final ItemStack dropletRegen = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.HEALTH) : null;
    public static final ItemStack dropletWater = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.WATER) : null;
    public static final ItemStack dropletAir = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.droplet, 1, DropletMeta.AIR) : null;
    public static final ItemStack heating = new ItemStack(Core.crafting, 1, CraftingMeta.HEATER);
    public static final ItemStack cooling = new ItemStack(Core.crafting, 1, CraftingMeta.COOLER);
    public static final ItemStack dustMagnesium = new ItemStack(Core.materials, 1, MaterialsMeta.DUST_MAGNESITE);
    public static final ItemStack carbide = new ItemStack(Core.crafting, 1, CraftingMeta.CARBIDE);
    public static final ItemStack salt = new ItemStack(Core.materials, 1, MaterialsMeta.DUST_SALT);
    public static final ItemStack voidBottle = new ItemStack(Core.bottles, 1, BottleMeta.VOID);
    public static final ItemStack emptyBottle = new ItemStack(Core.bottles, 1, BottleMeta.EMPTY);
    public static final ItemStack bluePearl = new ItemStack(Core.pearls, 1, PearlColor.BLUE);
    public static final ItemStack whitePearl = new ItemStack(Core.pearls, 1, PearlColor.WHITE);
    public static final ItemStack redDye = new ItemStack(Core.materials, 1, MaterialsMeta.DYE_RED);
    public static final ItemStack yellowDye = new ItemStack(Core.materials, 1, MaterialsMeta.DYE_YELLOW);
    public static final ItemStack greenDye = new ItemStack(Core.materials, 1, MaterialsMeta.DYE_GREEN);
    public static final ItemStack brownDye = new ItemStack(Core.materials, 1, MaterialsMeta.DYE_BROWN);
    public static final ItemStack blueDye = new ItemStack(Core.materials, 1, MaterialsMeta.DYE_BLUE);
    public static final ItemStack thermometer = new ItemStack(Core.crafting, 1, CraftingMeta.THERMOMETER);
    public static final ItemStack fish = new ItemStack(Items.fish, 1, OreDictionary.WILDCARD_VALUE);
    public static final ItemStack oysterPie = new ItemStack(Core.food, 1, FoodMeta.OYSTER);
    public static final ItemStack polishedTitanium = new ItemStack(Core.crafting, 1, CraftingMeta.POLISHED_TITANIUM);
    public static final ItemStack fishingNet = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.net) : null;

    /** Module based stuff **/
    public static final ItemStack attack = Modules.isActive(Modules.fishery) ? dropletDestroy : new ItemStack(Items.potionitem, 1, 8204);
    public static final ItemStack poison = Modules.isActive(Modules.fishery) ? dropletPoison : new ItemStack(Items.potionitem, 1, 8228);
    public static final ItemStack boneless = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.boneless.getID()) : new ItemStack(Items.skull, 1, 1);
    public static final ItemStack undead = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.undead.getID()) : new ItemStack(Items.rotten_flesh);
    public static final ItemStack spider = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.spider.getID()) : new ItemStack(Items.spider_eye);
    public static final ItemStack night = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.night.getID()) : new ItemStack(Items.ender_pearl);
    public static final ItemStack ender = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.ender.getID()) : new ItemStack(Items.ender_eye);
    public static final ItemStack blaasop = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.blaasop.getID()) : new ItemStack(Items.potionitem, 1, 8196);
    public static final ItemStack filterer = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.net) : new ItemStack(Blocks.chest);
    public static final ItemStack regen = Modules.isActive(Modules.fishery) ? dropletRegen : new ItemStack(Items.potionitem, 1, 8229);
    public static final Object bait = Modules.isActive(Modules.fishery) ? new ItemStack(Fishery.bait, 1, OreDictionary.WILDCARD_VALUE) : Items.spider_eye;
    public static final Object sponge = Modules.isActive(Modules.worldplus) ? Blocks.sponge : Items.water_bucket;
    public static final ItemStack magicDrop = Modules.isActive(Modules.fishery) ? dropletMagic : new ItemStack(Items.ghast_tear);
    public static final Object waterDrop = Modules.isActive(Modules.fishery) ? dropletWater : new ItemStack(Items.potionitem, 1, 0);
    public static final Object rubber = OreDictionary.getOres("itemRubber").size() > 0 ? "itemRubber" : new ItemStack(Items.dye, 1, Dye.INK);
    public static final ItemStack polishedStick = Modules.isActive(Modules.fishery) ? new ItemStack(Core.crafting, 1, CraftingMeta.POLISHED_STICK) : new ItemStack(Items.blaze_rod);
    public static final ItemStack heart = Modules.isActive(Modules.fishery) ? dropletRegen : new ItemStack(Items.potionitem, 1, 8197);
    public static final ItemStack angelfish = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.angel.getID()) : new ItemStack(Items.golden_apple);
    public static final ItemStack aquatic = Modules.isActive(Modules.fishery) ? dropletAqua : new ItemStack(Items.potionitem, 1, 8269);
    public static final ItemStack koi = Modules.isActive(Modules.fishery) ? new ItemStack(Items.fish, 1, Fish.koi.getID()) : new ItemStack(Items.potionitem, 1, 8225);
    public static final ItemStack rotor = MaricultureHandlers.HIGH_TECH_ENABLED? new ItemStack(ExtensionFactory.turbineTitanium): titaniumSheet;
}
