package net.kav.stamina_kav.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.world.ClientWorld;

public class StaminaControl implements ClientTickEvents.EndWorldTick{

    int x1 = 0;
    int y = 0;
    public static boolean con=true;
    public static float stamina=0;
    @Override
    public void onEndTick(ClientWorld world) {

    }
}

