/*  WidgetWarren: A Maze-Solving Game
Copyright (C) 2008-2014 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.widgetwarren.resourcemanagers;

import org.retropipes.diane.asset.sound.DianeSoundPlayer;

import com.puttysoftware.widgetwarren.prefs.PreferencesManager;

public class SoundManager {
    private static final String DEFAULT_LOAD_PATH = "/com/puttysoftware/widgetwarren/resources/sounds/";
    private static String LOAD_PATH = SoundManager.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = SoundManager.class;

    public static void playSound(final int soundCat, final int soundID) {
	if (PreferencesManager.getSoundEnabled(soundCat + 1)) {
	    try {
		final String soundName = SoundConstants.NAMES[soundID];
		DianeSoundPlayer.playSource(
			SoundManager.LOAD_CLASS.getResource(SoundManager.LOAD_PATH + soundName.toLowerCase() + ".wav"));
	    } catch (final ArrayIndexOutOfBoundsException aioob) {
		// Do nothing
	    }
	}
    }
}