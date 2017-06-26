package nmd.primal.forgecraft.util;

/**
 * Created by mminaie on 2/19/17.
 */


public interface IMetaLookup<T extends Enum> {
    public String getID();
    public T getByOrdinal(int i);

    public String getVariantName();
    public int getOrdinal();
}
