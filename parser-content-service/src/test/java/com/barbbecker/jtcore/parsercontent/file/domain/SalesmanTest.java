package com.barbbecker.jtcore.parsercontent.file.domain;

import com.barbbecker.jtcore.parsercontent.domain.Sale;
import com.barbbecker.jtcore.parsercontent.domain.Salesman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SalesmanTest {

    private Salesman salesman;

    @Before
    @Test
    public void testCreateSalesman() {
        salesman = new Salesman.Builder(1)
                .name("Beatriz")
                .cpf("124878786633")
                .salary(2000.00)
                .build();
        assertEquals(1, salesman.getId());
        assertEquals("Beatriz", salesman.getName());
        assertEquals("124878786633", salesman.getCpf());
        assertEquals(Double.valueOf(2000.00), salesman.getSalary());
    }

    @Test
    public void testAddSaleToSalesman() {
        salesman.addSale(getSale());

        assertEquals(1, salesman.getSales().size());
    }

    @Test
    public void testCalculateSales() {
        salesman.addSale(getSale());
        salesman.addSale(getSale());

        assertEquals(Double.valueOf(2398.00), salesman.getTotalSales());
    }

    public Sale getSale() {
        return new Sale.Builder(3)
                .saleId(957)
                .itens("[1-10-100,2-30-2.50,3-40-3.10]")
                .salesmanName("Joaquina")
                .build();
    }

}
