package com.kitsu.medievalcraft.packethandle.forge;

import com.kitsu.medievalcraft.block.machines.Forge;
import com.kitsu.medievalcraft.block.wood.ShelfFour;
import com.kitsu.medievalcraft.packethandle.shelf.MsgPacketShelfCase;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleForge implements IMessageHandler<MsgPacketForge, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketForge message, MessageContext ctx) {
		Forge.sideMeta = message.caseType;
		return null;
	}
}
