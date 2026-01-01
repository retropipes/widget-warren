/*  WidgetWarren: A Maze-Solving Game
Copyright (C) 2008-2014 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.widgetwarren;

import org.retropipes.diane.Diane;
import org.retropipes.diane.gui.dialog.CommonDialogs;
import org.retropipes.diane.integration.Integration;

import com.puttysoftware.widgetwarren.prefs.PreferencesLauncher;
import com.puttysoftware.widgetwarren.resourcemanagers.LogoManager;

public class WidgetWarren {
    // Constants
    private static Application application;
    private static final String PROGRAM_NAME = "WidgetWarren";
    private static final String ERROR_MESSAGE = "Perhaps a bug is to blame for this error message.\n"
	    + "Include the error log with your bug report.\n" + "Email bug reports to: products@puttysoftware.com\n"
	    + "Subject: WidgetWarren Bug Report";
    private static final String ERROR_TITLE = "WidgetWarren Error";

    // Methods
    public static Application getApplication() {
	return WidgetWarren.application;
    }

    public static void logError(final Throwable t) {
	CommonDialogs.showErrorDialog(WidgetWarren.ERROR_MESSAGE, WidgetWarren.ERROR_TITLE);
	Diane.handleError(t);
    }

    public static void main(final String[] args) {
	try {
	    // Integrate with host platform
	    Diane.installDefaultErrorHandler(PROGRAM_NAME);
	    Integration i = Integration.integrate();
	    WidgetWarren.application = new Application();
	    WidgetWarren.application.postConstruct();
	    WidgetWarren.application.playLogoSound();
	    WidgetWarren.application.getGUIManager().showGUI();
	    // Register platform hooks
	    i.setAboutHandler(WidgetWarren.application.getAboutDialog());
	    i.setPreferencesHandler(new PreferencesLauncher());
	    i.setQuitHandler(WidgetWarren.application.getGUIManager());
	    // Set up Common Dialogs
	    CommonDialogs.setDefaultTitle(WidgetWarren.PROGRAM_NAME);
	    CommonDialogs.setIcon(LogoManager.getMicroLogo());
	} catch (final Throwable t) {
	    WidgetWarren.logError(t);
	}
    }
}
