package mariculture.core;

import mariculture.core.helpers.RecipeHelper;
import mariculture.core.items.ItemBattery;
import mariculture.core.lib.CraftingMeta;
import mariculture.core.lib.DoubleMeta;
import mariculture.core.lib.Dye;
import mariculture.core.lib.FluidContainerMeta;
import mariculture.core.lib.GlassMeta;
import mariculture.core.lib.GuideMeta;
import mariculture.core.lib.MaterialsMeta;
import mariculture.core.lib.MetalRates;
import mariculture.core.lib.Modules;
import mariculture.core.lib.OresMeta;
import mariculture.core.lib.PearlColor;
import mariculture.core.lib.SingleMeta;
import mariculture.core.lib.TankMeta;
import mariculture.core.lib.UpgradeMeta;
import mariculture.core.lib.UtilMeta;
import mariculture.core.lib.WoodMeta;
import mariculture.core.util.FluidDictionary;
import mariculture.fishery.Fishery;
import mariculture.plugins.PluginTConstruct;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void add() {
		RecipesSmelting.add();
		addCraftingItems();
		addMetalRecipes();
		addUpgradeRecipes();

	//Items
		//Copper Battery
		RecipeHelper.addShapedRecipe(ItemBattery.make(new ItemStack(Core.batteryCopper), 10000), new Object[] {
			" I ", "TRT", "TRT", 'I', "ingotIron", 'R', "dustRedstone", 'T', "ingotCopper"
		});

		//Titanium Battery
		RecipeHelper.addShapedRecipe(ItemBattery.make(new ItemStack(Core.batteryTitanium), 50000), new Object[] {
			" I ", "TRT", "TRT", 'I', "ingotIron", 'R', "dustRedstone", 'T', "ingotTitanium"
		});

		//Void Bottle
		RecipeHelper.addShapelessRecipe(new ItemStack(Core.liquidContainers, 8, FluidContainerMeta.BOTTLE_VOID), new Object[] {
			Item.glassBottle, "dustRedstone", new ItemStack(Item.dyePowder, 1, Dye.INK)
		});

	//Basic Blocks
		//Limestone Brick
		RecipeHelper.add4x4Recipe(new ItemStack(Core.oreBlocks, 4, OresMeta.LIMESTONE_BRICK), Core.oreBlocks, OresMeta.LIMESTONE);
		//Limestone Smooth
		RecipeHelper.add4x4Recipe(new ItemStack(Core.oreBlocks, 4, OresMeta.LIMESTONE_CHISELED), Core.oreBlocks, OresMeta.LIMESTONE_CHISELED);
		
		//Base Brick
		RecipeHelper.addShapedRecipe(new ItemStack(Core.oreBlocks, 1, OresMeta.BASE_BRICK), new Object[] {
			"IGI", "G G", "IGI", 'I', new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK), 'G', Block.fenceIron
		});
		
		//Base Iron
		RecipeHelper.addShapedRecipe(new ItemStack(Core.oreBlocks, 1, OresMeta.BASE_IRON), new Object[] {
			"IGI", "G G", "IGI", 'I', "ingotIron", 'G', Block.thinGlass
		});
		
		//Base Wood
		RecipeHelper.addShapedRecipe(new ItemStack(Core.woodBlocks, 1, WoodMeta.BASE_WOOD), new Object[] {
			"IGI", "G G", "IGI", 'I', "logWood", 'G', Block.fence
		});
		
	//Machines
		//Copper Tank
		RecipeHelper.addShapedRecipe(new ItemStack(Core.tankBlocks, 1, TankMeta.TANK), new Object[] {
			"CWC", "WGW", "CWC", 'C', "ingotCopper", 'W', "plankWood", 'G', "glass"
		});
				
		//Storage Bookshelf
		RecipeHelper.addShapedRecipe(new ItemStack(Core.utilBlocks, 1, UtilMeta.BOOKSHELF), new Object[] {
			"SPS", "PCP", "SSS", 'P', "plankWood", 'S', Block.bookShelf, 'C', Block.chest
		});
		
		//Crucible Furnace
		RecipeHelper.addShapedRecipe(new ItemStack(Core.utilBlocks, 1, UtilMeta.LIQUIFIER), new Object[] {
			" L ", "BGB", "HCH", 
			'B', new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK),
			'L', Item.bucketLava, 
			'G', "glass", 
			'H', new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER),
			'C', new ItemStack(Core.oreBlocks, 1, OresMeta.BASE_BRICK)
		});
		
		//Anvil Recipe
		RecipeHelper.addShapedRecipe(new ItemStack(Core.singleBlocks, 1, SingleMeta.ANVIL_1), new Object[] {
			"CCC", " B ", "BBB",
			'C', new ItemStack(Core.oreBlocks, 1, OresMeta.BASE_BRICK),
			'B', new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK)
		});

		//VAT Recipe
		RecipeHelper.addShapedRecipe(new ItemStack(Core.doubleBlock, 1, DoubleMeta.VAT), new Object[] {
			"C C", "C C", "CCC", 'C', "ingotCopper"
		});
		
		//Ingot Caster
		RecipeHelper.addShapedRecipe(new ItemStack(Core.singleBlocks, 1, SingleMeta.INGOT_CASTER), new Object[] {
			" B ", "BBB", " B ", 'B', new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK)
		});
		
		//Hammer
		RecipeHelper.addShapedRecipe(new ItemStack(Core.hammer), new Object[] {
			"PP ", " SP", "S  ",
			'P', new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK),
			'S', "stickWood"
		});
		
		//Smooth Limestone
		RecipeHelper.addSmelting(Core.oreBlocks.blockID, OresMeta.LIMESTONE, 
									new ItemStack(Core.oreBlocks, 1, OresMeta.LIMESTONE_SMOOTH), 0.1F);

		//Pearl Bricks
		for (int i = 0; i < 12; i++) {
			RecipeHelper.add4x4Recipe(new ItemStack(Core.pearlBrick, 1, i), new ItemStack(Core.pearls, 1, i));
			RecipeHelper.addUncraftingRecipe(new ItemStack(Core.pearls, 4, i), new ItemStack(Core.pearlBrick, 1, i));
		}
		
		//Piston
		RecipeHelper.addShapedRecipe(new ItemStack(Block.pistonBase, 1), new Object[] {
			"TTT", "#X#", "#R#", '#', "cobblestone", 'X', "ingotAluminum", 'R', "dustRedstone", 'T', "plankWood"
		});
		
		//Processing Book
		RecipeHelper.addShapelessRecipe(new ItemStack(Core.guides, 1, GuideMeta.PROCESSING), new Object[] {
			Item.book, new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK)
		});
	}

	private static void addCraftingItems() {
		//Golden Silk > 5 Seconds, 1 x Ingot Gold(mB) + String
		RecipeHelper.addVatItemRecipe(new ItemStack(Item.silk), FluidDictionary.gold, MetalRates.INGOT, 
				new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_SILK), 5);
		
		//Golden Thread
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_THREAD), new Object[] {
			"ABA", "ABA",
			'A', new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_SILK),
			'B', new ItemStack(Core.craftingItem, 1, CraftingMeta.POLISHED_STICK)
		});
	
		// Log > 30000mB of Fish Oil > 45 Seconds = 1 Polished Log (or 30000mB for 8 Sticks)
		RecipeHelper.addVatItemRecipe(new ItemStack(Block.wood), FluidDictionary.fish_oil, 30000, 
				new ItemStack(Core.woodBlocks, 1, WoodMeta.POLISHED_LOG), 45);
		//1 Plank = 9000mB > 30 Seconds = 1 Polished Plank (or 36000mB for 8 Sticks)
		RecipeHelper.addVatItemRecipe(new ItemStack(Block.planks), FluidDictionary.fish_oil, 10000, 
				new ItemStack(Core.woodBlocks, 1, WoodMeta.POLISHED_PLANK), 30);
		//1 Stick = 5000mB > 15 Seconds or (40000mB for 8 Sticks)
		RecipeHelper.addVatItemRecipe(new ItemStack(Item.stick), FluidDictionary.fish_oil, 5000, 
				new ItemStack(Core.craftingItem, 1, CraftingMeta.POLISHED_STICK), 15);
		
		//1 Polished Log = 4 Polished Planks
		RecipeHelper.addShapelessRecipe(new ItemStack(Core.woodBlocks, 4, WoodMeta.POLISHED_PLANK), new Object[] {
			new ItemStack(Core.woodBlocks, 1, WoodMeta.POLISHED_LOG)
		});
		
		//2 Polished Planks = 4 Polished Sticks
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 4, CraftingMeta.POLISHED_STICK), new Object[] {
			"S  ", "S  ", 'S', new ItemStack(Core.woodBlocks, 1, WoodMeta.POLISHED_PLANK)
		});
		
		//Titanium Rod >> 30 Seconds >> With Tinkers(6500mB Fish Oil + Tough Rod, without 2 Ingots Titanium + 2 Polished Sticks)
		if(Loader.isModLoaded("TConstruct")) {
			PluginTConstruct.addRod = true;
		} else {
			RecipeHelper.addVatItemRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.POLISHED_STICK), 
					FluidDictionary.titanium, MetalRates.INGOT * 2,  
					new ItemStack(Core.craftingItem, 1, CraftingMeta.ROD_TITANIUM), 30);
		}
		
		//Neoprene
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.NEOPRENE),  new Object[] { 
			"IPI", "PEP", "IPI", 
			'I', new ItemStack(Item.dyePowder, 1, Dye.INK), 
			'P', new ItemStack(Core.pearls, 1, OreDictionary.WILDCARD_VALUE), 
			'E', new ItemStack(Core.liquidContainers, 1, FluidContainerMeta.BOTTLE_GAS) 
		});
		
		//Plastic > 60 Seconds > 30 Buckets of Natural Gas + 16 Limestone
		RecipeHelper.addVatItemRecipe(new ItemStack(Core.oreBlocks, 16, OresMeta.LIMESTONE), FluidDictionary.natural_gas, 30000, 
				new ItemStack(Core.craftingItem, 1, CraftingMeta.PLASTIC), 60);
		
		//Plastic Lens
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.LENS), new Object[] { 
			" N ", "NGN", " N ", 
			'N', new ItemStack(Core.craftingItem, 1, CraftingMeta.NEOPRENE), 
			'G', new ItemStack(Core.glassBlocks, 1, GlassMeta.PLASTIC) 
		});
		
		//Glass Lens
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.LENS_GLASS), new Object[] {
			" P ", "PGP", " P ", 'P', "plankWood", 'G', "glass"
		});
		
		//Aluminum Sheet
		RecipeHelper.addAnvilRecipe(new ItemStack(Core.oreBlocks, 1, OresMeta.ALUMINUM_BLOCK), 
				new ItemStack(Core.craftingItem, 8, CraftingMeta.ALUMINUM_SHEET), 100);

		//Heating
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER), new Object[] {
			"CCC", "CCC", 'C', new ItemStack(Core.craftingItem, 1, CraftingMeta.CARBIDE)
		});

		//Cooling
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER), new Object[] {
			"  P", "PI ", "  P", 'P', "plankWood", 'I', "ingotIron"
		});
		
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER), new Object[] {
			" P ", " I ", "P P", 'P', "plankWood", 'I', "ingotIron"
		});
		
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER), new Object[] {
			"P  ", " IP", "P  ", 'P', "plankWood", 'I', "ingotIron"
		});
		
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER), new Object[] {
			"P P", " I ", " P ", 'P', "plankWood", 'I', "ingotIron"
		});

		//Carbide
		RecipeHelper.addShapedRecipe(new ItemStack(Core.craftingItem, 3, CraftingMeta.CARBIDE), new Object[] {
			"CSF", "FBS", "SFC", 'C', Item.clay, 'F', new ItemStack(Item.coal, 1, 0), 'S', Block.sand, 'B', Block.blockClay
		});

		//Wheel
		RecipeHelper.addWheelRecipe(new ItemStack(Core.craftingItem, 3, CraftingMeta.WHEEL), "slabWood", "ingotIron");
		
		//Wicker
		RecipeHelper.addCrossHatchRecipe(new ItemStack(Core.craftingItem, 1, CraftingMeta.WICKER), "stickWood", Item.reed);
		
		//Yellow Plastic > 5 Minutes > 1 Block of Gold(mB) + 4 Plastic
		RecipeHelper.addVatItemRecipe(new ItemStack(Core.craftingItem, 4, CraftingMeta.PLASTIC), 
				FluidDictionary.gold, MetalRates.BLOCK,  new ItemStack(Core.craftingItem, 1, CraftingMeta.PLASTIC_YELLOW), 60 * 5);
		
		//Titanium Sheet, 500 hits in an Anvil
		RecipeHelper.addAnvilRecipe(new ItemStack(Core.oreBlocks, 1, OresMeta.TITANIUM_BLOCK), 
				new ItemStack(Core.craftingItem, 8, CraftingMeta.TITANIUM_SHEET), 250);
		
		//Burnt Brick > Brick + 1000mB of Lava = Burnt Brick
		RecipeHelper.addVatItemRecipe(new ItemStack(Item.brick), "lava", 1000, 
												new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK), 16);
		
		//Burnt Brick > Nether Brick + 500mB of Lava
		RecipeHelper.addVatItemRecipe(new ItemStack(Item.netherrackBrick), "lava", 500, 
												new ItemStack(Core.craftingItem, 1, CraftingMeta.BURNT_BRICK), 8);
	}
	
	private static void addMetalRecipes() {		
		RecipeHelper.add9x9Recipe(new ItemStack(Core.oreBlocks, 1, OresMeta.MAGNESIUM_BLOCK), "ingotMagnesium");
		RecipeHelper.addUncraftingRecipe(new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_MAGNESIUM), "blockMagnesium");
		RecipeHelper.add9x9Recipe(new ItemStack(Core.oreBlocks, 1, OresMeta.TITANIUM_BLOCK), "ingotTitanium");
		RecipeHelper.addUncraftingRecipe(new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_TITANIUM), "blockTitanium");
		RecipeHelper.add9x9Recipe(new ItemStack(Core.oreBlocks, 1, OresMeta.ALUMINUM_BLOCK), "ingotAluminum");
		RecipeHelper.addUncraftingRecipe(new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_ALUMINUM), "blockAluminum");
		RecipeHelper.add9x9Recipe(new ItemStack(Core.oreBlocks, 1, OresMeta.COPPER_BLOCK), "ingotCopper");
		RecipeHelper.addUncraftingRecipe(new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_COPPER), "blockCopper");
		RecipeHelper.addSmelting(Core.oreBlocks.blockID, OresMeta.COPPER, 
									new ItemStack(Core.materials, 1, MaterialsMeta.INGOT_COPPER), 0.5F);
	}
	
	private static void addUpgradeRecipes() {
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_STORAGE), new Object[] {
						"WPW", "DCD", "WPW", Character.valueOf('D'), 
						Block.dirt, Character.valueOf('P'), "plankWood",
						Character.valueOf('C'), Block.chest, 
						Character.valueOf('W'), new ItemStack(Core.craftingItem, 1, CraftingMeta.WICKER) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_STORAGE), new Object[] {
						"PWP", "SUS", "PWP", 
						Character.valueOf('S'), "ingotCopper", 
						Character.valueOf('P'), "slabWood",
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_STORAGE),
						Character.valueOf('W'), new ItemStack(Core.craftingItem, 1, CraftingMeta.WICKER) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_STORAGE), new Object[] {
						"AWA", "MUM", "WAW", 
						Character.valueOf('A'), "ingotCopper", 
						Character.valueOf('M'), "ingotAluminum", 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_STORAGE), 
						Character.valueOf('W'), new ItemStack(Core.craftingItem, 1, CraftingMeta.WICKER) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ULTIMATE_STORAGE), new Object[] {
						"ATA", "WUW", "TCT", 
						Character.valueOf('A'), "ingotCopper", 
						Character.valueOf('T'), "ingotAluminum", 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_STORAGE), 
						Character.valueOf('W'), new ItemStack(Core.craftingItem, 1, CraftingMeta.WICKER), 
						Character.valueOf('C'), new ItemStack(Core.craftingItem, 1, CraftingMeta.WHEEL) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_COOLING), new Object[] {
						" S ", "CBC", " S ", 
						Character.valueOf('S'), Item.snowball, 
						Character.valueOf('B'), Block.blockSnow, 
						Character.valueOf('C'), new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_COOLING), new Object[] {
						"ACA", "SUS", "CAC", 
						Character.valueOf('S'), Item.snowball, 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_COOLING), 
						Character.valueOf('C'), new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER), 
						Character.valueOf('A'), "ingotAluminum" }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_COOLING), new Object[] {
						"CTC", "IUI", "TRT", 
						Character.valueOf('I'), Block.ice, 
						Character.valueOf('R'), "ingotIron",
						Character.valueOf('C'), new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER),
						Character.valueOf('T'), "ingotTitanium", 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_COOLING) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ULTIMATE_COOLING), new Object[] {
						"TCT", "IUI", "GDG", 
						Character.valueOf('I'), Block.ice, 
						Character.valueOf('G'), Item.ingotGold,
						Character.valueOf('C'), new ItemStack(Core.craftingItem, 1, CraftingMeta.COOLER),
						Character.valueOf('T'), "ingotTitanium", 
						Character.valueOf('D'), Item.diamond,
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_COOLING) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_HEATING), new Object[] {
						"HIH", 
						Character.valueOf('I'), "ingotIron", 
						Character.valueOf('H'), new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_HEATING), new Object[] {
						"A A", "HUH", " A ", 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_HEATING), 
						Character.valueOf('H'), new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER), 
						Character.valueOf('A'), "ingotAluminum" }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_HEATING), new Object[] {
						"IHI", "TUT", "IHI", 
						Character.valueOf('T'), "ingotTitanium", 
						Character.valueOf('I'), "ingotIron", 
						Character.valueOf('H'), new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER), 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_HEATING) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ULTIMATE_HEATING), new Object[] {
						"TDT", "HUH", "GTG", 
						Character.valueOf('G'), Item.ingotGold, 
						Character.valueOf('H'), new ItemStack(Core.craftingItem, 1, CraftingMeta.HEATER), 
						Character.valueOf('T'),
						"ingotTitanium", 
						Character.valueOf('D'), Item.diamond, 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_HEATING) }));
		
		ItemStack heart = (Modules.fishery.isActive())? new ItemStack(Core.materials, 1, MaterialsMeta.DROP_HEALTH): new ItemStack(Item.potion, 1, 8197);
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_PURITY), new Object[] {
						"MPM", "PIP", "MPM", 
						Character.valueOf('P'), new ItemStack(Core.pearls, 1, PearlColor.WHITE),
						Character.valueOf('I'), heart, 
						Character.valueOf('M'), "ingotAluminum" }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_PURITY), new Object[] {
						"PHP", "NUN", "MHM", 
						Character.valueOf('P'), new ItemStack(Core.pearls, 1, PearlColor.WHITE),
						Character.valueOf('H'), heart, 
						Character.valueOf('M'), "ingotAluminum",
						Character.valueOf('N'), "ingotTitanium",
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_PURITY) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_PURITY), new Object[] {
						"PSP", "AUA", "TPT", 
						Character.valueOf('P'), new ItemStack(Core.pearls, 1, PearlColor.WHITE),
						Character.valueOf('S'), new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_SILK),
						Character.valueOf('T'), "ingotTitanium", 
						Character.valueOf('A'), heart,
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_PURITY) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ULTIMATE_PURITY), new Object[] {
						"PSP", "TUT", "PAP", 
						Character.valueOf('P'), new ItemStack(Core.pearls, 1, PearlColor.WHITE),
						Character.valueOf('S'), new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_THREAD),
						Character.valueOf('T'), "ingotTitanium", 
						Character.valueOf('A'), heart,
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_PURITY) }));
		
		ItemStack attack = (Modules.fishery.isActive())? new ItemStack(Core.materials, 1, MaterialsMeta.DROP_ATTACK): new ItemStack(Item.potion, 1, 8204);
		ItemStack poison = (Modules.fishery.isActive())? new ItemStack(Core.materials, 1, MaterialsMeta.DROP_POISON): new ItemStack(Item.potion, 1, 8228);
		ItemStack night = (Modules.fishery.isActive())? new ItemStack(Fishery.fishyFood, 1, Fishery.night.fishID): new ItemStack(Item.enderPearl);
		ItemStack ender = (Modules.fishery.isActive())? new ItemStack(Fishery.fishyFood, 1, Fishery.ender.fishID): new ItemStack(Item.eyeOfEnder);
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_IMPURITY), new Object[] {
						"NWN", "ESE", "NGN", 
						Character.valueOf('N'), Block.netherrack, 
						Character.valueOf('W'), Item.netherStalkSeeds, 
						Character.valueOf('E'), Item.fermentedSpiderEye, 
						Character.valueOf('S'), attack,
						Character.valueOf('G'), Item.ingotGold }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_IMPURITY), new Object[] {
						"TGT", "SUS", "PFP", 
						Character.valueOf('T'), Item.ghastTear, 
						Character.valueOf('F'), Item.fermentedSpiderEye,
						Character.valueOf('P'), poison, 
						Character.valueOf('S'), attack, 
						Character.valueOf('G'),
						new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_SILK), 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.BASIC_IMPURITY) }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_IMPURITY), new Object[] {
						"HGH", "FUF", "SPS", 
						Character.valueOf('F'), night, 
						Character.valueOf('P'), poison, 
						Character.valueOf('H'), attack, 
						Character.valueOf('S'), Item.fermentedSpiderEye,
						Character.valueOf('G'), Block.blockGold, 
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.STANDARD_IMPURITY) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ULTIMATE_IMPURITY), new Object[] {
						"SGS", "PUP", "FSF", 
						Character.valueOf('F'), ender, 
						Character.valueOf('P'), poison, 
						Character.valueOf('S'), attack,
						Character.valueOf('G'), new ItemStack(Core.craftingItem, 1, CraftingMeta.GOLDEN_THREAD),
						Character.valueOf('U'), new ItemStack(Core.upgrade, 1, UpgradeMeta.ADVANCED_IMPURITY) }));
		
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Core.upgrade, 1, UpgradeMeta.ETHEREAL), new Object[] { "PUP",
						"GEG", "PDP", 
						Character.valueOf('P'), Item.enderPearl, 
						Character.valueOf('G'), Item.ingotGold,
						Character.valueOf('E'), Item.eyeOfEnder, 
						Character.valueOf('D'), Item.diamond,
						Character.valueOf('U'), Block.torchRedstoneActive }));
	}
}