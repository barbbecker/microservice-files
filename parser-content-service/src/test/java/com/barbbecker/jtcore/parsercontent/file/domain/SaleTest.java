package com.barbbecker.jtcore.parsercontent.file.domain;

import com.barbbecker.jtcore.parsercontent.domain.Sale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaleTest {

    @Test
    public void testCreateSale() {
        Sale sale = new Sale.Builder(3)
                .saleId(45)
                .itens("[1-10-100,2-30-2.50,3-40-3.10]")
                .salesmanName("Carina")
                .build();

        assertEquals(3, sale.getId());
        assertEquals(45, sale.getSaleId());
        assertEquals(3, sale.getItens().size());
        assertEquals("Carina", sale.getSalesmanName());
        assertEquals(Double.valueOf(1199.00), sale.getPriceTotal());
    }
}
