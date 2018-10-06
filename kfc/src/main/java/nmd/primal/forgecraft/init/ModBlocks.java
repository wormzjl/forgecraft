package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.blocks.Anvil.AnvilIron;
import nmd.primal.forgecraft.blocks.Anvil.AnvilStone;
import nmd.primal.forgecraft.blocks.Chisel;
import nmd.primal.forgecraft.blocks.Crucibles.NBTCrucible;
import nmd.primal.forgecraft.blocks.YewStave;
import nmd.primal.forgecraft.blocks.machine.*;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block nbtCrucible;
    public static Block forge_brick;
    public static Block forge_adobe;
    public static Block bloomery_brick;
    public static Block bloomery_adobe;
    public static Block blockbreaker;
    public static Block castingform;

    public static Block bronzechisel;
    public static Block copperchisel;
    public static Block ironchisel;
    public static Block cleanironchisel;
    public static Block steelchisel;
    public static Block wootzchisel;

    public static Block pistonbellowsoak;
    public static Block pistonbellowsjungle;
    public static Block pistonbellowsbirch;
    public static Block pistonbellowsspruce;
    public static Block pistonbellowsdarkoak;
    public static Block pistonbellowsacacia;

    public static Block stoneanvil;
    public static Block ironanvil;

    public static Block yewstave;

    public static void init() {

        nbtCrucible = new NBTCrucible(Material.ROCK, "nbtcrucible");
        forge_brick = new Forge(Material.ROCK, "forge_brick", 5000);
        forge_adobe = new Forge(Material.ROCK, "forge_adobe", 5000);
        bloomery_brick = new BloomeryBase(Material.ROCK, "bloomery_brick", 5000);
        bloomery_adobe = new BloomeryBase(Material.ROCK, "bloomery_adobe", 5000);
        blockbreaker = new Breaker(Material.WOOD, "blockbreaker", 4.0f);
        castingform = new CastingForm(Material.WOOD, "castingform");

        copperchisel = new Chisel(Material.IRON, "copperchisel");
        ironchisel = new Chisel(Material.IRON, "ironchisel");
        bronzechisel = new Chisel(Material.IRON, "bronzechisel");
        cleanironchisel = new Chisel(Material.IRON, "cleanironchisel");
        steelchisel = new Chisel(Material.IRON, "steelchisel");
        wootzchisel = new Chisel(Material.IRON, "wootzchisel");

        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");

        stoneanvil = new AnvilStone(Material.ANVIL, "stoneanvil", 5.0f, true);
        ironanvil = new AnvilIron(Material.ANVIL, "ironanvil", 6.0f, true);

        yewstave = new YewStave(Material.WOOD, "yewstave", 3.0F);

    }


    public static void register() {
        registerBlock(nbtCrucible);
        registerBlockWithItem(forge_brick);
        registerBlockWithItem(forge_adobe);
        registerBlockWithItem(bloomery_brick);
        registerBlockWithItem(bloomery_adobe);
        registerBlockWithItem(blockbreaker);
        registerBlockWithItem(castingform);

        registerBlockWithItem(copperchisel);
        registerBlockWithItem(bronzechisel);
        registerBlockWithItem(ironchisel);
        registerBlockWithItem(cleanironchisel);
        registerBlockWithItem(steelchisel);
        registerBlockWithItem(wootzchisel);

        registerBlockWithItem(pistonbellowsoak);
        registerBlockWithItem(pistonbellowsjungle);
        registerBlockWithItem(pistonbellowsbirch);
        registerBlockWithItem(pistonbellowsspruce);
        registerBlockWithItem(pistonbellowsdarkoak);
        registerBlockWithItem(pistonbellowsacacia);

        registerBlockWithItem(stoneanvil);
        registerBlockWithItem(ironanvil);

        registerBlockWithItem(yewstave);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        //registerRender(nbtCrucible);
        registerRender(forge_brick);
        registerRender(forge_adobe);
        registerRender(castingform);

        registerRender(copperchisel);
        registerRender(bronzechisel);
        registerRender(ironchisel);
        registerRender(cleanironchisel);
        registerRender(steelchisel);
        registerRender(wootzchisel);

        registerRender(blockbreaker);
        registerRender(pistonbellowsoak);
        registerRender(pistonbellowsjungle);
        registerRender(pistonbellowsbirch);
        registerRender(pistonbellowsspruce);
        registerRender(pistonbellowsdarkoak);
        registerRender(pistonbellowsacacia);

        registerRender(bloomery_brick);
        registerRender(bloomery_adobe);

        registerRender(stoneanvil);
        registerRender(ironanvil);

        registerRender(yewstave);

    }

    private static void registerBlockWithItem(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        //GameRegistry.register(block);

        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());

        ForgeRegistries.ITEMS.register(item);
        //GameRegistry.register(item);
    }

    private static void registerBlock(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        //GameRegistry.register(block);

        //ItemBlock item = new ItemBlock(block);
        //item.setRegistryName(block.getRegistryName());

        //ForgeRegistries.ITEMS.register(item);
        //GameRegistry.register(item);
    }

    private static void registerBlockSubType(Block block, ItemBlock item, String registryName)
    {
        ForgeRegistries.BLOCKS.register(block);
        //GameRegistry.register(block);

        item.setRegistryName(registryName);

        ForgeRegistries.ITEMS.register(item);
        //GameRegistry.register(item);
    }

    private static void registerRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    private static void registerRenderCustom(ItemBlock item, Integer meta, ModelResourceLocation model)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }

}
