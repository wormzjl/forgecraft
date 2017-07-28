package com.kitsu.medievalcraft;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.compat.FuelHandler;
import com.kitsu.medievalcraft.compat.ModDict;
import com.kitsu.medievalcraft.crafting.CraftingHandle;
import com.kitsu.medievalcraft.crafting.ModCrafting;
import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.entity.EntityITSpear;
import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.EntityModelITArrow;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.entity.EntityShortLivedShit;
import com.kitsu.medievalcraft.entity.EntityTester;
import com.kitsu.medievalcraft.events.BucketHandle;
import com.kitsu.medievalcraft.events.EventHandle;
import com.kitsu.medievalcraft.gui.GuiHandler;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgHandleCuredLeatherX;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgHandleCuredLeatherY;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgHandleCuredLeatherZ;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherX;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherY;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherZ;
import com.kitsu.medievalcraft.packethandle.forge.MsgHandleForge;
import com.kitsu.medievalcraft.packethandle.forge.MsgPacketForge;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgHandle;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgHandleLocX;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgHandleLocY;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgHandleLocZ;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacket;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocX;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocY;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocZ;
import com.kitsu.medievalcraft.packethandle.sandFilterRender.MsgHandleSandFilterRender;
import com.kitsu.medievalcraft.packethandle.sandFilterRender.MsgPacketSandFilterRender;
import com.kitsu.medievalcraft.packethandle.shelf.MsgHandleShelfCase;
import com.kitsu.medievalcraft.packethandle.shelf.MsgPacketShelfCase;
import com.kitsu.medievalcraft.tileents.TileEntRegister;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	public static final String MODID = "kitsumedievalcraft";
	public static final String MODNAME = "ForgeCraft";
	public static final String VERSION = "2.4.1";

	public static SimpleNetworkWrapper sNet;

	@Instance
	public static Main instance = new Main();

	@SidedProxy(clientSide="com.kitsu.medievalcraft.ClientProxy", serverSide="com.kitsu.medievalcraft.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * Run before anything else. Read your config, create blocks, items, etc, and 
	 * register them with the GameRegistry.
	 */
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);

		sNet = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
		sNet.registerMessage(MsgHandle.class, MsgPacket.class, 1, Side.CLIENT);
		sNet.registerMessage(MsgHandleLocX.class, MsgPacketLocX.class, 2, Side.CLIENT);
		sNet.registerMessage(MsgHandleLocY.class, MsgPacketLocY.class, 3, Side.CLIENT);
		sNet.registerMessage(MsgHandleLocZ.class, MsgPacketLocZ.class, 4, Side.CLIENT);
		sNet.registerMessage(MsgHandleSandFilterRender.class, MsgPacketSandFilterRender.class, 5, Side.CLIENT);
		sNet.registerMessage(MsgHandleCuredLeatherX.class, MsgPacketCuredLeatherX.class, 6, Side.SERVER);
		sNet.registerMessage(MsgHandleCuredLeatherY.class, MsgPacketCuredLeatherY.class, 7, Side.SERVER);
		sNet.registerMessage(MsgHandleCuredLeatherZ.class, MsgPacketCuredLeatherZ.class, 8, Side.SERVER);
		sNet.registerMessage(MsgHandleShelfCase.class, MsgPacketShelfCase.class, 9, Side.SERVER);
		sNet.registerMessage(MsgHandleForge.class, MsgPacketForge.class, 10, Side.SERVER);
		//sNet.registerMessage(MsgHandleCannon.class, MsgPacketCannon.class, 11, Side.CLIENT);
		//sNet.registerMessage(MsgHandleCannon.class, MsgPacketCannon.class, 12, Side.SERVER);
		//sNet.registerMessage(MsgHandleCannonX.class, MsgPacketCannonX.class, 12, Side.CLIENT);
		//sNet.registerMessage(MsgHandleCannonY.class, MsgPacketCannonY.class, 13, Side.CLIENT);
		//sNet.registerMessage(MsgHandleCannonZ.class, MsgPacketCannonZ.class, 14, Side.CLIENT);
		
		CustomTab.MedievalTab();
		ModBlocks.init();
		ModItems.init();
		ModCrafting.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		
		this.proxy.init(e);

		FMLCommonHandler.instance().bus().register(new CraftingHandle());
		FMLCommonHandler.instance().bus().register(new EventHandle());
		
		MinecraftForge.EVENT_BUS.register(BucketHandle.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new EventHandle());
		MinecraftForge.EVENT_BUS.register(new CraftingHandle());

		BucketHandle.INSTANCE.buckets.put(ModBlocks.blockFilteredWater, ModItems.filteredBucket);
		BucketHandle.INSTANCE.buckets.put(ModBlocks.blockTannin, ModItems.tanninBucket);
		BucketHandle.INSTANCE.buckets.put(ModBlocks.blockSlackedLime, ModItems.slackBucket);
		
		EntityRegistry.registerModEntity(EntityShit.class, "itemShit", 1, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityModelArrow.class, "itemModelArrow", 2, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityModelITArrow.class, "itemIronTippedModelArrow", 3, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityITSpear.class, "itemITSpear", 4, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityTester.class, "itemTester", 5, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityShortLivedShit.class, "itemShit", 6, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityCannonBall.class, "cannonBall", 7, this, 64, 10, true);
		//EntityRegistry.registerModEntity(ProjectileCannonBall.class, "cannonBallProjectile", 8, this, 64, 10, true);

		GameRegistry.registerFuelHandler(new FuelHandler());

		TileEntRegister.init();

	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
		this.proxy.registerRenderer();
		this.proxy.registerItemRenderers();
		this.proxy.registerSounds();
		ModDict.RegisterOres();
		System.out.println("U want some Body Massage?");
		//RenderingRegistry.registerEntityRenderingHandler(EntityShit.class, new RenderSnowball(ModItems.itemShit));
	}
}

