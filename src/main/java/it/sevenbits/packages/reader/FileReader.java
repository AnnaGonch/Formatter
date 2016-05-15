package it.sevenbits.packages.reader;

import java.io.*;

/**
 *
 */
public class FileReader  implements IReader {

    private InputStream fileStream;
    /**
     * FileReader
     * @param filename for  formatting
     * @throws ReaderException file not found
     */

    public FileReader(final String filename) throws ReaderException {
        try {
            File file = new File(filename);
            fileStream = new FileInputStream(file);
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
            return (char) fileStream.read();
        } catch (IOException e) {
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
            if (fileStream.available() > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (IOException e) {
            throw new ReaderException(e);
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
