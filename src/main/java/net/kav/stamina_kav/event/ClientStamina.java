package net.kav.stamina_kav.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.kav.stamina_kav.networking.ModMessages;
import net.kav.stamina_kav.util.IEntityDataSaver;
import net.kav.stamina_kav.util.StaminaData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;

public class ClientStamina implements ClientTickEvents.EndWorldTick{
    int x1 = 0;
    int y = 0;
    public static boolean con=true;
    @Override
    public void onEndTick(ClientWorld world) {






        y++;
        x1++;
        if (x1 >= 10) {
            x1 = 0;

        }

        if (MinecraftClient.getInstance().player.handSwinging == false && x1==9&& MinecraftClient.getInstance().player.isSprinting()==false&&AttackOveride.getCon()==false) {
            PacketByteBuf buf = PacketByteBufs.create();
            //add sound

            //PacketByteBuf bufss = PacketByteBufs.create();

            float x = StaminaData.addPoints(((IEntityDataSaver) MinecraftClient.getInstance().player), 0.7f, "Stamina");
            buf.writeFloat(x);
            //bufss.writeFloat(y);

            ClientPlayNetworking.send(ModMessages.STAMINA, buf);

        }
        AttackOveride.setCon(false);




    }
}
