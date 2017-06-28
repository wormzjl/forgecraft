package com.kitsu.medievalcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.cannon.CannonBallBlock28;
import com.kitsu.medievalcraft.block.cannon.Cannon_28;
import com.kitsu.medievalcraft.block.crucible.CrucibleIronIngot;
import com.kitsu.medievalcraft.block.crucible.CrucibleIronOre;
import com.kitsu.medievalcraft.block.crucible.CrucibleLapis;
import com.kitsu.medievalcraft.block.crucible.CrucibleRedstone;
import com.kitsu.medievalcraft.block.crucible.CrucibleWootz;
import com.kitsu.medievalcraft.block.crucible.empty.BoilingWaterCrucible;
import com.kitsu.medievalcraft.block.crucible.empty.EmptyCookedCrucible;
import com.kitsu.medievalcraft.block.crucible.empty.EmptySoftCrucible;
import com.kitsu.medievalcraft.block.crucible.empty.FilledWaterCrucible;
import com.kitsu.medievalcraft.block.crucible.empty.SlackWaterCrucible;
import com.kitsu.medievalcraft.block.crucible.empty.TanWaterCrucible;
import com.kitsu.medievalcraft.block.decorative.EggWashedBrick;
import com.kitsu.medievalcraft.block.decorative.EggWashedWall;
import com.kitsu.medievalcraft.block.decorative.LimestoneRaw;
import com.kitsu.medievalcraft.block.fluid.BlockFilteredWater;
import com.kitsu.medievalcraft.block.fluid.BlockSlackedLime;
import com.kitsu.medievalcraft.block.fluid.BlockSmoke;
import com.kitsu.medievalcraft.block.fluid.BlockTannin;
import com.kitsu.medievalcraft.block.ingots.DamascusIngot;
import com.kitsu.medievalcraft.block.ingots.Diamond;
import com.kitsu.medievalcraft.block.ingots.Emerald;
import com.kitsu.medievalcraft.block.ingots.IronPlate;
import com.kitsu.medievalcraft.block.ingots.LapisIngot;
import com.kitsu.medievalcraft.block.ingots.RedstoneIngot;
import com.kitsu.medievalcraft.block.ingots.RefinedIron;
import com.kitsu.medievalcraft.block.machines.Firebox;
import com.kitsu.medievalcraft.block.machines.Forge;
import com.kitsu.medievalcraft.block.machines.ForgeAnvil;
import com.kitsu.medievalcraft.block.machines.SolidFilter;
import com.kitsu.medievalcraft.block.machines.TestForge;
import com.kitsu.medievalcraft.block.machines.WaterFilter;
import com.kitsu.medievalcraft.block.machines.formTable;
import com.kitsu.medievalcraft.block.wood.ShelfFour;
import com.kitsu.medievalcraft.block.wood.SmallBarrel;
import com.kitsu.medievalcraft.block.wood.SmallBarrelLid;
import com.kitsu.medievalcraft.block.wood.clean.CleanAcacia;
import com.kitsu.medievalcraft.block.wood.clean.CleanBirch;
import com.kitsu.medievalcraft.block.wood.clean.CleanDarkOak;
import com.kitsu.medievalcraft.block.wood.clean.CleanJungle;
import com.kitsu.medievalcraft.block.wood.clean.CleanOak;
import com.kitsu.medievalcraft.block.wood.clean.CleanSpruce;
import com.kitsu.medievalcraft.block.wood.quartersplit.AcaciaSplitLog;
import com.kitsu.medievalcraft.block.wood.quartersplit.BirchSplitLog;
import com.kitsu.medievalcraft.block.wood.quartersplit.DarkSplitLog;
import com.kitsu.medievalcraft.block.wood.quartersplit.JungleSplitLog;
import com.kitsu.medievalcraft.block.wood.quartersplit.OakSplitLog;
import com.kitsu.medievalcraft.block.wood.quartersplit.SpruceSplitLog;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	
	//NEW INGOTS
	public static Block refinedIron;
	public static Block damascus;
	public static Block ironPlate;
	public static Block redstoneIngot;
	public static Block lapisIngot;
	
	//NEW CRUCIBLES
	public static Block testBlock;
	public static Block crucibleIronOre;
	public static Block crucibleIronIngot;
	public static Block crucibleWootz;
	public static Block crucibleLapis;
	public static Block crucibleRedstone;
	
	//AESTHETIC
	public static Block shitblock;
	public static Block eggWashedWall;
	public static Block eggWashedBrick;
	public static Block wootzOre;
	public static Block limestoneRaw;
	
	//LIQUIDS
	public static Block blockSmoke;
	public static Block blockFilteredWater;
	public static Fluid fluidFiltered; 
	public static Block blockTannin;
	public static Fluid fluidTan;
	public static Block blockSlackedLime;
	public static Fluid fluidSlackedLime;
	
	//WOODEN BLOCKS
	public static Block cleanOak;
	public static Block cleanAcacia;
	public static Block cleanJungle;
	public static Block cleanSpruce;
	public static Block cleanBirch;
	public static Block cleanDarkOak;
	//SPLIT LOGS
	public static Block acaciaSplitLog;
	public static Block birchSplitLog;
	public static Block darkSplitLog;
	public static Block jungleSplitLog;
	public static Block oakSplitLog;
	public static Block spruceSplitLog;
	public static Block smallBarrelLid;
	public static Block smallBarrel;	
	
	//MACHINES
	public static Block formtable;
	//public static Block newForge;
	//public static Block testForge;
	public static Block forgeAnvil;
	public static Block waterFilter;
	public static Block shelfFour;
	public static Block firebox;
	public static Block solidFilter;
	public static Block forge;
	
	//CANNONS
	public static Block cannon_28;
	public static Block cannonBall_28;
	
	//GEMS
	public static Block myDiamond, myEmerald;
	//IRON INGOTS
	//public static Block myIronIngot, hotIronBlock;
	//IRON PLATES
	//public static Block ironPlate, hotIronPlate;
	//DAMASCUS INGOTS
	//public static Block damascusIngot, hotDamascusIngot;
	//LAPIS INGOTS
	//public static Block lapisIngot, hotLapisIngot;
	//REDSTONE INGOTS
	//public static Block redstoneIngot, hotRedstoneIngot;
	
	//Empty Crucible Soft --> Cooked
	public static Block emptySoftCrucible;
	public static Block emptyCookedCrucible;
	public static Block filledWaterCrucible;
	public static Block boilingWaterCrucible;
	public static Block tanWaterCrucible;
	public static Block slackWaterCrucible;
	
	public static final void init() {
		
		GameRegistry.registerBlock(testBlock = new TestBlock("testBlock", Material.rock), "testBlock");
		
		Fluid fluidSmoke = new Fluid("blocksmoke").setDensity(-1000).setTemperature(310).setGaseous(true).setBlock(blockSmoke).setViscosity(0);
		FluidRegistry.registerFluid(fluidSmoke);
		blockSmoke = new BlockSmoke(fluidSmoke, Material.water).setBlockName("blockSmoke");
		GameRegistry.registerBlock(blockSmoke, Main.MODID + "_" + blockSmoke.getUnlocalizedName().substring(5));
		fluidSmoke.setUnlocalizedName(blockSmoke.getUnlocalizedName());
		
		fluidFiltered = new Fluid("blockFilteredWater").setDensity(1000).setTemperature(295).setGaseous(false).setBlock(blockFilteredWater).setViscosity(1000);
		FluidRegistry.registerFluid(fluidFiltered);
		blockFilteredWater = new BlockFilteredWater(fluidFiltered, Material.water).setBlockName("blockFilteredWater");
		GameRegistry.registerBlock(blockFilteredWater, Main.MODID + "_" + blockFilteredWater.getUnlocalizedName().substring(5));
		fluidFiltered.setUnlocalizedName(blockFilteredWater.getUnlocalizedName());
		
		fluidTan = new Fluid("blockTannin").setDensity(1000).setTemperature(295).setGaseous(false).setBlock(blockTannin).setViscosity(1000);
		FluidRegistry.registerFluid(fluidTan);
		blockTannin = new BlockTannin(fluidTan, Material.water).setBlockName("blockTannin");
		GameRegistry.registerBlock(blockTannin, Main.MODID + "_" + blockTannin.getUnlocalizedName().substring(5));
		fluidTan.setUnlocalizedName(blockTannin.getUnlocalizedName());		

		fluidSlackedLime = new Fluid("blockSlackedLime").setGaseous(false).setBlock(blockSlackedLime).setViscosity(2000).setDensity(1500).setTemperature(400);
		FluidRegistry.registerFluid(fluidSlackedLime);
		blockSlackedLime = new BlockSlackedLime(fluidSlackedLime, Material.water).setBlockName("blockSlackedLime");
		GameRegistry.registerBlock(blockSlackedLime, Main.MODID + "_" + blockSlackedLime.getUnlocalizedName().substring(5));
		fluidSlackedLime.setUnlocalizedName(blockSlackedLime.getUnlocalizedName());
		
		GameRegistry.registerBlock(limestoneRaw = new LimestoneRaw("limestoneRaw", Material.rock), "limestoneRaw");
		GameRegistry.registerBlock(shitblock = new shitBlock("shitBlock", Material.clay), "shitBlock");
		GameRegistry.registerBlock(eggWashedWall = new EggWashedWall("eggWashedWall", Material.rock), "eggWashedWall");
		GameRegistry.registerBlock(eggWashedBrick = new EggWashedBrick("eggWashedBrick", Material.rock), "eggWashedBrick");
		GameRegistry.registerBlock(wootzOre = new WootzOre("wootzOre", Material.rock), "wootzOre");
		
		GameRegistry.registerBlock(formtable = new formTable("formTable", Material.wood), "formTable");
		//GameRegistry.registerBlock(testForge = new TestForge("TestForge", Material.iron), "TestForge");
		GameRegistry.registerBlock(forgeAnvil = new ForgeAnvil("forgeAnvil", Material.iron), "forgeAnvil");
		GameRegistry.registerBlock(waterFilter = new WaterFilter("waterFilter", Material.iron), "waterFilter");
		//GameRegistry.registerBlock(sandFilter = new SandFilter("sandFilter", Material.wood), "sandFilter");
		//GameRegistry.registerBlock(sandFilterEmpty = new SandFilterEmpty("sandFilterEmpty", Material.wood), "sandFilterEmpty");
		GameRegistry.registerBlock(solidFilter = new SolidFilter("solidFilter", Material.wood), "solidFilter");
		GameRegistry.registerBlock(shelfFour = new ShelfFour("shelfFour", Material.wood), "shelfFour");
		GameRegistry.registerBlock(firebox = new Firebox("firebox", Material.rock), "firebox");
		GameRegistry.registerBlock(forge = new Forge("forge", Material.rock), "forge");
		
		GameRegistry.registerBlock(cannon_28 = new Cannon_28("cannon_28", Material.iron), "cannon_28");
		GameRegistry.registerBlock(cannonBall_28 = new CannonBallBlock28("cannonBallBlock_28", Material.iron), "cannonBallBlock_28");
		
		/*GameRegistry.registerBlock(myIronIngot = new MyIronIngot("myIronIngot", Material.iron), "myIronIngot");
		GameRegistry.registerBlock(damascusIngot = new DamascusIngot("damascusIngot", Material.iron), "damascusIngot");
		GameRegistry.registerBlock(hotDamascusIngot = new HotDamascusIngot("hotDamascusIngot", Material.iron), "hotDamascusIngot");
		GameRegistry.registerBlock(hotIronBlock = new HotIronBlock("hotIronBlock", Material.iron), "hotIronBlock");
		GameRegistry.registerBlock(ironPlate = new IronPlate("ironPlate", Material.iron), "ironPlate");
		GameRegistry.registerBlock(hotIronPlate = new HotIronPlate("hotIronPlate", Material.iron), "hotIronPlate");
		GameRegistry.registerBlock(myDiamond = new Diamond("myDiamond", Material.glass), "myDiamond");
		GameRegistry.registerBlock(myEmerald = new Emerald("myEmerald", Material.glass), "myEmerald");
		GameRegistry.registerBlock(redstoneIngot = new RedstoneIngot("redstoneIngot", Material.rock), "redstoneIngot");
		GameRegistry.registerBlock(hotRedstoneIngot = new HotRedstoneIngot("hotRedstoneIngot", Material.rock), "hotRedstoneIngot");
		GameRegistry.registerBlock(lapisIngot = new LapisIngot("lapisIngot", Material.rock), "lapisIngot");
		GameRegistry.registerBlock(hotLapisIngot = new HotLapisIngot("hotLapisIngot", Material.rock), "hotLapisIngot");*/
		
		//CLEAN WOOD
		/*
	public static Block acaciaSplitLog;
	public static Block birchSplitLog;
	public static Block darkSplitLog;
	public static Block jungleSplitLog;
	public static Block oakSplitLog;
	public static Block spruceSplitLog;
		 * */
		GameRegistry.registerBlock(cleanOak = new CleanOak("cleanOak", Material.wood), "cleanOak");
		GameRegistry.registerBlock(cleanAcacia = new CleanAcacia("cleanAcacia", Material.wood), "cleanAcacia");
		GameRegistry.registerBlock(cleanJungle = new CleanJungle("cleanJungle", Material.wood), "cleanJungle");
		GameRegistry.registerBlock(cleanDarkOak = new CleanDarkOak("cleanDarkOak", Material.wood), "cleanDarkOak");
		GameRegistry.registerBlock(cleanBirch = new CleanBirch("cleanBirch", Material.wood), "cleanBirch");
		GameRegistry.registerBlock(cleanSpruce = new CleanSpruce("cleanSpruce", Material.wood), "cleanSpruce");
		
		GameRegistry.registerBlock(acaciaSplitLog = new AcaciaSplitLog("acaciaSplitLog", Material.wood), "acaciaSplitLog");
		GameRegistry.registerBlock(birchSplitLog = new BirchSplitLog("birchSplitLog", Material.wood), "birchSplitLog");
		GameRegistry.registerBlock(darkSplitLog = new DarkSplitLog("darkSplitLog", Material.wood), "darkSplitLog");
		GameRegistry.registerBlock(jungleSplitLog = new JungleSplitLog("jungleSplitLog", Material.wood), "jungleSplitLog");
		GameRegistry.registerBlock(oakSplitLog = new OakSplitLog("oakSplitLog", Material.wood), "oakSplitLog");
		GameRegistry.registerBlock(spruceSplitLog = new SpruceSplitLog("spruceSplitLog", Material.wood), "spruceSplitLog");
		
		GameRegistry.registerBlock(smallBarrelLid = new SmallBarrelLid("smallBarrelLid", Material.wood), "smallBarrelLid");
		GameRegistry.registerBlock(smallBarrel = new SmallBarrel("smallBarrel", Material.wood), "smallBarrel");
		
		//Empty Crucible
		GameRegistry.registerBlock(emptySoftCrucible = new EmptySoftCrucible("emptySoftCrucible", Material.clay), "emptySoftCrucible");
		GameRegistry.registerBlock(emptyCookedCrucible = new EmptyCookedCrucible("emptyCookedCrucible", Material.rock), "emptyCookedCrucible");
		GameRegistry.registerBlock(filledWaterCrucible = new FilledWaterCrucible("filledWaterCrucible", Material.rock), "filledWaterCrucible");
		GameRegistry.registerBlock(boilingWaterCrucible = new BoilingWaterCrucible("boilingWaterCrucible", Material.rock), "boilingWaterCrucible");
		GameRegistry.registerBlock(tanWaterCrucible = new TanWaterCrucible("tanWaterCrucible", Material.rock), "tanWaterCrucible");
		GameRegistry.registerBlock(slackWaterCrucible = new SlackWaterCrucible("slackWaterCrucible", Material.rock), "slackWaterCrucible");
		
		//CRUCIBLE REGISTRY
		GameRegistry.registerBlock(crucibleIronOre = new CrucibleIronOre(Material.rock, "crucibleIronOre"), "crucibleIronOre");
		GameRegistry.registerBlock(crucibleIronIngot = new CrucibleIronIngot(Material.rock, "crucibleIronIngot"), "crucibleIronIngot");
		GameRegistry.registerBlock(crucibleWootz = new CrucibleWootz(Material.rock, "crucibleWootz"), "crucibleWootz");
		GameRegistry.registerBlock(crucibleLapis = new CrucibleLapis(Material.rock, "crucibleLapis"), "crucibleLapis");
		GameRegistry.registerBlock(crucibleRedstone = new CrucibleRedstone(Material.rock, "crucibleRedstone"), "crucibleRedstone");
		
		//INGOT REGISTRY
		GameRegistry.registerBlock(refinedIron = new RefinedIron("refinedIron", Material.rock), "refinedIron");
		GameRegistry.registerBlock(damascus = new DamascusIngot("damascus", Material.rock), "damascus");
		GameRegistry.registerBlock(ironPlate = new IronPlate("ironPlate", Material.iron), "ironPlate");
		GameRegistry.registerBlock(redstoneIngot = new RedstoneIngot("redstoneIngot", Material.rock), "redstoneIngot");
		GameRegistry.registerBlock(lapisIngot = new LapisIngot("lapisIngot", Material.rock), "lapisIngot");
		
		GameRegistry.registerBlock(myDiamond = new Diamond("myDiamond", Material.glass), "myDiamond");
		GameRegistry.registerBlock(myEmerald = new Emerald("myEmerald", Material.glass), "myEmerald");
	}
}