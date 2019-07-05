package com.barbbecker.jtcore.parsercontent.file.service;

import com.barbbecker.jtcore.parsercontent.domain.DataId;
import com.barbbecker.jtcore.parsercontent.exception.DataTypeNotFound;
import com.barbbecker.jtcore.parsercontent.service.DataAnalysis;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DataAnalysisTest {

    private DataAnalysis dataAnalysis;

    @Before
    @Test
    public void testCreateDataAnalysis() {
        dataAnalysis = new DataAnalysis();

        assertNotNull(dataAnalysis);
    }

    @Test(expected = DataTypeNotFound.class)
    public void testCreateDataAnalysisInvalid() throws DataTypeNotFound {
        String[] data = {"04", "10", "[1-10-100,2-30-2.50,3-40-3.10]", "Sabrina"};
        DataId sale = dataAnalysis.verifyDatas(data);
    }
}
