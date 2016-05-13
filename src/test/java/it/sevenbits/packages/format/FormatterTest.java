package it.sevenbits.packages.format;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.reader.StringReader;
import it.sevenbits.packages.writer.StringWriter;
import it.sevenbits.packages.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FormatterTest {

    private Formatter formatter;
    private IReader in;
    private StringWriter out;
    private Map<Character, String> table;


    @Before
    public void setUp(){
        formatter = new Formatter();
        table = new HashMap<Character, String>();
        table.put('{', "{" + "\n" + "    ");
        table.put('}', "\n" + "    " + "}");
        table.put(';', ";" + "\n" + "    ");
        table.put('(', " " + "(");
        table.put(')', ")" + " ");
        table.put('=', " " + "=" + " ");
        table.put('+', " " + "+" + " ");
        table.put('-', " " + "-" + " ");
    }

    @Test
    public void formatTest() throws ReaderException, FormatException, WriterException {
        in = new StringReader("{};");
        out = new StringWriter();
        formatter.format(in, out, table);
        assertEquals("{" + "\n" +"    " + "\n" + "    " + "}" + ";" + "\n" + "    ", out.getString());
    }

    @Test
    public void formatArithmeticTest() throws ReaderException, FormatException, WriterException {
        in = new StringReader("sum=4+4;");
        out = new StringWriter();
        formatter.format(in, out, table);
        assertEquals("sum" + " " + "=" + " " + "4" + " " + "+"+" " + "4" + ";" + "\n"  + "    ", out.getString());
    }

}
