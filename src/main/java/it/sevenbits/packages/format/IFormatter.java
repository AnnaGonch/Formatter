package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

import java.util.Map;

/**
 *
 */
public interface IFormatter {
    /**
     *
     * @param in IReader
     * @param out IWriter
     * @param tableSymbol symbols
     * @throws FormatException exception for IFormatter interface
     * @throws ReaderException exception for IReader interface
     * @throws WriterException exception for IWriter interface
     */
    void format(IReader in, IWriter out, Map<Character, String> tableSymbol) throws FormatException, ReaderException, WriterException;
}
