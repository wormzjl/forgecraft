package com.kitsu.medievalcraft.tileents;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntitySmallBarrel extends TileEntity {

	private String smallBarrelName;
	private NBTTagCompound nbt = new NBTTagCompound();
	public boolean soakedloaded, scuddedloaded, soakedready, scuddedready;
	public int quanta, ticks, case0, case1, case2, case3, case4, case5;
	public String type = "empty";
	public String res = "null";
	ResourceLocation unt = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrel.png");
	ResourceLocation unt0 = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrelLid.png");
	ResourceLocation unt1 = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrelSlack1.png");
	ResourceLocation unt2 = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrelSlack2.png");
	ResourceLocation unt3 = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrelTan1.png");
	ResourceLocation unt4 = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrelTan2.png");

	public void forgeName(String string){
		this.smallBarrelName = string;
	}

	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		//int x = this.xCoord;
		//int y = this.yCoord;
		//int z = this.zCoord;

		if(!world.isRemote){
			//System.out.println(this.lid +":"+ this.type +":"+ this.quanta);
			//System.out.println("soaked"+this.soakedloaded+":"+this.soakedready);
			//System.out.println("scudded"+this.scuddedloaded+":"+this.scuddedready);

			if(soakedloaded==true){
				if(type.equals("slack")){
					//if(lid==true){
						if(soakedready==false){
							if(quanta>0){
								ticks++;
								//System.out.println(ticks);
							}
							if(ticks>=180){
								soakedready=true;
								quanta--;
								ticks = 0;
								if(quanta==0){
									type="empty";
								}
								//System.out.println(this.soakedready+":"+this.quanta+":"+this.ticks);
							}
						}
					//}
				}
			}
			
			if(scuddedloaded==true){
				if(type.equals("tannin")){
					//if(lid==true){
						if(scuddedready==false){
							if(quanta>0){
								ticks++;
								System.out.println(ticks);
							}
							if(ticks>=180){
								scuddedready=true;
								quanta--;
								ticks = 0;
								if(quanta==0){
									type="empty";
								}
							}
						}
					//}
				}
			}
		}
	}
	
	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		if (nbt.hasKey("CustomName", 8)) {
			this.smallBarrelName = nbt.getString("CustomName");
		}
		//this.lid = nbt.getBoolean("LID");
		this.quanta = nbt.getInteger("QUANTA");
		this.soakedloaded = nbt.getBoolean("SOAKEDLOADED");
		this.scuddedloaded = nbt.getBoolean("SCUDDEDLOADED");
		this.soakedready =  nbt.getBoolean("SOAKEDREADY");
		this.scuddedready =  nbt.getBoolean("SCUDDEDREADY");
		this.type = nbt.getString("TYPE");
		this.res = nbt.getString("RES");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		//nbt.setBoolean("LID", lid);
		nbt.setInteger("QUANTA", quanta);
		nbt.setBoolean("SOAKEDLOADED", soakedloaded);
		nbt.setBoolean("SCUDDEDLOADED", scuddedloaded);
		nbt.setBoolean("SOAKEDREADY", soakedready);
		nbt.setBoolean("SCUDDEDREADY", scuddedready);
		nbt.setString("TYPE", type);
		nbt.setString(("RES"), res);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 998, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
}
