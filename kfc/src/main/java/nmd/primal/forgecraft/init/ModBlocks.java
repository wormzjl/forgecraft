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

    public static Block pistonbellowsoak;
    public static Block pistonbellowsjungle;
    public static Block pistonbellowsbirch;
    public static Block pistonbellowsspruce;
    public static Block pistonbellowsdarkoak;
    public static Block pistonbellowsacacia;

    /**
    public static Block emptycrucible;
    public static Block emptycruciblehot;
    public static Block emptycruciblecracked;
    public static Block emptycruciblecrackedhot;

    public static Block rawbronzecrucible;
    public static Block hotbronzecrucible;
    public static Block hotcookedbronzecrucible;

    public static Block rawbronzecrucible_redstone;
    public static Block hotbronzecrucible_redstone;
    public static Block hotcookedbronzecrucible_redstone;

    public static Block rawbronzecrucible_lapis;
    public static Block hotbronzecrucible_lapis;
    public static Block hotcookedbronzecrucible_lapis;

    public static Block rawbronzecrucible_diamond;
    public static Block hotbronzecrucible_diamond;
    public static Block hotcookedbronzecrucible_diamond;

    public static Block rawbronzecrucible_emerald;
    public static Block hotbronzecrucible_emerald;
    public static Block hotcookedbronzecrucible_emerald;
     **/

    //public static Block ironball;
    //public static Block ironchunk;
    //public static Block ironcleanball;
    //public static Block ironcleanchunk;
    //public static Block steelball;
    //public static Block steelchunk;
    //public static Block wootzball;
    //public static Block wootzchunk;

    public static Block stoneanvil;
    public static Block ironanvil;

    public static Block yewstave;


    public static void init() {
    //FISH_TRAP                   = RegistryHelper.addBlock("fish_trap", new FishTrap(), ItemFishTraps::new, "fishtrap");
        nbtCrucible = new NBTCrucible(Material.ROCK, "nbtcrucible");
        forge_brick = new Forge(Material.ROCK, "forge_brick", 5000);
        forge_adobe = new Forge(Material.ROCK, "forge_adobe", 5000);
        bloomery_brick = new BloomeryBase(Material.ROCK, "bloomery_brick", 5000);
        bloomery_adobe = new BloomeryBase(Material.ROCK, "bloomery_adobe", 5000);
        blockbreaker = new Breaker(Material.WOOD, "blockbreaker", 4.0f);
        castingform = new CastingForm(Material.WOOD, "castingform");

        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");

        /*emptycrucible = new Crucible(Material.ROCK, "emptycrucible");
        emptycruciblehot = new CrucibleHot(Material.ROCK, "emptycruciblehot");
        emptycruciblecracked = new Crucible(Material.ROCK, "emptycruciblecracked");
        emptycruciblecrackedhot = new CrucibleHot(Material.ROCK, "emptycruciblecrackedhot");

        rawbronzecrucible = new Crucible(Material.ROCK, "rawbronzecrucible");
        hotbronzecrucible = new CrucibleHot(Material.ROCK, "hotbronzecrucible");
        hotcookedbronzecrucible = new CrucibleHot(Material.ROCK, "hotcookedbronzecrucible");

        rawbronzecrucible_redstone = new Crucible(Material.ROCK, "rawbronzecrucible_redstone");
        hotbronzecrucible_redstone = new CrucibleHot(Material.ROCK, "hotbronzecrucible_redstone");
        hotcookedbronzecrucible_redstone = new CrucibleHot(Material.ROCK, "hotcookedbronzecrucible_redstone");

        rawbronzecrucible_diamond = new Crucible(Material.ROCK, "rawbronzecrucible_diamond");
        hotbronzecrucible_diamond = new CrucibleHot(Material.ROCK, "hotbronzecrucible_diamond");
        hotcookedbronzecrucible_diamond = new CrucibleHot(Material.ROCK, "hotcookedbronzecrucible_diamond");

        rawbronzecrucible_lapis = new Crucible(Material.ROCK, "rawbronzecrucible_lapis");
        hotbronzecrucible_lapis = new CrucibleHot(Material.ROCK, "hotbronzecrucible_lapis");
        hotcookedbronzecrucible_lapis = new CrucibleHot(Material.ROCK, "hotcookedbronzecrucible_lapis");

        rawbronzecrucible_emerald = new Crucible(Material.ROCK, "rawbronzecrucible_emerald");
        hotbronzecrucible_emerald = new CrucibleHot(Material.ROCK, "hotbronzecrucible_emerald");
        hotcookedbronzecrucible_emerald = new CrucibleHot(Material.ROCK, "hotcookedbronzecrucible_emerald");
        */

        /*
        ironball = new IngotBall(Material.IRON, "ironball", 5.0F, "big") {
            @Override
            public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
            {
                if(!world.isRemote){
                    Item pItem = player.getHeldItem(hand).getItem();
                    ItemStack pstack = player.getHeldItemMainhand();
                    BlockPos belowPos = pos.down();
                    //System.out.println("Activating");
                    if (pItem instanceof Gallagher && world.getBlockState(belowPos).getBlock().equals(Blocks.STONE)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.stoneanvil.getDefaultState().withProperty(AnvilStone.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                        return true;
                    }
                    if (pstack.isEmpty()) {
                        System.out.println(state);
                        PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, player.getActiveHand(), this.getItem(world, pos, state));
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                        return true;
                    }
                    if (pItem instanceof Gallagher || pItem.equals(ModItems.forgehammer)) {
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

                                Block tempBlock = ModBlocks.ironchunk;
                                tempBlock.getDefaultState().withProperty(PrimalAPI.States.ACTIVE, true);

                                tile.setSlotStack(6, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(7, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(8, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(11, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(12, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(13, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(16, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(17, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(18, new ItemStack(tempBlock, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        ironcleanball = new IngotBall(Material.IRON, "ironcleanball", 5.0f,"big") {
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
                    if (pItem instanceof Gallagher || pItem.equals(ModItems.forgehammer)) {
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

                                Block tempBlock = ModBlocks.ironcleanchunk;
                                tempBlock.getDefaultState().withProperty(PrimalAPI.States.ACTIVE, true);
                                tile.setSlotStack(6, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(7, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(8, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(11, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(12, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(13, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(16, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(17, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(18, new ItemStack(tempBlock, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }

                }
                return false;
            }
        };
        steelball = new IngotBall(Material.IRON, "steelball", 6.0f,"big"){
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
                    if (pItem instanceof Gallagher || pItem.equals(ModItems.forgehammer)) {
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

                                Block tempBlock = ModBlocks.steelchunk;
                                tempBlock.getDefaultState().withProperty(PrimalAPI.States.ACTIVE, true);

                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                tile.setSlotStack(6, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(7, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(8, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(11, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(12, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(13, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(16, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(17, new ItemStack(tempBlock, 1));
                                tile.setSlotStack(18, new ItemStack(tempBlock, 1));
                                world.playEvent(1031, pos, 0);
                                return true;
                            }
                        }
                    }

                }
                return false;
            }
        };
        wootzball = new IngotBall(Material.IRON, "wootzball", 6.0f,"big") {
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
                if (pItem instanceof Gallagher || pItem.equals(ModItems.forgehammer)) {
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

                            Block tempBlock = ModBlocks.wootzchunk;
                            tempBlock.getDefaultState().withProperty(PrimalAPI.States.ACTIVE, true);

                            tile.setSlotStack(6, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(7, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(8, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(11, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(12, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(13, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(16, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(17, new ItemStack(tempBlock, 1));
                            tile.setSlotStack(18, new ItemStack(tempBlock, 1));
                            world.playEvent(1031, pos, 0);
                            return true;
                        }
                    }
                }

            }
            return false;
        }
    };

        ironchunk = new IngotBall(Material.IRON, "ironchunk", 5.0F, "small");
        ironcleanchunk = new IngotBall(Material.IRON, "ironcleanchunk", 5.0F, "small");
        steelchunk = new IngotBall(Material.IRON, "steelchunk", 6.0f,"small");
        wootzchunk = new IngotBall(Material.IRON, "wootzchunk", 6.0f,"small");
*/

        stoneanvil = new AnvilStone(Material.ANVIL, "stoneanvil", 5.0f, true);
        ironanvil = new AnvilIron(Material.ANVIL, "ironanvil", 6.0f, true);
        //ironballitemcool = new ItemBlockIngotBall(ironball);
        //ironballitemhot = new ItemBlockIngotBall(ironball);
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

        registerBlockWithItem(pistonbellowsoak);
        registerBlockWithItem(pistonbellowsjungle);
        registerBlockWithItem(pistonbellowsbirch);
        registerBlockWithItem(pistonbellowsspruce);
        registerBlockWithItem(pistonbellowsdarkoak);
        registerBlockWithItem(pistonbellowsacacia);

        /*registerBlockWithItem(emptycrucible);
        registerBlockWithItem(emptycruciblehot);
        registerBlockWithItem(emptycruciblecracked);
        registerBlockWithItem(emptycruciblecrackedhot);

        registerBlockWithItem(rawbronzecrucible);
        registerBlockWithItem(hotbronzecrucible);
        registerBlockWithItem(hotcookedbronzecrucible);

        registerBlockWithItem(rawbronzecrucible_diamond);
        registerBlockWithItem(hotbronzecrucible_diamond);
        registerBlockWithItem(hotcookedbronzecrucible_diamond);

        registerBlockWithItem(rawbronzecrucible_emerald);
        registerBlockWithItem(hotbronzecrucible_emerald);
        registerBlockWithItem(hotcookedbronzecrucible_emerald);

        registerBlockWithItem(rawbronzecrucible_redstone);
        registerBlockWithItem(hotbronzecrucible_redstone);
        registerBlockWithItem(hotcookedbronzecrucible_redstone);

        registerBlockWithItem(rawbronzecrucible_lapis);
        registerBlockWithItem(hotbronzecrucible_lapis);
        registerBlockWithItem(hotcookedbronzecrucible_lapis);
*/
        //registerBlockWithItem(ironball);
        //registerBlockWithItem(ironchunk);

        //registerBlockWithItem(ironcleanball);
        //registerBlockWithItem(ironcleanchunk);

        //registerBlockWithItem(steelball);
        //registerBlockWithItem(steelchunk);

        //registerBlockWithItem(wootzball);
        //registerBlockWithItem(wootzchunk);
        //registerBlockWithItemSubType(ironball, ironballitemcool, "ironcool");
        //registerBlockWithItemSubType(ironball, ironballitemhot, "ironhot");

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

        registerRender(blockbreaker);
        registerRender(pistonbellowsoak);
        registerRender(pistonbellowsjungle);
        registerRender(pistonbellowsbirch);
        registerRender(pistonbellowsspruce);
        registerRender(pistonbellowsdarkoak);
        registerRender(pistonbellowsacacia);

        registerRender(bloomery_brick);
        registerRender(bloomery_adobe);
        /*
        registerRender(emptycrucible);
        registerRender(emptycruciblehot);
        registerRender(emptycruciblecracked);
        registerRender(emptycruciblecrackedhot);

        registerRender(rawbronzecrucible);
        registerRender(hotbronzecrucible);
        registerRender(hotcookedbronzecrucible);

        registerRender(rawbronzecrucible_diamond);
        registerRender(hotbronzecrucible_diamond);
        registerRender(hotcookedbronzecrucible_diamond);

        registerRender(rawbronzecrucible_emerald);
        registerRender(hotbronzecrucible_emerald);
        registerRender(hotcookedbronzecrucible_emerald);

        registerRender(rawbronzecrucible_redstone);
        registerRender(hotbronzecrucible_redstone);
        registerRender(hotcookedbronzecrucible_redstone);

        registerRender(rawbronzecrucible_lapis);
        registerRender(hotbronzecrucible_lapis);
        registerRender(hotcookedbronzecrucible_lapis);
        */
        //registerRender(ironball);
        //registerRender(ironchunk);

        //registerRender(ironcleanball);
        //registerRender(ironcleanchunk);

        //registerRender(steelball);
        //registerRender(steelchunk);

        //registerRender(wootzball);
        //registerRender(wootzchunk);

        //registerRenderCustom(ironballitemcool, 0, new ModelResourceLocation(ironballitemcool.getUnlocalizedName()));
        //registerRenderCustom(ironballitemhot, 1, new ModelResourceLocation(ironballitemhot.getUnlocalizedName()));

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
