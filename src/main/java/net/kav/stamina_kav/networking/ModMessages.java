package net.kav.stamina_kav.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.stamina_kav.Stamina;
import net.kav.stamina_kav.networking.packet.PlayerStatsC2S;
import net.kav.stamina_kav.util.IEntityDataSaver;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier STAMINA2 = new Identifier(Stamina.MOD_ID, "staminaa");
    public static final Identifier HANDSWING = new Identifier(Stamina.MOD_ID, "handswing");
    public static final Identifier STAMINA = new Identifier(Stamina.MOD_ID, "stamina");
    public static final Identifier MAXSTAMINAC2S = new Identifier(Stamina.MOD_ID, "maxstamina");
    public static final Identifier INITIALIZEM = new Identifier(Stamina.MOD_ID, "maxstaminaa");
    public static final Identifier INITIALIZER = new Identifier(Stamina.MOD_ID, "maxstaminar");
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(HANDSWING, PlayerStatsC2S::sendstats);
        ServerPlayNetworking.registerGlobalReceiver(MAXSTAMINAC2S, PlayerStatsC2S::getMaxSta);
        ServerPlayNetworking.registerGlobalReceiver(STAMINA, PlayerStatsC2S::getsta);
    }


    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(STAMINA2, (client, handler, buf, respondSender) ->
        {
            (((IEntityDataSaver) client.player)).getPersistentData().putFloat("Stamina",buf.readFloat());
        });


        ClientPlayNetworking.registerGlobalReceiver(INITIALIZEM, (client, handler, buf, respondSender) ->
        {
            if(client.player!=null)
            {
                (((IEntityDataSaver) client.player)).getPersistentData().putFloat("MaxStamina",buf.readFloat());
            }

        });
    }
}
