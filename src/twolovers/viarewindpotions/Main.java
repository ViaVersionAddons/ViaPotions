package twolovers.viarewindpotions;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import twolovers.viarewindpotions.listeners.AreaEffectCloudListener;
import twolovers.viarewindpotions.listeners.SpawnEntityListener;
import twolovers.viarewindpotions.adapters.WorldEventAdapter;
import twolovers.viarewindpotions.utils.ConfigurationUtil;
import twolovers.viarewindpotions.utils.VersionUtil;
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
