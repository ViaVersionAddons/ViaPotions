package dev._2lstudios.viapotions.adapters;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import dev._2lstudios.viapotions.utils.SplashTranslator;
import dev._2lstudios.viapotions.utils.TranslationData;
import dev._2lstudios.viapotions.utils.VersionUtil;

public class WorldEventAdapter extends PacketAdapter {
	private final VersionUtil versionUtil;

	public WorldEventAdapter(final Plugin plugin, final VersionUtil versionUtil) {
		super(plugin, PacketType.Play.Server.WORLD_EVENT);

		this.versionUtil = versionUtil;
	}

	@Override
	public void onPacketSending(PacketEvent event) {
		if (event.isPlayerTemporary()) {
			return;
		}

		final PacketContainer packet = event.getPacket();
		final int effectId = packet.getIntegers().read(0);

		if (effectId == 2002 || effectId == 2007) {
			final Player player = event.getPlayer();
			final int version = versionUtil.getVersion(player);
			final PacketContainer edited = packet.deepClone();
			final StructureModifier<Integer> editedIntegers = edited.getIntegers();

			if (version <= 210) {
				editedIntegers.write(0, 2002);
			}

			for (final SplashTranslator translator : SplashTranslator.values()) {
				if (editedIntegers.read(1) == translator.getRGB()) {
					for (final TranslationData data : translator.getDatas()) {
						if (data.getLowestVersion() <= version && data.getHighestVersion() >= version) {
							editedIntegers.write(1, data.getRemap());
						}
					}
				}
			}

			try {
				ProtocolLibrary.getProtocolManager().sendServerPacket(player, edited, false);
			} catch (Exception e) {
				e.printStackTrace();
			}

			event.setCancelled(true);
		}
	}
}