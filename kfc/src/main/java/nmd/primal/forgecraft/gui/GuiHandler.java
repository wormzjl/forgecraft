package nmd.primal.forgecraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by mminaie on 2/4/17.
 */
public class GuiHandler implements IGuiHandler {

    public static final int FORGINGMANUALGUI = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == FORGINGMANUALGUI){
            return new GuiForgingManual();
        }
        return null;
    }

}
