package com.barbbecker.jtcore.parsercontent.file.domain;

import com.barbbecker.jtcore.parsercontent.domain.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testCreateItems() {
        Item item = new Item.Builder(11)
                .quantity(6)
                .price(12.60)
                .build();

        assertEquals(11, item.getId());
        assertEquals(6, item.getQuantity());
        assertEquals(Double.valueOf(12.60), item.getPrice());
        assertEquals(Double.valueOf(75.60), item.getPriceTotal());
    }
}
