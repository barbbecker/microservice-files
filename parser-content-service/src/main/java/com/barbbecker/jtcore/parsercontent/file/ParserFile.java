package com.barbbecker.jtcore.parsercontent.file;

import com.barbbecker.jtcore.parsercontent.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ParserFile {

    public static List<Item> parserForItems(String itemReceived) {
        List<Item> items = new ArrayList<>();

        itemReceived = itemReceived.substring(1, itemReceived.length() - 2);
        String[] delimiter = itemReceived.split(",");

        for (String itemString : delimiter) {
            String[] separator = itemString.split("-");
            Item item = new Item.Builder(Integer.valueOf(separator[0]))
                    .quantity(Integer.valueOf(separator[1]))
                    .price(Double.valueOf(separator[2]))
                    .build();
            items.add(item);
        }

        return items;
    }

    public static List<String[]> parserForDatas(String dataReceived) {
        List<String[]> formatData = new ArrayList<>();

        String[] dataForDelimiter = dataReceived.split(" 0");
        for (String data : dataForDelimiter) {
            if (!data.trim().isEmpty()) {
                String[] dataForModified = data.trim().split("ç");
                formatData.add(dataForModified);
            }
        }
        return formatData;
    }
}
