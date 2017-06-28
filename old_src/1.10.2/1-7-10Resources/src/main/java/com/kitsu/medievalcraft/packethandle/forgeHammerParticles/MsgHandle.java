package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import com.kitsu.medievalcraft.block.ingots.IngotBase;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandle implements IMessageHandler<MsgPacket, IMessage>{

	@Override
	public IMessage onMessage(MsgPacket message, MessageContext ctx) {
		IngotBase.makeParts = message.useme;
		//HotIronPlate.makeParts = message.useme;
		//System.out.println(message.useme);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
