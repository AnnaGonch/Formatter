package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;
/**
 *
 */
public class Formatter implements IFormatter {

    /**
     *
     * @param in IReader
     * @param out IWriter
     * @throws ReaderException exception
     * @throws WriterException exception
     * @throws FormatException exception
     */

    public void format(final IReader in, final IWriter out) throws ReaderException, WriterException, FormatException {
        char symbol;
        boolean statusBrace = false;
        int countIndent = 0;
        try {
            while (in.hasNext() != -1) {
                symbol = in.read();
                if (symbol == '{') {
                    if (statusBrace) {
                        countIndent++;
                        out.write("{" + "\n" + makeIndent(countIndent));
                    } else {
                        statusBrace = true;
                        out.write("{" + "\n" + makeIndent(countIndent));
                    }
                    continue;
                }
                if (symbol == '}') {
                    countIndent--;
                    if (statusBrace) {
                        statusBrace = false;
                    }
                    out.write("\n" + makeIndent(countIndent) + "}" + "\n");
                    continue;
                }
                if (symbol == ';') {
                    out.write(";" + "\n" + makeIndent(countIndent));
                    continue;
                }
                out.write("" + symbol);
            }
        } catch (ReaderException e) {
            throw new FormatException(e);
        } catch (WriterException e) {
            throw new FormatException(e);
        }
    }
    /**
     *
     * @param count Indent
     * @return string
     */
    public String makeIndent(final int count) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= count; i++)
            str.append("    ");
        return str.toString();
    }
}