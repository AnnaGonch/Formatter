package it.sevenbits.packages.bootstrap;

import it.sevenbits.packages.format.FormatException;
import it.sevenbits.packages.format.Formatter;
import it.sevenbits.packages.reader.FileReader;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.reader.StringReader;
import it.sevenbits.packages.writer.FileWriter;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 *
 */
final class Main {
    /**
     *
     */
    private Main(){}

    /**
     *
     * @param args string array
     * @throws ReaderException exception
     * @throws WriterException exception
     * @throws FormatException exception
     */
    public static void main(final String[] args) throws ReaderException, WriterException, FormatException {



       IReader inString = new StringReader("while(){param};if(){};");
      // IWriter outString = new StringWriter();
        IWriter outString = new FileWriter("OutString.txt");

        IReader inFile = new FileReader("file.txt");
        IWriter outFile = new FileWriter("OUTfile.txt");

        Formatter formatter = new Formatter();
        formatter.format(inString, outString);
        formatter.format(inFile, outFile);


        inString.close();
        outString.close();
        inFile.close();
        outFile.close();





    }
}
