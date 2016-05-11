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

        int count1 = 0;
        int count2 = 0;
        StringBuilder string = new StringBuilder();
        char symbol;

        try {
            while (in.hasNext() != -1) {
                symbol = in.read();
                if (symbol == '{') {
                    out.write("{"+"\n" + "    ");
                    count1++;
                } else  if (symbol == '}') {
                       out.write("\n" + "    " + "}");
                       count2++;
                   } else if (symbol == ';') {
                            out.write(";"+"\n" + "    ");
                        } else
                            out.write(""+symbol);

            }
            if (count1 != count2)
                throw new FormatException();
        } catch (ReaderException e) {
            throw new  FormatException();
        }

    }
}
