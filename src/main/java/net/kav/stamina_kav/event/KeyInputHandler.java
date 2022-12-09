package net.kav.stamina_kav.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.kav.stamina_kav.networking.ModMessages;
import net.kav.stamina_kav.util.IEntityDataSaver;
import net.kav.stamina_kav.util.StaminaData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY_SOUL ="key.category.soul.soul";

    public static final String KEY_GAINING_SOUL = "key.soul.gaining_soul";
    public static final String KEY_GAINING_SOUL_MOUNT = "key.soul.gaining_soul_mount";
    public static KeyBinding gainingkey;
    public static KeyBinding gainingkey2;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(client.player!=null)
            {
                if(gainingkey2.wasPressed()){
                /*    PacketByteBuf buf= PacketByteBufs.create();
                    float y= StaminaData.addPoints(((IEntityDataSaver) MinecraftClient.getInstance().player), 1, "MaxStamina");
                    buf.writeFloat(y);

                    ClientPlayNetworking.send(ModMessages.MAXSTAMINAC2S,buf);
*/
                }

            }





        });
    }



    public static void register()
    {


        gainingkey2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_GAINING_SOUL_MOUNT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                KEY_CATEGORY_SOUL
        ));



        registerKeyInputs();

    }






}