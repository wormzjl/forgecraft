package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketLocY implements IMessage {

	public int locy;

	public MsgPacketLocY() {}

	public MsgPacketLocY(int y){
		this.locy = y;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.locy = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locy);
	}

}
