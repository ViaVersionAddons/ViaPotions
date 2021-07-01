package dev._2lstudios.viarewindpotions.utils;

public class TranslationData {
	private int remap, lowestVersion, highestVersion;

	public TranslationData(int remap, int lowestVersion, int highestVersion) {
		this.remap = remap;
		this.lowestVersion = lowestVersion;
		this.highestVersion = highestVersion;
	}

	public int getRemap() {
		return remap;
	}

	public int getLowestVersion() {
		return lowestVersion;
	}

	public int getHighestVersion() {
		return highestVersion;
	}

}
