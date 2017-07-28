package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import com.kitsu.medievalcraft.block.ingots.IngotBase;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleLocZ implements IMessageHandler<MsgPacketLocZ, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketLocZ message, MessageContext ctx) {

		IngotBase.locZ = message.locz;
		//HotIronPlate.locZ = message.locz;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
