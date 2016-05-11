package it.sevenbits.packages.reader;

/**
 *
 */
public interface IReader  {

    /**
     *
     * @return char
     * @throws ReaderException exception
     */
    char read() throws ReaderException;


    /**
     *
     * @return char
     * @throws ReaderException exception
     */
    int hasNext() throws ReaderException;

    /**
     * close InputStream
     * @throws ReaderException exception
     */
    void close() throws ReaderException;

}
