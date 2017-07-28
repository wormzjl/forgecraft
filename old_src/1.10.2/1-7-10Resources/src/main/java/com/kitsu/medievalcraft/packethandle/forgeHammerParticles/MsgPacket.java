package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacket implements IMessage {
	
	public boolean useme;
	public MsgPacket() {}
	
	public MsgPacket(boolean b){
		this.useme = b;
	}


	@Override
	public void fromBytes(ByteBuf buf) {
		this.useme = buf.readBoolean();

		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.useme);

	}

}
