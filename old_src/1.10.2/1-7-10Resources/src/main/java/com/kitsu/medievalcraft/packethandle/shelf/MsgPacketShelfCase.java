package com.kitsu.medievalcraft.packethandle.shelf;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketShelfCase implements IMessage {

	public int caseType;

	public MsgPacketShelfCase() {}

	public MsgPacketShelfCase(int x){
		this.caseType = x;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.caseType = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.caseType);
	}

}
