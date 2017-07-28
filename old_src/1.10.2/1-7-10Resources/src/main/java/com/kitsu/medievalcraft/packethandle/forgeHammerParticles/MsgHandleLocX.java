package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import com.kitsu.medievalcraft.block.ingots.IngotBase;
import com.kitsu.medievalcraft.block.machines.Forge;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleLocX implements IMessageHandler<MsgPacketLocX, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketLocX message, MessageContext ctx) {

		IngotBase.locX = message.locx;

		return null;
	}
}
