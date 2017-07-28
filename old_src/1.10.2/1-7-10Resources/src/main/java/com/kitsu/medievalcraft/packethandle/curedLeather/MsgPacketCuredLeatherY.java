package com.kitsu.medievalcraft.packethandle.curedLeather;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketCuredLeatherY implements IMessage {

	public int curedLeathery;

	public MsgPacketCuredLeatherY() {}

	public MsgPacketCuredLeatherY(int y){
		this.curedLeathery = y;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.curedLeathery = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.curedLeathery);
	}

}
