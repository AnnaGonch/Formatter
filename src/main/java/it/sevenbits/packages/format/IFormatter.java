package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 *
 */
public interface IFormatter {
    /**
     *
     * @param in IReader
     * @param out IWriter
     */
    void format(IReader in, IWriter out) throws FormatException, ReaderException, WriterException;
}
