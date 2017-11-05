package nmd.primal.forgecraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

/**
 * Created by mminaie on 11/5/17.
 */
public class CommandShowWiki extends CommandBase {

    /**
     * Check if the given ICommandSender has permission to execute this command
     */
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return server.isSinglePlayer() || super.checkPermission(server, sender);
    }

    /**
     * Gets the name of the command
     */
    public String getName()
    {
        return "ForgeCraftWiki";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    /**
     * Gets the usage string for the command.
     */
    public String getUsage(ICommandSender sender)
    {
        return "OpenUrl";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        String str = "https://sites.google.com/view/forgecraft/home/wiki";
        ClickEvent event = new ClickEvent(ClickEvent.Action.OPEN_URL, str);
        ITextComponent link = new TextComponentString("Wiki").setStyle(new Style().setClickEvent(event).setColor(TextFormatting.BLUE));
        sender.sendMessage(link);
    }

}
