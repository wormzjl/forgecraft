package nmd.primal.forgecraft.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.*;

/**
 * Created by mminaie on 11/11/17.
 */
public class CrucibleCrafting {

    // ***************************************************************************** //
    //  Recipe Handler CrucibleHandler
    // ***************************************************************************** //

    private static ArrayList<CrucibleCrafting> crucibleCrafting = new ArrayList<>();

    private int cookTemp;
    private int cookTime;
    private int coolTime;

    private Ingredient ing0;
    private Ingredient ing1;
    private Ingredient ing2;
    private Ingredient ing3;
    private Ingredient ing4;

    private ItemStack dropsCooked;
    private ItemStack dropsRaw;

    private List<Ingredient> ingredientList = new List<Ingredient>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Ingredient> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Ingredient ingredient) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Ingredient> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Ingredient> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Ingredient get(int index) {
            return null;
        }

        @Override
        public Ingredient set(int index, Ingredient element) {
            return null;
        }

        @Override
        public void add(int index, Ingredient element) {

        }

        @Override
        public Ingredient remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Ingredient> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Ingredient> listIterator(int index) {
            return null;
        }

        @Override
        public List<Ingredient> subList(int fromIndex, int toIndex) {
            return null;
        }
    };




    public CrucibleCrafting(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4,
                            ItemStack outputRaw, ItemStack outputCooked,
                            Integer temp, Integer cookTime, Integer coolTime){

        this.ing0 = i0;
        this.ing1 = i1;
        this.ing2 = i2;
        this.ing3 = i3;
        this.ing4 = i4;
        this.ingredientList.add(0, i0);
        this.ingredientList.add(1, i1);
        this.ingredientList.add(2, i2);
        this.ingredientList.add(3, i3);
        this.ingredientList.add(4, i4);
        this.dropsRaw = outputRaw;
        this.dropsCooked = outputCooked;
        this.cookTemp = temp;
        this.cookTime = cookTime;
        this.coolTime = coolTime;
    }

    public static void addRecipe(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4,
                                 ItemStack outputRaw, ItemStack outputCooked,
                                 Integer temp, Integer cookTime, Integer coolTime)
    {
        crucibleCrafting.add(new CrucibleCrafting(i0, i1, i2, i3, i4, outputRaw, outputCooked, temp, cookTime, coolTime));
    }

    public static boolean isRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : crucibleCrafting){
            if(recipe.ing0.apply(i0) && recipe.ing1.apply(i1) && recipe.ing2.apply(i2) && recipe.ing3.apply(i3) && recipe.ing4.apply(i4) ){
                return true;
            }
        }
        return false;
    }

    public static CrucibleCrafting getRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : crucibleCrafting){
            if(recipe.ing0.test(i0) && recipe.ing1.test(i1) && recipe.ing2.test(i2) && recipe.ing3.test(i3) && recipe.ing4.test(i4) ){
                return recipe;
            }
        }
        return null;
    }

    public static boolean isValidIngredient(ItemStack checkStack){
        for(CrucibleCrafting recipe : crucibleCrafting) {
            if (recipe.ing0.apply(checkStack) ||
                    recipe.ing1.apply(checkStack) ||
                    recipe.ing2.apply(checkStack) ||
                    recipe.ing3.apply(checkStack) ||
                    recipe.ing4.apply(checkStack)) {
                return true;
            }
        }
        return false;
    }

    public int getCookTemp() {
        return cookTemp;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getCoolTime() {
        return coolTime;
    }

    public ItemStack getDropsCooked() {
        return dropsCooked;
    }

    public ItemStack getDropsRaw() {
        return dropsRaw;
    }
}
