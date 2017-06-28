package com.kitsu.medievalcraft.packethandle.shelf;

import com.kitsu.medievalcraft.block.wood.ShelfFour;
import com.kitsu.medievalcraft.item.misc.RawCuredLeather;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherX;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleShelfCase implements IMessageHandler<MsgPacketShelfCase, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketShelfCase message, MessageContext ctx) {
		ShelfFour.caseType = message.caseType;
		return null;
	}
}
