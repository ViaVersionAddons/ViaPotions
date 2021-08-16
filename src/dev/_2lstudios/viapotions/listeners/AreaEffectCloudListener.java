package dev._2lstudios.viapotions.listeners;

import org.bukkit.Location;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.plugin.Plugin;

import dev._2lstudios.viapotions.utils.VersionUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AreaEffectCloudListener implements Listener {
	final private List<AreaEffectCloud> effectClouds;

	public AreaEffectCloudListener(final Plugin plugin, final VersionUtil versionUtil) {
		effectClouds = new CopyOnWriteArrayList<>();

		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
			for (final AreaEffectCloud cloud : effectClouds) {
				if (cloud == null || cloud.isDead() || !cloud.isValid()) {
					effectClouds.remove(cloud);
				}
				else {
					final Location location = cloud.getLocation();
					final float radius = cloud.getRadius();
					final float area = (float) Math.PI * radius * radius;

					final int color = cloud.getColor().asRGB();
					final int red = color >> 16 & 255;
					final int green = color >> 8 & 255;
					final int blue = color & 255;

					for (int i = 0; i < area; i++) {
						float f1 = (float) Math.random() * 6.2831855F;
						float f2 = (float) Math.sqrt(Math.random()) * radius;
						float f3 = (float) Math.cos(f1) * f2;
						float f4 = (float) Math.sin(f1) * f2;

						for (final Player player : cloud.getWorld().getPlayers()) {
							if (versionUtil.getVersion(player) <= 106) {
								player.spawnParticle(cloud.getParticle(), location.getX() + f3, location.getY(), location.getZ() + f4, 0, red / 255f, green / 255f, blue / 255f);
							}
						}
					}
				}
			}
		}, 1L, 1L);
	}

	@EventHandler
	public void onLingeringPotionSplash(final LingeringPotionSplashEvent event) {
		effectClouds.add(event.getAreaEffectCloud());
	}
}
