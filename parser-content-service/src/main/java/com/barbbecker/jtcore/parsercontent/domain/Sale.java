package com.barbbecker.jtcore.parsercontent.domain;

import com.barbbecker.jtcore.parsercontent.file.ParserFile;

import java.util.ArrayList;
import java.util.List;

public class Sale implements DataId {

    private int id;
    private Integer saleId;
    private List<Item> itens;
    private String salesmanName;

    private Sale() {

    }

    @Override
    public int getId() {
        return id;
    }

    public int getSaleId() {
        return saleId;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Double getPriceTotal() {
        Double total = 0.0;
        for (Item item : itens) {
            total += item.getPriceTotal();
        }
        return total;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public static class Builder {

        private int id;
        private Integer saleId;
        private List<Item> itens;
        private String salesmanName;

        public Builder(int id) {
            this.id = id;
        }

        public Builder saleId(Integer saleId) {
            this.saleId = saleId;
            return this;
        }

        public Builder itens(String itens) {
            this.itens = ParserFile.parserForItems(itens);
            return this;
        }

        public Builder salesmanName(String salesmanName) {
            this.salesmanName = salesmanName;
            return this;
        }

        public Sale build() {
            Sale sale = new Sale();
            sale.id = this.id;
            sale.salesmanName = this.salesmanName;
            sale.itens = this.itens;
            sale.saleId = this.saleId;

            return sale;
        }
    }
}
