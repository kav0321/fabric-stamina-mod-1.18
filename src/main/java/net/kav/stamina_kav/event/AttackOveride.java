package net.kav.stamina_kav.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.kav.stamina_kav.networking.ModMessages;
import net.minecraft.client.MinecraftClient;

public class AttackOveride {
    private static boolean con;

    public static void print()
    {

        if(!MinecraftClient.getInstance().player.isCreative())
        {
            con=true;
            ClientPlayNetworking.send(ModMessages.HANDSWING, PacketByteBufs.empty());
        }

    }

    public static void setCon(boolean cons)
    {
        con=cons;
    }

    public static boolean getCon()
    {
        return con;
    }


}