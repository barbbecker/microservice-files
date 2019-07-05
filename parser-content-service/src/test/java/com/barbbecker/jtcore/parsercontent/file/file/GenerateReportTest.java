package com.barbbecker.jtcore.parsercontent.file.file;

import com.barbbecker.jtcore.parsercontent.domain.DataId;
import com.barbbecker.jtcore.parsercontent.file.GenerateReport;
import com.barbbecker.jtcore.parsercontent.service.DataAnalysis;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class GenerateReportTest {

    private DataAnalysis dataAnalysis;
    private List<DataId> data;

    @Before
    public void createData() {
        dataAnalysis = new DataAnalysis();
        data = new ArrayList<>();

        data.add(dataAnalysis.verifyDatas(new String[]{"01", "1234567891234", "Diego", "50000"}));
        data.add(dataAnalysis.verifyDatas(new String[]{"02", "2345675434544345", "Jose da Silva", "Rural"}));
        data.add(dataAnalysis.verifyDatas(new String[]{"03", "10", "[1-10-100,2-30-2.50,3-40-3.10]", "Diego"}));
    }

    @Test
    public void testAnalyzeData() {
        GenerateReport generateReport = new GenerateReport();
        List<String> results = generateReport.dataAnalyzed(data);

        assertEquals(4, results.size());
    }

    @Test
    public void testCountCustomers() {
        GenerateReport generateReport = new GenerateReport();
        List<String> results = generateReport.dataAnalyzed(data);

        assertEquals("Quantity of Customers: 1", results.get(0));
    }

    @Test
    public void testCountSalesman() {
        GenerateReport generateReport = new GenerateReport();
        List<String> results = generateReport.dataAnalyzed(data);

        assertEquals("Quantity of Salesman: 1", results.get(1));
    }

    @Test
    public void testCheckMoreExpensiveSale() {
        GenerateReport generateReport = new GenerateReport();
        List<String> results = generateReport.dataAnalyzed(data);

        assertEquals("Id of more expensive sale: 10", results.get(2));
    }

    @Test
    public void testCheckWorstSalesman() {
        GenerateReport generateReport = new GenerateReport();
        List<String> results = generateReport.dataAnalyzed(data);

        assertEquals("Worst Salesman: Diego", results.get(3));
    }
}

