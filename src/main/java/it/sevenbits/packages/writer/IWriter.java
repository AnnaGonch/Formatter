package it.sevenbits.packages.writer;

/**
 *
 */
public interface IWriter {
    /**
     * read method
     * @param str string
     * @throws WriterException exception
     */
    void write(String str) throws WriterException;

    /**
     * close method
     * @throws WriterException exception
     */
    void close() throws WriterException;



}
