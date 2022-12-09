package net.kav.stamina_kav.networking.packet;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.stamina_kav.networking.ModMessages;
import net.kav.stamina_kav.util.IEntityDataSaver;
import net.kav.stamina_kav.util.StaminaData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class PlayerStatsC2S {


    public static void getMaxSta(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {
        ((IEntityDataSaver) player).getPersistentData().putFloat("MaxStamina",buf.readFloat());
    }


    public static void getsta(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {


        ((IEntityDataSaver) player).getPersistentData().putFloat("Stamina",buf.readFloat());
        // System.out.println(StaminaData.Stamina(((IEntityDataSaver) player)));

    }


    public static void sendstats(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {
        float x12;
        double d = 0;
        ItemStack itemss = player.getMainHandStack();
        Item item = itemss.getItem();
        Multimap<EntityAttribute, EntityAttributeModifier> multimap = itemss.getAttributeModifiers(EquipmentSlot.MAINHAND);
        if (!multimap.isEmpty()) {
            Iterator var11 = multimap.entries().iterator();
            while(var11.hasNext()) {
                Map.Entry<EntityAttribute, EntityAttributeModifier> entry = (Map.Entry)var11.next();
                EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier)entry.getValue();
                d = entityAttributeModifier.getValue();

            }
            //EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier) item.getAttributeModifiers(EquipmentSlot.MAINHAND).get(EntityAttributes.GENERIC_ATTACK_SPEED);
            d=abs(d);
            // player.sendMessage(Text.of(Double.toString(d)),true);
        }




        //////player.sendMessage(Text.of(Float.toString(SoulData.addFloatpoint(((IEntityDataSaver) player), 0f, "Stamina"))),true);


        if(player.isCreative())
        {
            x12=0;
        }
        else
            x12= (float) (d)+3;

        if(x12>4)
        {
            x12= (float) (-1.1859*pow(x12,2)+20.286*x12-69.792);
        }

        MinecraftClient.getInstance().player.sendMessage(Text.of(Float.toString(x12)),true);

        float xz = StaminaData.removePoints(((IEntityDataSaver) player),x12,"Stamina");
        PacketByteBuf bufs = PacketByteBufs.create();
        bufs.writeFloat(xz);
        ServerPlayNetworking.send(player, ModMessages.STAMINA2,bufs);
    }
}
