package com.kitsu.medievalcraft.packethandle.forge;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketForge implements IMessage {

	public int caseType;

	public MsgPacketForge() {}

	public MsgPacketForge(int x){
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
