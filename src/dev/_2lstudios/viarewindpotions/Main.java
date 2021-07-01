package dev._2lstudios.viarewindpotions;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import dev._2lstudios.viarewindpotions.listeners.AreaEffectCloudListener;
import dev._2lstudios.viarewindpotions.listeners.SpawnEntityListener;
import dev._2lstudios.viarewindpotions.adapters.WorldEventAdapter;
import dev._2lstudios.viarewindpotions.utils.ConfigurationUtil;
import dev._2lstudios.viarewindpotions.utils.VersionUtil;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		final ConfigurationUtil configurationUtil = new ConfigurationUtil(this);
		final VersionUtil versionUtil = new VersionUtil(this);
		final PluginManager pluginManager = getServer().getPluginManager();
		final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

		if (pluginManager.getPlugin("ViaRewind-Legacy-Support") == null || !configurationUtil.getConfiguration("%datafolder%/ViaRewind-Legacy-Support/config.yml").getBoolean("area-effect-cloud-particles"))
			pluginManager.registerEvents(new AreaEffectCloudListener(this, versionUtil), this);

		protocolManager.addPacketListener(new SpawnEntityListener(this, versionUtil));
		protocolManager.addPacketListener(new WorldEventAdapter(this, versionUtil));
	}
}
