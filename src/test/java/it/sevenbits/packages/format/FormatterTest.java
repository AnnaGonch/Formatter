package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.reader.StringReader;
import it.sevenbits.packages.writer.StringWriter;
import it.sevenbits.packages.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FormatterTest {

    private Formatter formatter;
    private IReader in;
    private StringWriter out;


    @Before
    public void setUp() throws FormatException, ReaderException, WriterException {
        formatter = new Formatter();
    }

    @Test
    public void formatTest() throws ReaderException, FormatException, WriterException {
        in = new StringReader("{}");
        out = new StringWriter();
        formatter.format(in, out);
        assertEquals("{" + "\n" +"    " + "\n" + "}" + "\n", out.getString());
    }




}
