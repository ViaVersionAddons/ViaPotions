package dev._2lstudios.viarewindpotions.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import protocolsupport.api.ProtocolSupportAPI;
import protocolsupport.api.ProtocolType;
import com.viaversion.viaversion.api.Via;

public class VersionUtil {
	private final Plugin protocolSupport;
	private final Plugin viaVersion;

	public VersionUtil(final Plugin plugin) {
		final PluginManager pluginManager = plugin.getServer().getPluginManager();

		protocolSupport = pluginManager.getPlugin("ProtocolSupport");
		viaVersion = pluginManager.getPlugin("ViaVersion");
	}

	public int getVersion(Player player) {
		if (protocolSupport != null) {
			final int protocolSupportVersion = getProtocolSupportVersion(player);
			final int latest = protocolsupport.api.ProtocolVersion.getLatest(ProtocolType.PC).getId();

			if (protocolSupportVersion == latest && viaVersion != null) {
				final int viaVersionVersion = getViaVersionVersion(player);

				if (viaVersionVersion != latest)
					return viaVersionVersion;
			}

			return protocolSupportVersion;
		} else if (viaVersion != null)
			return getViaVersionVersion(player);

		return -1;
	}

	private int getProtocolSupportVersion(Player player) {
		return ProtocolSupportAPI.getConnection(player).getVersion().getId();
	}

	private int getViaVersionVersion(Player player) {
		return Via.getAPI().getPlayerVersion(player.getUniqueId());
	}
}
