package com.kitsu.medievalcraft.packethandle.curedLeather;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketCuredLeatherX implements IMessage {

	public int curedLeatherx;

	public MsgPacketCuredLeatherX() {}

	public MsgPacketCuredLeatherX(int x){
		this.curedLeatherx = x;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.curedLeatherx = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.curedLeatherx);
	}

}
