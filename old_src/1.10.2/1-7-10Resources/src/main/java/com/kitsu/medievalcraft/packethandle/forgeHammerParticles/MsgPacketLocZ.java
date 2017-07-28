package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketLocZ implements IMessage {

	public int locz;
	
	public MsgPacketLocZ() {}

	public MsgPacketLocZ(int z){
		this.locz = z;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.locz = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locz);
	}

}
