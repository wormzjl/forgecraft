package com.kitsu.medievalcraft.packethandle.curedLeather;

import com.kitsu.medievalcraft.item.misc.RawCuredLeather;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleCuredLeatherY implements IMessageHandler<MsgPacketCuredLeatherY, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketCuredLeatherY message, MessageContext ctx) {

		//HotIronBlock.locX = message.locx;
		//HotIronPlate.locX = message.locx;
		RawCuredLeather.serverY = message.curedLeathery;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
