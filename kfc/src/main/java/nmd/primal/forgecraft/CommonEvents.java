package nmd.primal.forgecraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nmd.primal.core.api.events.CauldronRecipeEvent;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.recipes.tile.CauldronRecipe;
import nmd.primal.core.common.tiles.machines.TileCauldron;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.util.WeaponNBT;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements WeaponNBT {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onItemCrafted(CauldronRecipeEvent.Pre event){

        CauldronRecipe recipe = event.getRecipe();
        System.out.println(recipe.getRecipeName());
        if (recipe.matches("forgecraft:cauldron_item.rawcoppergladiussmite", "forgecraft:cauldron_item.rawcoppergladiusbane", "forgecraft:cauldron_item.rawcoppergladiusfire", "forgecraft:cauldron_item.rawcoppergladiusfortune",
                "forgecraft:cauldron_item.rawbronzegladiussmite", "forgecraft:cauldron_item.rawbronzegladiusbane", "forgecraft:cauldron_item.rawbronzegladiusfire", "forgecraft:cauldron_item.rawbronzegladiusfortune",
                "forgecraft:cauldron_item.rawwroughtirongladiussmite", "forgecraft:cauldron_item.rawwroughtirongladiusbane", "forgecraft:cauldron_item.rawwroughtirongladiusfire", "forgecraft:cauldron_item.rawwroughtirongladiusfortune",
                "forgecraft:cauldron_item.rawclearnirongladiussmite", "forgecraft:cauldron_item.rawclearnirongladiusbane", "forgecraft:cauldron_item.rawclearnirongladiusfire", "forgecraft:cauldron_item.rawclearnirongladiusfortune",
                "forgecraft:cauldron_item.rawsteelgladiussmite", "forgecraft:cauldron_item.rawsteelgladiusbane", "forgecraft:cauldron_item.rawsteelgladiusfire", "forgecraft:cauldron_item.rawsteelgladiusfortune",
                "forgecraft:cauldron_item.rawwootzgladiussmite", "forgecraft:cauldron_item.rawwootzgladiusbane", "forgecraft:cauldron_item.rawwootzgladiusfire", "forgecraft:cauldron_item.rawwootzgladiusfortune",
                "forgecraft:cauldron_item.rawcleanironlongswordsmite", "forgecraft:cauldron_item.rawcleanironlongswordbane", "forgecraft:cauldron_item.rawcleanironlongswordfire", "forgecraft:cauldron_item.rawcleanironlongswordfortune",
                "forgecraft:cauldron_item.rawsteellongswordsmite", "forgecraft:cauldron_item.rawsteellongswordbane", "forgecraft:cauldron_item.rawsteellongswordfire", "forgecraft:cauldron_item.rawsteellongswordfortune",
                "forgecraft:cauldron_item.rawwootzlongswordsmite", "forgecraft:cauldron_item.rawwootzlongswordbane", "forgecraft:cauldron_item.rawwootzlongswordfire", "forgecraft:cauldron_item.rawwootzlongswordfortune",
                "forgecraft:cauldron_item.rawironslayersmite", "forgecraft:cauldron_item.rawironslayerbane", "forgecraft:cauldron_item.rawironslayerfire", "forgecraft:cauldron_item.rawironslayerfortune",
                "forgecraft:cauldron_item.rawcleanironslayersmite", "forgecraft:cauldron_item.rawcleanironslayerbane", "forgecraft:cauldron_item.rawcleanironslayerfire", "forgecraft:cauldron_item.rawcleanironslayerfortune",
                "forgecraft:cauldron_item.rawsteelslayersmite", "forgecraft:cauldron_item.rawsteelslayerbane", "forgecraft:cauldron_item.rawsteelslayerfire", "forgecraft:cauldron_item.rawsteelslayerfortune",
                "forgecraft:cauldron_item.rawwootzslayersmite", "forgecraft:cauldron_item.rawwootzslayerbane", "forgecraft:cauldron_item.rawwootzslayerfire", "forgecraft:cauldron_item.rawwootzslayerfortune"
        )){

            NonNullList<ItemStack> inputList = NonNullList.<ItemStack>withSize(6, ItemStack.EMPTY);
            inputList.set(0, event.getTile().getInputHandler().getStackInSlot(0));
            inputList.set(1, event.getTile().getInputHandler().getStackInSlot(1));
            inputList.set(2, event.getTile().getInputHandler().getStackInSlot(2));
            inputList.set(3, event.getTile().getInputHandler().getStackInSlot(3));
            inputList.set(4, event.getTile().getInputHandler().getStackInSlot(4));
            inputList.set(5, event.getTile().getInputHandler().getStackInSlot(5));

            TileCauldron tile = event.getTile();
            ItemStack inputStack = tile.getInputStack(event.getOutputs().get(0));
            Item inputStackItem = null;
            if(inputStack.getItem() instanceof WeaponPart){
               inputStackItem = inputStack.getItem();
            }
            ItemStack modStack = ItemStack.EMPTY;
            ItemStack outputStack = event.getOutputs().get(0);

            modStack = getOppositeStack(inputList, inputStack);

            if(inputStackItem != null) {
                if (inputStack.hasTagCompound()) {
                    if (getModifiers(inputStack) < WeaponNBT.materialModifiers.get(((WeaponPart) outputStack.getItem()).getMaterial()) ) {
                        if (RecipeHelper.isOreName(modStack, "dustSilver")) {
                            setSmiteLevel(outputStack, getSmiteLevel(inputStack) + 1);
                            setModifiers(outputStack, getModifiers(inputStack) + 1);
                        }
                        if (RecipeHelper.isOreName(modStack, "foodPoison")) {
                            setBaneLevel(outputStack, getBaneLevel(inputStack) + 1);
                            setModifiers(outputStack, getModifiers(inputStack) + 1);
                        }
                        if (RecipeHelper.isOreName(modStack, "dustBlaze")) {
                            setFireLevel(outputStack, getFireLevel(inputStack) + 1);
                            setModifiers(outputStack, getModifiers(inputStack) + 1);
                        }
                        if (RecipeHelper.isOreName(modStack, "gemLapis")) {
                            setFortuneLevel(outputStack, getFortuneLevel(inputStack) + 1);
                            setModifiers(outputStack, getModifiers(inputStack) + 1);
                        }
                    }
                }
            }
        }
    }

    private ItemStack getOppositeStack(NonNullList<ItemStack> inputList, ItemStack inputStack){
        ItemStack modStack = ItemStack.EMPTY;

        for (int i = 0; i < inputList.size(); i++) {
            if(inputList.get(i) != ItemStack.EMPTY && !(inputList.get(i).getItem() instanceof WeaponPart) ){
                System.out.println(inputList.get(i));
                modStack = inputList.get(i);
            }
        }
        System.out.println(modStack);
        return modStack;
    }

}
