package dev._2lstudios.viarewindpotions;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev._2lstudios.viarewindpotions.adapters.WorldEventAdapter;
import dev._2lstudios.viarewindpotions.listeners.AreaEffectCloudListener;
import dev._2lstudios.viarewindpotions.listeners.SpawnEntityListener;
import dev._2lstudios.viarewindpotions.utils.ConfigurationUtil;
import dev._2lstudios.viarewindpotions.utils.VersionUtil;

public class Main extends JavaPlugin {
	public void onEnable() {
		final ConfigurationUtil configurationUtil = new ConfigurationUtil(this);
		final VersionUtil versionUtil = new VersionUtil(this);
		final PluginManager pluginManager = getServer().getPluginManager();
		final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

		if (pluginManager.isPluginEnabled("ProtocolSupport") || pluginManager.isPluginEnabled("ViaRewind")) {
			getLogger().info("ViaRewind/ProtocolSupport detected, enabling integration.");
		} else if (pluginManager.isPluginEnabled("ViaBackwards")) {
			getLogger().warning("ViaBackwards detected. In order to make ViaPotions work correctly, it is required that you have ViaRewind installed.");
		} else {
			getLogger().severe("No compatible plugins have been detected, disabling the plugin.");
			getLogger().severe("In order to make ViaPotions functional, ViaRewind or ProtocolSupport must be installed.");
			pluginManager.disablePlugin(this);
		}
		
		if (pluginManager.getPlugin("ViaRewind-Legacy-Support") == null || !configurationUtil.getConfiguration("%datafolder%/ViaRewind-Legacy-Support/config.yml").getBoolean("area-effect-cloud-particles")) {
			pluginManager.registerEvents(new AreaEffectCloudListener(this, versionUtil), this);
		}

		protocolManager.addPacketListener(new SpawnEntityListener(this, versionUtil));
		protocolManager.addPacketListener(new WorldEventAdapter(this, versionUtil));
	}
}
