package com.puttysoftware.widgetwarren.maze.xml;

import java.io.IOException;

import org.retropipes.diane.fileio.XDataReader;
import org.retropipes.diane.fileio.XDataWriter;

public interface XMLSuffixIO {
    void writeSuffix(XDataWriter writer) throws IOException;

    void readSuffix(XDataReader reader, int formatVersion) throws IOException;
}
