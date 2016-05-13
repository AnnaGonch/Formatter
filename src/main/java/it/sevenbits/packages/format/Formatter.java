package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

import java.util.Map;


/**
 *
 */
public class Formatter implements IFormatter {
    /**
     *
     * @param in IReader
     * @param out IWriter
     * @param tableSymbol map symbol
     * @throws ReaderException exception
     * @throws WriterException exception
     * @throws FormatException exception
     */

    public void format(final IReader in, final IWriter out, final Map<Character, String> tableSymbol) throws ReaderException, WriterException, FormatException {

        int count1 = 0;
        int count2 = 0;
        char symbol;

        try {
            while (in.hasNext() != -1) {
                symbol = in.read();
                if (tableSymbol.containsKey(symbol)) {
                    out.write(tableSymbol.get(symbol));
                } else {
                    out.write("" + symbol);
                }
                if (symbol == '{') {
                    count1++;
                }
                if (symbol == '}') {
                    count2++;
                }

            }
            if (count1 != count2) {
                throw new FormatException();
            }
        } catch (ReaderException e) {
            throw new  FormatException();
        }

    }
}