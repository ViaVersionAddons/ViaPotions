package dev._2lstudios.viapotions.utils;

import org.bukkit.potion.PotionEffectType;


public enum PotionTranslator {
	NIGHT_VISION(PotionEffectType.NIGHT_VISION, new TranslationData(16422, 0, 106)),
	INVISIBILITY(PotionEffectType.INVISIBILITY, new TranslationData(16430, 0, 106)),
	JUMP_BOOST(PotionEffectType.JUMP, new TranslationData(16388, 0, 46), new TranslationData(16388, 48, 106), new TranslationData(16395, 47, 47)),
	FIRE_RESISTANCE(PotionEffectType.FIRE_RESISTANCE, new TranslationData(16419, 0, 106)),
	SPEED(PotionEffectType.SPEED, new TranslationData(16386, 0, 106)),
	SLOWNESS(PotionEffectType.SLOW, new TranslationData(16426, 0, 106)),
	TURTLE_MASTER(PotionEffectType.DAMAGE_RESISTANCE, new TranslationData(16424, 0, 106)),
	WATER_BREATHING(PotionEffectType.WATER_BREATHING, new TranslationData(16429, 0, 106)),
	INSTANT_HEALTH(PotionEffectType.HEAL, new TranslationData(16453, 0, 106)),
	INSTANT_DAMAGE(PotionEffectType.HARM, new TranslationData(16460, 0, 106)),
	POISON(PotionEffectType.POISON, new TranslationData(16388, 0, 106)),
	REGENERATION(PotionEffectType.REGENERATION, new TranslationData(16385, 0, 106)),
	STRENGTH(PotionEffectType.INCREASE_DAMAGE, new TranslationData(16393, 0, 106)),
	WEAKNESS(PotionEffectType.WEAKNESS, new TranslationData(16424, 0, 106)),
	LUCK(PotionEffectType.LUCK, new TranslationData(16388, 0, 106)),
	SLOW_FALLING(PotionEffectType.SLOW_FALLING, new TranslationData(16394, 0, 106));

	private PotionEffectType effect;
	private TranslationData[] datas;

	PotionTranslator(PotionEffectType effect, TranslationData... datas) {
		this.effect = effect;
		this.datas = datas;
	}

	public PotionEffectType getPotionEffectType() {
		return effect;
	}

	public TranslationData[] getDatas() {
		return datas;
	}
}
