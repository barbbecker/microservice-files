package com.barbbecker.jtcore.parsercontent.domain;

public class Customer {

    private int id;
    private String cnpj;
    private String name;
    private String businessArea;

    private Customer() {

    }

    public int getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public static class Builder {

        private int id;
        private String cnpj;
        private String name;
        private String businessArea;

        public Builder(int id) {
            this.id = id;
        }

        public Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder businessArea(String businessArea) {
            this.businessArea = businessArea;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.id = this.id;
            customer.name = this.name;
            customer.cnpj = this.cnpj;
            customer.businessArea = this.businessArea;

            return customer;
        }
    }
}
