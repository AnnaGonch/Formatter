package it.sevenbits.packages.writer;

import java.io.*;

/**
 *
 */
public class FileWriter implements IWriter {


    private OutputStream fileStream;
    private Writer fileWriter;

    /**
     * FileWriter constructor
     * @param filename name file with java code
     * @throws WriterException exception
     */

    public FileWriter(final String filename) throws  WriterException {
        try {
            fileStream = new FileOutputStream(filename);
            fileWriter = new OutputStreamWriter(fileStream);
        } catch (FileNotFoundException e) {
            throw new WriterException(e);
        }
    }

    /**
     * write method
     * @param  string String
     * @throws WriterException  exception
     */
    public void write(final String string) throws WriterException {
        try {
            fileWriter.write(string);
        } catch (IOException e) {
            throw new WriterException(e);
        }

    }

    /**
     * close method:close OutputStream
     *@throws WriterException  exception
     */
    public void close() throws WriterException {
        try {

            fileWriter.close();
            fileStream.close();
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

}
