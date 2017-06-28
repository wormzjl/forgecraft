package com.kitsu.medievalcraft.renderer;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.blocks.BarrelLidRender;
import com.kitsu.medievalcraft.renderer.blocks.SmallBarrelRender;
import com.kitsu.medievalcraft.renderer.blocks.TestBlockRenderer;
import com.kitsu.medievalcraft.renderer.blocks.cannons.Render_CannonBall_Iron_Block;
import com.kitsu.medievalcraft.renderer.blocks.cannons.Render_Cannon_28;
import com.kitsu.medievalcraft.renderer.blocks.crucibles.IronOreCrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.crucibles.LapisCrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.crucibles.RedstoneCrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.crucibles.WootzCrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.BoilCrucibleRender;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.ECCrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.SECrucibleRenderer;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.SlackCrucibleRender;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.TanCrucibleRender;
import com.kitsu.medievalcraft.renderer.blocks.emptycrucibles.WaterCrucibleRender;
import com.kitsu.medievalcraft.renderer.blocks.ingot.DamascusIngotRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.IronIngotRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.IronPlateRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.LapisIngotRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.MyDiamondRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.MyEmeraldRenderer;
import com.kitsu.medievalcraft.renderer.blocks.ingot.RedstoneIngotRenderer;
import com.kitsu.medievalcraft.renderer.blocks.machine.FireboxRenderer;
import com.kitsu.medievalcraft.renderer.blocks.machine.ForgeAnvilRenderer;
import com.kitsu.medievalcraft.renderer.blocks.machine.ForgeRenderer;
import com.kitsu.medievalcraft.renderer.blocks.machine.FourShelfRenderer;
import com.kitsu.medievalcraft.renderer.blocks.machine.SolidFilterRender;
import com.kitsu.medievalcraft.renderer.blocks.machine.WaterFilterRenderer;
import com.kitsu.medievalcraft.renderer.itemrenderer.IRITSpear;
import com.kitsu.medievalcraft.renderer.itemrenderer.ItemRendererITModelArrow;
import com.kitsu.medievalcraft.renderer.itemrenderer.ItemRendererLongbow;
import com.kitsu.medievalcraft.renderer.itemrenderer.ItemRendererModelArrow;
import com.kitsu.medievalcraft.renderer.itemrenderer.cannons.IR_CannonBall_28;
import com.kitsu.medievalcraft.renderer.itemrenderer.cannons.IR_Cannon_28;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.IRCrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.empty.IRSlackCrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.empty.IRTanninCrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.empty.IRWaterCrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.empty.ItemRendererECCrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.crucibles.empty.ItemRendererSECrucible;
import com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates.DamascusIngotIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates.IronIngotIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates.IronPlateIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates.LapisIngotIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates.RedstoneIngotIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.ForgeIR;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRBarrelLid;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRFirebox;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRForgeAnvil;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRShelfFour;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRSmallBarrel;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRSolidFilter;
import com.kitsu.medievalcraft.renderer.itemrenderer.machines.IRWaterFilter;
import com.kitsu.medievalcraft.renderer.itemrenderer.tongs.IRSlottedTongs;
import com.kitsu.medievalcraft.renderer.itemrenderer.tools.IRForgeHammer;
import com.kitsu.medievalcraft.renderer.itemrenderer.tools.IRInlayHammer;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.IRBattleAxe;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.IRGladius;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.ItemRenderHeavymace;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.ItemRenderLongsword;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.ItemRenderWoodenShield;
import com.kitsu.medievalcraft.renderer.itemrenderer.weapons.NewIronShield;
import com.kitsu.medievalcraft.tileents.TileEntitySmallBarrel;
import com.kitsu.medievalcraft.tileents.TileEntitySmallLid;
import com.kitsu.medievalcraft.tileents.TileEntityTestBlock;
import com.kitsu.medievalcraft.tileents.cannon.TileCannonBall28;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleIronOre;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleLapis;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleRedstone;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleWootz;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityBoilingWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityEmptyCookedCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityFilledWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySlackWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySoftEmptyCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityTanWaterCrucible;
import com.kitsu.medievalcraft.tileents.ingots.TileDamascus;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyDiamond;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyEmerald;
import com.kitsu.medievalcraft.tileents.ingots.TileIronPlate;
import com.kitsu.medievalcraft.tileents.ingots.TileLapisIngot;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.tileents.ingots.TileRedstoneIngot;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.tileents.machine.TileEntityShelfFour;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;
import com.kitsu.medievalcraft.tileents.machine.TileEntityWaterFilter;
import com.kitsu.medievalcraft.tileents.machine.TileForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class RendererRegistry {

	public static final void init() {
    	MinecraftForgeClient.registerItemRenderer(ModItems.woodenShield, new ItemRenderWoodenShield());
    	MinecraftForgeClient.registerItemRenderer(ModItems.ironShield, new NewIronShield());
    	
    	MinecraftForgeClient.registerItemRenderer(ModItems.longSword, new ItemRenderLongsword());
    	MinecraftForgeClient.registerItemRenderer(ModItems.heavyMace, new ItemRenderHeavymace());
    	MinecraftForgeClient.registerItemRenderer(ModItems.battleAxe, new IRBattleAxe());
    	MinecraftForgeClient.registerItemRenderer(ModItems.gladius, new IRGladius());
    	//MinecraftForgeClient.registerItemRenderer(ModItems.workBlade, new IRCraftingBlade());
    	
    	MinecraftForgeClient.registerItemRenderer(ModItems.slottedTongs, new IRSlottedTongs());

    	MinecraftForgeClient.registerItemRenderer(ModItems.longbow, new ItemRendererLongbow());
    	
    	MinecraftForgeClient.registerItemRenderer(ModItems.forgeHammer, new IRForgeHammer());
    	MinecraftForgeClient.registerItemRenderer(ModItems.inlayHammer, new IRInlayHammer());
    	//MinecraftForgeClient.registerItemRenderer(ModItems.customIronPick, new IRironPicks());
    	
    	MinecraftForgeClient.registerItemRenderer(ModItems.itemModelArrow, new ItemRendererModelArrow());
    	MinecraftForgeClient.registerItemRenderer(ModItems.itemIronTippedModelArrow, new ItemRendererITModelArrow());
    	MinecraftForgeClient.registerItemRenderer(ModItems.itemITSpear, new IRITSpear());
    	
    	
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cannon_28), new IR_Cannon_28());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cannonBall_28), new IR_CannonBall_28());
    	
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.emptySoftCrucible), new ItemRendererSECrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.emptyCookedCrucible), new ItemRendererECCrucible());

    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.forgeAnvil), new IRForgeAnvil());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.waterFilter), new IRWaterFilter());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.solidFilter), new IRSolidFilter());

    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.filledWaterCrucible), new IRWaterCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.boilingWaterCrucible), new IRWaterCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.tanWaterCrucible), new IRTanninCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.slackWaterCrucible), new IRSlackCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.smallBarrel), new IRSmallBarrel());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.smallBarrelLid), new IRBarrelLid());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.shelfFour), new IRShelfFour());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.firebox), new IRFirebox());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.forge), new ForgeIR());
    	
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crucibleIronOre), new IRCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crucibleIronIngot), new IRCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crucibleWootz), new IRCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crucibleLapis), new IRCrucible());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crucibleRedstone), new IRCrucible());
    	
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.refinedIron), new IronIngotIR());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.damascus), new DamascusIngotIR());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.ironPlate), new IronPlateIR());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.lapisIngot), new LapisIngotIR());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.redstoneIngot), new RedstoneIngotIR());

    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoftEmptyCrucible.class, new SECrucibleRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmptyCookedCrucible.class, new ECCrucibleRenderer());

    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvilForge.class, new ForgeAnvilRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMyDiamond.class, new MyDiamondRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMyEmerald.class, new MyEmeraldRenderer());

    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterFilter.class, new WaterFilterRenderer());

    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTanWaterCrucible.class, new TanCrucibleRender());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilledWaterCrucible.class, new WaterCrucibleRender());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoilingWaterCrucible.class, new BoilCrucibleRender());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySlackWaterCrucible.class, new SlackCrucibleRender());
       	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolidFilter.class, new SolidFilterRender());
       	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallLid.class, new BarrelLidRender());
       	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallBarrel.class, new SmallBarrelRender());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelfFour.class, new FourShelfRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirebox.class, new FireboxRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirebox.class, new FireboxRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileForge.class, new ForgeRenderer());
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCrucibleLapis.class, new LapisCrucibleRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCrucibleIronOre.class, new IronOreCrucibleRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCrucibleWootz.class, new WootzCrucibleRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCrucibleRedstone.class, new RedstoneCrucibleRenderer());
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileMyIronIngot.class, new IronIngotRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileDamascus.class, new DamascusIngotRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileIronPlate.class, new IronPlateRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileRedstoneIngot.class, new RedstoneIngotRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileLapisIngot.class, new LapisIngotRenderer());
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCannon_28.class, new Render_Cannon_28());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileCannonBall28.class, new Render_CannonBall_Iron_Block());
    	
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestBlock.class, new TestBlockRenderer());
    	
    	
      	
    	
	}
	
}
