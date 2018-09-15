package nmd.primal.forgecraft.init.recipes;

/**
 * Created by mminaie on 9/15/18.
 */
/*
@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public final class CrucibleRecipes {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<CrucibleCrafting> event)
    {
        final IForgeRegistry<CrucibleCrafting> registry = event.getRegistry();

        /***Default Recipe***/
        /**
        registry.register(new CrucibleCrafting(

        ).setRecipeName(""));
        ***/

        /*
        registry.register(new CrucibleCrafting(
                new OreIngredient("oreIron"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(ModItems.ironingotball, 1),
                100,
                100,
                1000).setRecipeName("wroughtiron"));

        registry.register(new CrucibleCrafting(
                new OreIngredient("dustIron"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.IRON_DUST, 1),
                new ItemStack(ModItems.ironcleaningotball, 1),
                100,
                100,
                1000).setRecipeName("cleaniron"));

        registry.register(new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.ironcleaningotball, 1)),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_HIGH, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironcleaningotball, 1),
                new ItemStack(ModItems.steelingotball, 1),
                100,
                100,
                1000
        ).setRecipeName("steel"));

        registry.register(new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, 15)),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, 15)),
                new OreIngredient("dustMagnetite"),
                new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                100,
                100,
                1000
        ).setRecipeName("damascus"));

        registry.register(new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, 15)),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, 15)),
                new OreIngredient("magnetite"),
                new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                100,
                100,
                1000
        ).setRecipeName("damascus"));

        registry.register(new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.bronzeingotball, 1),
                100,
                100,
                1000
        ).setRecipeName("bronzebasic"));

        NBTTagCompound tagBronzeDefault = new NBTTagCompound();
        tagBronzeDefault.setString("upgrades", "");
        ItemStack defaultBronze = new ItemStack(ModItems.bronzeingotball, 1);
        defaultBronze.setTagCompound(tagBronzeDefault.copy());
        registry.register(new CrucibleCrafting(
                new OreIngredient("oreBronze"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                defaultBronze,
                100,
                100,
                1000
        ).setRecipeName("defaultbronze"));

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("upgrades", "redstone");
        ItemStack redBronze = new ItemStack(ModItems.bronzeingotball, 1);
        registry.register(new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("dustRedstone"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                redBronze,
                100,
                100,
                100
        ).setRecipeName("redbronze"));

        NBTTagCompound diamondBronzeTag = new NBTTagCompound();
        tag.setString("upgrades", "diamond");
        ItemStack diamondBronze = new ItemStack(ModItems.bronzeingotball, 1);
        diamondBronze.setTagCompound(diamondBronzeTag.copy());
        registry.register(new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("dustDiamond"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondBronze,
                100,
                100,
                100
        ).setRecipeName("diamondbronze"));

        NBTTagCompound emeraldBronzeTag = new NBTTagCompound();
        tag.setString("upgrades", "emerald");
        ItemStack emeraldBronze = new ItemStack(ModItems.bronzeingotball, 1);
        emeraldBronze.setTagCompound(emeraldBronzeTag.copy());
        registry.register(new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("dustEmerald"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondBronze,
                100,
                100,
                100
        ).setRecipeName("emeraldbronze"));

        NBTTagCompound tagBronzeLapis = new NBTTagCompound();
        tagBronzeDefault.setString("upgrades", "lapis");
        ItemStack lapisBronze = new ItemStack(ModItems.bronzeingotball, 1);
        lapisBronze.setTagCompound(tagBronzeLapis.copy());
        registry.register(new CrucibleCrafting(
                new OreIngredient("oreBronze"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                lapisBronze,
                100,
                100,
                1000
        ).setRecipeName("lapisbronze"));

    }
}
*/
