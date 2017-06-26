package nmd.primal.forgecraft.enumhandler;

import nmd.primal.forgecraft.util.IMetaLookup;

/**
 * Created by mminaie on 2/1/17.
 */
public class EnumHandler {

    public enum IngotTypes implements IMetaLookup<IngotTypes> {
        IRONCOOL, /*0*/
        IRONHOT;  /*1*/

        public final int meta;
        public final String name;
        public boolean set = false;

        private IngotTypes() {
            meta = ordinal();
            name = toString().toLowerCase();
        }

        @Override
        public String getVariantName() {
            return name;
        }

        @Override
        public int getOrdinal() {
            return meta;
        }

        @Override
        public IngotTypes getByOrdinal(int i) {
            return this.values()[i];
        }

        @Override
        public String getID() {
            return "ore_type";
        }

    }




}
