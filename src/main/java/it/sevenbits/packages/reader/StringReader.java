package it.sevenbits.packages.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 *class StringReader read string
 */
public class StringReader implements IReader {

    private String str;
    private InputStream stringStream;
    private byte[] bytes;
    private int index = 0;


    /**
     *
     * @param str String
     * @throws ReaderException exception
     */
    public StringReader(final String str) throws ReaderException {

        this.str = str;
        try {
            stringStream = new StringBufferInputStream(str);
            bytes = new byte[stringStream.available()];
            stringStream.read(bytes);
        } catch (Exception e) {
            throw new ReaderException(e);
        }
        }

    /**
     * reade method
     * @return char
     * @throws ReaderException exception
     */
    public char read() throws ReaderException {
        try {
            char symbol =  (char) bytes[index];
            index++;
            return  symbol;
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

    /**
     * hasNext
     * @return char
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
     *
     * @throws ReaderException exception
     */

    public void close() throws ReaderException {
        try {
            stringStream.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }



}
