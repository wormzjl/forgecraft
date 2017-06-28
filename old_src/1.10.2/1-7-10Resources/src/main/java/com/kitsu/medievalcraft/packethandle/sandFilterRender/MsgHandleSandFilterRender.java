package com.kitsu.medievalcraft.packethandle.sandFilterRender;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleSandFilterRender implements IMessageHandler<MsgPacketSandFilterRender, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketSandFilterRender message, MessageContext ctx) {
		//TileEntitySandFilter.renderFilter = message.render;
		//SandFilter.renderInt = message.render;
		
		//System.out.println(message.useme);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
