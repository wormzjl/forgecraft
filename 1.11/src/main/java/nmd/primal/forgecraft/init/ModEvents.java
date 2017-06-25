package nmd.primal.forgecraft.init;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.CommonEvents;

/**
 * Created by mminaie on 3/15/17.
 */
public class ModEvents {

    public static void registerCommonEvents()
    {

        MinecraftForge.EVENT_BUS.register(new CommonEvents());

    }

}
