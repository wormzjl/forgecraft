package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.items.tools.WorkMallet;
import nmd.primal.forgecraft.blocks.*;
import nmd.primal.forgecraft.items.ForgeHammer;
import nmd.primal.forgecraft.tiles.TileAnvil;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block firebox;
    public static Block bloomery;
    public static Block bloomery_adobe;
    public static Block blockbreaker;

    public static Block pistonbellowsoak;
    public static Block pistonbellowsjungle;
    public static Block pistonbellowsbirch;
    public static Block pistonbellowsspruce;
    public static Block pistonbellowsdarkoak;
    public static Block pistonbellowsacacia;

    public static Block emptycrucible;
    public static Block emptycruciblehot;
    public static Block emptycruciblecracked;
    public static Block emptycruciblecrackedhot;

    public static Block rawironcrucible;
    public static Block hotironcrucible;
    public static Block hotcookedironcrucible;
    public static Block coolironcrucible;
    public static Block failedironcrucible;
    public static Block failedironcruciblehot;

    public static Block rawcleanironcrucible;
    public static Block hotcleanironcrucible;
    public static Block hotcookedcleanironcrucible;
    public static Block coolcleanironcrucible;
    public static Block failedcleanironcrucible;
    public static Block failedcleanironcruciblehot;

    public static Block rawsteelcrucible;
    public static Block hotsteelcrucible;
    public static Block hotcookedsteelcrucible;
    public static Block coolsteelcrucible;
    public static Block failedsteelcrucible;
    public static Block failedsteelcruciblehot;

    public static Block rawwootzcrucible;
    public static Block hotwootzcrucible;
    public static Block hotcookedwootzcrucible;
    public static Block coolwootzcrucible;
    public static Block failedwootzcrucible;
    public static Block failedwootzcruciblehot;

    public static Block ironball;
    public static Block ironchunk;
    public static Block ironcleanball;
    public static Block ironcleanchunk;
    public static Block steelball;
    public static Block steelchunk;
    public static Block wootzball;
    public static Block wootzchunk;

    public static Block stoneanvil;
    public static Block ironanvil;


    public static void init() {

        firebox = new Forge(Material.ROCK);
        bloomery = new BloomeryBase(Material.ROCK, "bloomery", 1500);
        bloomery_adobe = new BloomeryBase(Material.ROCK, "bloomery_adobe", 1560);
        blockbreaker = new Breaker(Material.WOOD, "blockbreaker", 4.0f);

        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");

        emptycrucible = new Crucible(Material.ROCK, "emptycrucible");
        emptycruciblehot = new CrucibleHot(Material.ROCK, "emptycruciblehot");
        emptycruciblecracked = new Crucible(Material.ROCK, "emptycruciblecracked");
        emptycruciblecrackedhot = new CrucibleHot(Material.ROCK, "emptycruciblecrackedhot");

        rawironcrucible = new Crucible(Material.ROCK, "rawironcrucible");
        hotironcrucible = new CrucibleHot(Material.ROCK, "hotironcrucible");
        hotcookedironcrucible = new CrucibleHot(Material.ROCK, "hotcookedironcrucible");
        coolironcrucible = new Crucible(Material.ROCK, "coolironcrucible");
        failedironcrucible = new Crucible(Material.ROCK, "failedironcrucible");
        failedironcruciblehot = new CrucibleHot(Material.ROCK, "failedironcruciblehot");

        rawcleanironcrucible = new Crucible(Material.ROCK, "rawcleanironcrucible");
        hotcleanironcrucible = new CrucibleHot(Material.ROCK, "hotcleanironcrucible");
        hotcookedcleanironcrucible = new CrucibleHot(Material.ROCK, "hotcookedcleanironcrucible");
        coolcleanironcrucible = new Crucible(Material.ROCK, "coolcleanironcrucible");
        failedcleanironcrucible = new Crucible(Material.ROCK, "failedcleanironcrucible");
        failedcleanironcruciblehot = new Crucible(Material.ROCK, "failedcleanironcruciblehot");

        rawsteelcrucible = new Crucible(Material.ROCK, "rawsteelcrucible");
        hotsteelcrucible = new CrucibleHot(Material.ROCK, "hotsteelcrucible");
        hotcookedsteelcrucible = new CrucibleHot(Material.ROCK, "hotcookedsteelcrucible");
        coolsteelcrucible = new Crucible(Material.ROCK, "coolsteelcrucible");
        failedsteelcrucible = new Crucible(Material.ROCK, "failedsteelcrucible");
        failedsteelcruciblehot = new Crucible(Material.ROCK, "failedsteelcruciblehot");

        rawwootzcrucible = new Crucible(Material.ROCK, "rawwootzcrucible");
        hotwootzcrucible = new CrucibleHot(Material.ROCK, "hotwootzcrucible");
        hotcookedwootzcrucible = new CrucibleHot(Material.ROCK, "hotcookedwootzcrucible");
        coolwootzcrucible = new Crucible(Material.ROCK, "coolwootzcrucible");
        failedwootzcrucible = new Crucible(Material.ROCK, "failedwootzcrucible");
        failedwootzcruciblehot = new Crucible(Material.ROCK, "failedwootzcruciblehot");

        ironball = new IngotBall(Material.IRON, "ironball", 5.0F, "ingot") {
            @Override
            public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
            {
                if(!world.isRemote){
                    Item pItem = player.getHeldItem(hand).getItem();
                    BlockPos belowPos = pos.down();
                    //System.out.println("Activating");
                    if (pItem instanceof WorkMallet && world.getBlockState(belowPos).getBlock().equals(Blocks.STONE)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.stoneanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                        return true;
                    }
                    /*if (pItem instanceof ForgeHammer && world.getBlockState(belowPos).getBlock().equals(Blocks.IRON_BLOCK)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.ironanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                        return true;
                    }*/
                    if (pItem instanceof WorkMallet || pItem.equals(ModItems.forgehammer)) {
                        if(world.getBlockState(belowPos).getBlock() instanceof AnvilBase) {

                            TileAnvil tile = (TileAnvil) world.getTileEntity(belowPos);

                            if (tile.getSlotStack(6).isEmpty() &&
                                    tile.getSlotStack(7).isEmpty() &&
                                    tile.getSlotStack(8).isEmpty() &&
                                    tile.getSlotStack(11).isEmpty() &&
                                    tile.getSlotStack(12).isEmpty() &&
                                    tile.getSlotStack(13).isEmpty() &&
                                    tile.getSlotStack(16).isEmpty() &&
                                    tile.getSlotStack(17).isEmpty() &&
                                    tile.getSlotStack(18).isEmpty()
                                    ) {
                                player.swingArm(hand);
                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                tile.setSlotStack(6, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(7, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(8, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(11, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(12, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(13, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(16, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(17, new ItemStack(ModItems.ironchunkhot, 1));
                                tile.setSlotStack(18, new ItemStack(ModItems.ironchunkhot, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }

                }
                return false;
            }
        };
        ironcleanball = new IngotBall(Material.IRON, "ironcleanball", 5.0f, "ingot") {
            @Override
            public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
            {
                //System.out.println("Level 0");
                if(!world.isRemote){
                    Item pItem = player.getHeldItem(hand).getItem();
                    BlockPos belowPos = pos.down();
                    //System.out.println("Activating1");
                    if (pItem instanceof ForgeHammer && world.getBlockState(belowPos).getBlock().equals(Blocks.IRON_BLOCK)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.ironanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //System.out.println("Activating");
                        return true;
                    }
                    if (pItem instanceof WorkMallet || pItem.equals(ModItems.forgehammer)) {
                        if(world.getBlockState(belowPos).getBlock() instanceof AnvilBase) {

                            TileAnvil tile = (TileAnvil) world.getTileEntity(belowPos);

                            if (tile.getSlotStack(6).isEmpty() &&
                                    tile.getSlotStack(7).isEmpty() &&
                                    tile.getSlotStack(8).isEmpty() &&
                                    tile.getSlotStack(11).isEmpty() &&
                                    tile.getSlotStack(12).isEmpty() &&
                                    tile.getSlotStack(13).isEmpty() &&
                                    tile.getSlotStack(16).isEmpty() &&
                                    tile.getSlotStack(17).isEmpty() &&
                                    tile.getSlotStack(18).isEmpty()
                                    ) {
                                player.swingArm(hand);
                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                tile.setSlotStack(6, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(7, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(8, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(11, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(12, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(13, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(16, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(17, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                tile.setSlotStack(18, new ItemStack(ModItems.ironcleanchunkhot, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }

                }
                return false;
            }
        }; // clean_iron_ingot ironcleanball.json ironcleanballhot.json - done
        steelball = new IngotBall(Material.IRON, "steelball", 6.0f, "ingot"){
            @Override
            public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
            {
                if(!world.isRemote){
                    Item pItem = player.getHeldItem(hand).getItem();
                    BlockPos belowPos = pos.down();
                    //System.out.println("Activating");
                    if (pItem instanceof ForgeHammer && world.getBlockState(belowPos).getBlock().equals(Blocks.IRON_BLOCK)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.ironanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                        return true;
                    }
                    if (pItem instanceof WorkMallet || pItem.equals(ModItems.forgehammer)) {
                        if(world.getBlockState(belowPos).getBlock() instanceof AnvilBase) {

                            TileAnvil tile = (TileAnvil) world.getTileEntity(belowPos);

                            if (tile.getSlotStack(6).isEmpty() &&
                                    tile.getSlotStack(7).isEmpty() &&
                                    tile.getSlotStack(8).isEmpty() &&
                                    tile.getSlotStack(11).isEmpty() &&
                                    tile.getSlotStack(12).isEmpty() &&
                                    tile.getSlotStack(13).isEmpty() &&
                                    tile.getSlotStack(16).isEmpty() &&
                                    tile.getSlotStack(17).isEmpty() &&
                                    tile.getSlotStack(18).isEmpty()
                                    ) {
                                player.swingArm(hand);
                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                tile.setSlotStack(6, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(7, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(8, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(11, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(12, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(13, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(16, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(17, new ItemStack(ModItems.steelchunkhot, 1));
                                tile.setSlotStack(18, new ItemStack(ModItems.steelchunkhot, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }

                }
                return false;
            }
        }; // steel_ingot steelball.json steelballhot.json
        wootzball = new IngotBall(Material.IRON, "wootzball", 6.0f, "ingot") {
        @Override
        public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
        {
            if(!world.isRemote){
                Item pItem = player.getHeldItem(hand).getItem();
                BlockPos belowPos = pos.down();
                //System.out.println("Activating");
                if (pItem instanceof ForgeHammer && world.getBlockState(belowPos).getBlock().equals(Blocks.IRON_BLOCK)) {
                    player.swingArm(hand);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    world.setBlockState(belowPos, ModBlocks.ironanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                    world.playEvent(1031, pos, 0);
                    //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                    return true;
                }
                if (pItem instanceof WorkMallet || pItem.equals(ModItems.forgehammer)) {
                    if(world.getBlockState(belowPos).getBlock() instanceof AnvilBase) {

                        TileAnvil tile = (TileAnvil) world.getTileEntity(belowPos);

                        if (tile.getSlotStack(6).isEmpty() &&
                                tile.getSlotStack(7).isEmpty() &&
                                tile.getSlotStack(8).isEmpty() &&
                                tile.getSlotStack(11).isEmpty() &&
                                tile.getSlotStack(12).isEmpty() &&
                                tile.getSlotStack(13).isEmpty() &&
                                tile.getSlotStack(16).isEmpty() &&
                                tile.getSlotStack(17).isEmpty() &&
                                tile.getSlotStack(18).isEmpty()
                                ) {
                            player.swingArm(hand);
                            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                            tile.setSlotStack(6, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(7, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(8, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(11, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(12, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(13, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(16, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(17, new ItemStack(ModItems.wootzchunkhot, 1));
                            tile.setSlotStack(18, new ItemStack(ModItems.wootzchunkhot, 1));
                            world.playEvent(1031, pos, 0);
                            return true;
                        }
                    }
                }

            }
            return false;
        }
    }; //wootz_ingot wootzball.json wootzballhot.json

        ironchunk = new IngotBall(Material.IRON, "ironchunk", 5.0F, "chunk");
        ironcleanchunk = new IngotBall(Material.IRON, "ironcleanchunk", 5.0F, "chunk"); //Lyle to make assets clean_iron_ingot, blockstate\ironcleanchunk.json, item\ironcleanchunk.json, item\ironcleanchunkhot.json - done
        steelchunk = new IngotBall(Material.IRON, "steelchunk", 6.0f, "chunk"); //steel_ingot steelchunk.json steelchunkhot.json - done
        wootzchunk = new IngotBall(Material.IRON, "wootzchunk", 6.0f, "chunk"); //wootz_ingot wootzchunk.json wootzchunkhot.json - done

        stoneanvil = new AnvilStone(Material.ANVIL, "stoneanvil", 5.0f, true);
        ironanvil = new AnvilIron(Material.ANVIL, "ironanvil", 6.0f, true);
        //ironballitemcool = new ItemBlockIngotBall(ironball);
        //ironballitemhot = new ItemBlockIngotBall(ironball);

    }


    public static void register() {
        registerBlock(firebox);
        registerBlock(bloomery);
        registerBlock(bloomery_adobe);
        registerBlock(blockbreaker);

        registerBlock(pistonbellowsoak);
        registerBlock(pistonbellowsjungle);
        registerBlock(pistonbellowsbirch);
        registerBlock(pistonbellowsspruce);
        registerBlock(pistonbellowsdarkoak);
        registerBlock(pistonbellowsacacia);

        registerBlock(emptycrucible);
        registerBlock(emptycruciblehot);
        registerBlock(emptycruciblecracked);
        registerBlock(emptycruciblecrackedhot);

        registerBlock(rawironcrucible);
        registerBlock(hotironcrucible);
        registerBlock(hotcookedironcrucible);
        registerBlock(coolironcrucible);
        registerBlock(failedironcrucible);
        registerBlock(failedironcruciblehot);

        registerBlock(rawcleanironcrucible);
        registerBlock(hotcleanironcrucible);
        registerBlock(hotcookedcleanironcrucible);
        registerBlock(coolcleanironcrucible);
        registerBlock(failedcleanironcrucible);
        registerBlock(failedcleanironcruciblehot);

        registerBlock(rawsteelcrucible);
        registerBlock(hotsteelcrucible);
        registerBlock(hotcookedsteelcrucible);
        registerBlock(coolsteelcrucible);
        registerBlock(failedsteelcrucible);
        registerBlock(failedsteelcruciblehot);

        registerBlock(rawwootzcrucible);
        registerBlock(hotwootzcrucible);
        registerBlock(hotcookedwootzcrucible);
        registerBlock(coolwootzcrucible);
        registerBlock(failedwootzcrucible);
        registerBlock(failedwootzcruciblehot);

        registerBlock(ironball);
        registerBlock(ironchunk);

        registerBlock(ironcleanball);
        registerBlock(ironcleanchunk);

        registerBlock(steelball);
        registerBlock(steelchunk);

        registerBlock(wootzball);
        registerBlock(wootzchunk);
        //registerBlockSubType(ironball, ironballitemcool, "ironcool");
        //registerBlockSubType(ironball, ironballitemhot, "ironhot");

        registerBlock(stoneanvil);
        registerBlock(ironanvil);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(firebox);
        registerRender(blockbreaker);
        registerRender(pistonbellowsoak);
        registerRender(pistonbellowsjungle);
        registerRender(pistonbellowsbirch);
        registerRender(pistonbellowsspruce);
        registerRender(pistonbellowsdarkoak);
        registerRender(pistonbellowsacacia);
        registerRender(bloomery);
        registerRender(emptycrucible);
        registerRender(emptycruciblehot);
        registerRender(emptycruciblecracked);
        registerRender(emptycruciblecrackedhot);

        registerRender(rawironcrucible);
        registerRender(hotironcrucible);
        registerRender(hotcookedironcrucible);
        registerRender(coolironcrucible);
        registerRender(failedironcrucible);
        registerRender(failedironcruciblehot);

        registerRender(rawcleanironcrucible);
        registerRender(hotcleanironcrucible);
        registerRender(hotcookedcleanironcrucible);
        registerRender(coolcleanironcrucible);
        registerRender(failedcleanironcrucible);
        registerRender(failedcleanironcruciblehot);

        registerRender(rawsteelcrucible);
        registerRender(hotsteelcrucible);
        registerRender(hotcookedsteelcrucible);
        registerRender(coolsteelcrucible);
        registerRender(failedsteelcrucible);
        registerRender(failedsteelcruciblehot);

        registerRender(rawwootzcrucible);
        registerRender(hotwootzcrucible);
        registerRender(hotcookedwootzcrucible);
        registerRender(coolwootzcrucible);
        registerRender(failedwootzcrucible);
        registerRender(failedwootzcruciblehot);

        registerRender(ironball);
        registerRender(ironchunk);

        registerRender(ironcleanball);
        registerRender(ironcleanchunk);

        registerRender(steelball);
        registerRender(steelchunk);

        registerRender(wootzball);
        registerRender(wootzchunk);
        //registerRenderCustom(ironballitemcool, 0, new ModelResourceLocation(ironballitemcool.getUnlocalizedName()));
        //registerRenderCustom(ironballitemhot, 1, new ModelResourceLocation(ironballitemhot.getUnlocalizedName()));

        registerRender(stoneanvil);
        registerRender(ironanvil);

    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    private static void registerBlockSubType(Block block, ItemBlock itemBlock, String registryName){
        GameRegistry.register(block);
        ItemBlock item = itemBlock;
        item.setRegistryName(registryName);
        GameRegistry.register(item);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    private static void registerRenderCustom(ItemBlock item, Integer meta, ModelResourceLocation model){
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }

}
