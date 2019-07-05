package com.barbbecker.jtcore.parsercontent.file;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormattedFilesTest {

    @Test
    public void testFormatStringWithÇ() {
        String file =
                " 001ç1234567891234çDiegoç50000 \n" +
                        " 001ç3245678865434çRenatoç40000.99 \n" +
                        " 002ç2345675434544345çJose da SilvaçRural \n" +
                        " 002ç2345675433444345çEduardoPereiraçRural \n" +
                        " 003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego \n" +
                        " 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato ";


        List<String[]> formattedData = ParserFile.parserForDatas(file);
        String[] firstData = formattedData.get(0);

        assertEquals(4, firstData.length);
        assertEquals("01", firstData[0]);
        assertEquals("1234567891234", firstData[1]);
        assertEquals("Diego", firstData[2]);
        assertEquals("50000", firstData[3]);
    }

}