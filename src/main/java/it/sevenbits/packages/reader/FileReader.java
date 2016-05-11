package it.sevenbits.packages.reader;

import java.io.*;

/**
 *
 */
public class FileReader  implements IReader {

    private InputStream fileStream;
    private byte[] bytes;
    private int index;


    /**
     * FileReader
     * @param filename for  formatting
     * @throws ReaderException file not found
     */

    public FileReader(final String filename) throws ReaderException {
        try {

            index = 0;
            File file = new File(filename);
            fileStream = new FileInputStream(file);
            bytes = new byte[fileStream.available()];
            fileStream.read(bytes);
           // if (fileStream.available() == fileStream.read(arrayString))
            //    throw new ReaderException();
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }

    /**
     *
     * @return char
     * @throws ReaderException exception
     */
    public char read() throws ReaderException {
        try {
            char symbol = (char) bytes[index];
            index++;
            return   symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ReaderException(e);
        }
    }


    /**
     *
     * @return next char
     * @throws ReaderException exception
     */
    public int hasNext() throws ReaderException {
        try {
            char sym =  (char) bytes[index];
            return (int) sym;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     *@throws ReaderException exception
     */
    public void close() throws ReaderException {
        try {
            fileStream.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }




}
