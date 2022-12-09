package net.kav.stamina_kav;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.kav.stamina_kav.client.gui.StaminaOverlay;
import net.kav.stamina_kav.event.ClientStamina;
import net.kav.stamina_kav.event.KeyInputHandler;
import net.kav.stamina_kav.networking.ModMessages;

public class StaminaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        HudRenderCallback.EVENT.register(new StaminaOverlay());
        KeyInputHandler.register();
        ClientTickEvents.END_WORLD_TICK.register(new ClientStamina());
    }
}