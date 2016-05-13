package it.sevenbits.packages.writer;

/**
 * StringWriter class
 */
public class StringWriter implements   IWriter, IGetString {

    /**
     *
     */
    private String stringStream;
    private StringBuilder str;

    /**
     * constructor
     */
    public StringWriter() {
        str = new StringBuilder();
    }


    /**
     *
     * @param string for write
     * @throws WriterException exception
     */
    public void write(final String string) throws WriterException {
        str.append(string);
        stringStream = str.toString();
    }

    /**
     * close method
     * @throws WriterException exception
     */
    public void close() throws WriterException {
    }

    /**
     *
     */
    public String getString() {
        return stringStream;
    };
}
