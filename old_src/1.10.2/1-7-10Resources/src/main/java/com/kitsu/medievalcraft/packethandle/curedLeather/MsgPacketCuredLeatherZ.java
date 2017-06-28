package com.kitsu.medievalcraft.packethandle.curedLeather;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketCuredLeatherZ implements IMessage {

	public int curedLeatherz;

	public MsgPacketCuredLeatherZ() {}

	public MsgPacketCuredLeatherZ(int z){
		this.curedLeatherz = z;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.curedLeatherz = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.curedLeatherz);
	}

}
