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
     * @throws FormatException exception for IFormatter interface
     * @throws ReaderException exception for IReader interface
     * @throws WriterException exception for IWriter interface
     */
    void format(final IReader in, final IWriter out) throws ReaderException, WriterException, FormatException;

    /**
     *  makeIndent
     * @param count Indent
     * @return string
     */
    String makeIndent(int count);
}

