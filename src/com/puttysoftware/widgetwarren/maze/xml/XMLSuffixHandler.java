package com.puttysoftware.widgetwarren.maze.xml;

import java.io.IOException;

import org.retropipes.diane.fileio.XDataReader;
import org.retropipes.diane.fileio.XDataWriter;

import com.puttysoftware.widgetwarren.WidgetWarren;

public class XMLSuffixHandler implements XMLSuffixIO {
    @Override
    public void readSuffix(final XDataReader reader, final int formatVersion)
            throws IOException {
        WidgetWarren.getApplication().getGameManager().loadGameHookXML(reader,
                formatVersion);
    }

    @Override
    public void writeSuffix(final XDataWriter writer) throws IOException {
        WidgetWarren.getApplication().getGameManager().saveGameHookXML(writer);
    }
}
