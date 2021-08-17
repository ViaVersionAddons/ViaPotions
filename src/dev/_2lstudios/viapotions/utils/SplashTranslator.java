package dev._2lstudios.viapotions.utils;

public enum SplashTranslator {
	NIGHT_VISION(2039713, new TranslationData(8356774, 0, 106), new TranslationData(5, 107, 210)),
	INVISIBILITY(8356754, new TranslationData(8356778, 0, 106), new TranslationData(7, 107, 210)),
	JUMP_BOOST(2293580, new TranslationData(8356772, 0, 46), new TranslationData(8356772, 48, 106), new TranslationData(8356779, 47, 47), new TranslationData(9, 107, 210)),
	FIRE_RESISTANCE(14981690, new TranslationData(9643043, 0, 106), new TranslationData(12, 107, 210)),
	SPEED(8171462, new TranslationData(8356754, 0, 106), new TranslationData(14, 107, 210)),
	SLOWNESS(5926017, new TranslationData(6655210, 0, 106), new TranslationData(17, 107, 210)),
	TURTLE_MASTER(7691106, new TranslationData(4738376, 0, 106), new TranslationData(34, 107, 210)),
	WATER_BREATHING(3035801, new TranslationData(3035767, 0, 106), new TranslationData(19, 107, 210)),
	INSTANT_HEALTH(16262179, new TranslationData(8356757, 0, 106), new TranslationData(21, 107, 210)),
	INSTANT_DAMAGE(4393481, new TranslationData(2293580, 0, 106), new TranslationData(23, 107, 210)),
	POISON(3381504, new TranslationData(8356772, 0, 106), new TranslationData(25, 107, 210)),
	REGENERATION(13458603, new TranslationData(2039713, 0, 106), new TranslationData(28, 107, 210)),
	STRENGTH(9643043, new TranslationData(3035801, 0, 106), new TranslationData(31, 107, 210)),
	WEAKNESS(4738376, new TranslationData(34, 107, 210)),
	LUCK(3381504, new TranslationData(8356772, 0, 106), new TranslationData(36, 107, 210)),
	SLOW_FALLING(16773073, new TranslationData(8356754, 0, 106), new TranslationData(14, 107, 210));

	private int rgb;
	private TranslationData[] datas;

	SplashTranslator(int rgb, TranslationData... datas) {
		this.rgb = rgb;
		this.datas = datas;
	}

	public int getRGB() {
		return rgb;
	}

	public TranslationData[] getDatas() {
		return datas;
	}
}
