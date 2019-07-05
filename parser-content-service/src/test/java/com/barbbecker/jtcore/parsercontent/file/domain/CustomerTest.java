package com.barbbecker.jtcore.parsercontent.file.domain;

import com.barbbecker.jtcore.parsercontent.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer.Builder(2)
                .name("Francisco")
                .cnpj("5454121254787")
                .businessArea("Rural")
                .build();

        assertEquals(2, customer.getId());
        assertEquals("Francisco", customer.getName());
        assertEquals("5454121254787", customer.getCnpj());
        assertEquals("Rural", customer.getBusinessArea());
    }
}
