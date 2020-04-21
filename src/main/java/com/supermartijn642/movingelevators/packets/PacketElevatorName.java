package com.supermartijn642.movingelevators.packets;

import com.supermartijn642.movingelevators.ElevatorBlockTile;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created 4/21/2020 by SuperMartijn642
 */
public class PacketElevatorName implements IMessage, IMessageHandler<PacketElevatorName,IMessage> {

    public BlockPos pos;
    public String name;

    public PacketElevatorName(BlockPos pos, String name){
        this.pos = pos;
        this.name = name;
    }

    public PacketElevatorName(){
    }

    @Override
    public void fromBytes(ByteBuf buf){
        this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
        if(buf.readBoolean())
            this.name = null;
        else{
            byte[] bytes = new byte[buf.readInt()];
            buf.readBytes(bytes);
            this.name = new String(bytes);
        }
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(this.pos.getX());
        buf.writeInt(this.pos.getY());
        buf.writeInt(this.pos.getZ());
        buf.writeBoolean(this.name == null);
        if(this.name != null){
            byte[] bytes = this.name.getBytes();
            buf.writeInt(bytes.length);
            buf.writeBytes(bytes);
        }
    }

    @Override
    public IMessage onMessage(PacketElevatorName message, MessageContext ctx){
        EntityPlayer player = ctx.getServerHandler().player;
        if(player == null)
            return null;
        World world = player.world;
        if(world == null)
            return null;
        TileEntity tile = world.getTileEntity(message.pos);
        if(!(tile instanceof ElevatorBlockTile))
            return null;
        player.getServer().addScheduledTask(() -> ((ElevatorBlockTile)tile).setName(message.name));
        return null;
    }
}