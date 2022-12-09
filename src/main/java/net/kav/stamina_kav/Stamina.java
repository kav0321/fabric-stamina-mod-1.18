package net.kav.stamina_kav;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.kav.stamina_kav.event.serverevent;
import net.kav.stamina_kav.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stamina implements ModInitializer {


	public static final String MOD_ID ="stamina_kav";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModMessages.registerC2SPackets();
		ServerTickEvents.END_SERVER_TICK.register(new serverevent());
		LOGGER.info("Hello Fabric world!");
	}
}
