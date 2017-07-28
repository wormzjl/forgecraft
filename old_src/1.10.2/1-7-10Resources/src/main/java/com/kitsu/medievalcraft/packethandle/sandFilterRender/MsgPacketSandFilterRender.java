package com.kitsu.medievalcraft.packethandle.sandFilterRender;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketSandFilterRender implements IMessage {
	
	public int render;
	public MsgPacketSandFilterRender() {}
	
	public MsgPacketSandFilterRender(int b){
		this.render = b;
	}


	@Override
	public void fromBytes(ByteBuf buf) {
		this.render = buf.readInt();

		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.render);

	}

}
