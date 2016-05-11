package it.sevenbits.packages.writer;

/**
 *
 */
public interface IWriter {
    /**
     * read method
     * @param str string
     *
     */
    void write(String str) throws WriterException;

    /**
     * close method
     */
    void close() throws WriterException;

    /**
     *
     */
    String get();

}
