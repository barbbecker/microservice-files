package com.barbbecker.jtcore.parsercontent.domain;

public class Item {

    private int id;
    private int quantity;
    private Double price;

    private Item() {

    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double priceTotal() {
        return price * quantity;
    }

    public static class Builder {

        private int id;
        private int quantity;
        private Double price;

        public Builder(int id) {
            this.id = id;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.id = this.id;
            item.quantity = this.quantity;
            item.price = this.price;

            return item;
        }
    }
}
