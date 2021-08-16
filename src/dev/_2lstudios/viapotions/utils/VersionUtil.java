package dev._2lstudios.viapotions.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import com.viaversion.viaversion.api.Via;

public class VersionUtil {
	private final Plugin viaVersion;

	public VersionUtil(final Plugin plugin) {
		final PluginManager pluginManager = plugin.getServer().getPluginManager();

		viaVersion = pluginManager.getPlugin("ViaVersion");
	}

	public int getVersion(Player player) {
		if (viaVersion != null) {
			return getViaVersionVersion(player);
		}

		return -1;
	}

	private int getViaVersionVersion(Player player) {
		return Via.getAPI().getPlayerVersion(player.getUniqueId());
	}
}
