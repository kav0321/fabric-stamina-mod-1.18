package net.kav.stamina_kav.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.stamina_kav.networking.ModMessages;
import net.kav.stamina_kav.util.IEntityDataSaver;
import net.kav.stamina_kav.util.StaminaData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class serverevent implements ServerTickEvents.EndTick {
    int x1 = 0;
    int y=0;
    float x12;
    @Override
    public void onEndTick(MinecraftServer server) {

        //final int y =server.getTicks();

        x1++;
        if (x1 >= 11) {
            x1 = 0;

        }


        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {









            if(StaminaData.Stamina(((IEntityDataSaver) player))<1)
            {
                String xa= player.getName().getString();
                server.getCommandManager().execute(new ServerCommandSource(CommandOutput.DUMMY,player.getPos(),player.getRotationClient(), player.getWorld(),4,"", Text.of("k"), server,player),"effect give "+xa+" minecraft:weakness 2 3 true");
            }


            if(!StaminaData.JOIN(((IEntityDataSaver) player)))
            {
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeFloat(StaminaData.addPoints(((IEntityDataSaver) player),0,"MaxStamina"));
                ServerPlayNetworking.send((ServerPlayerEntity) player, ModMessages.INITIALIZEM, buf);
            }


        }



    }
}

