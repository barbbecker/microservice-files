package com.barbbecker.jtcore.parsercontent.domain;

import java.util.ArrayList;
import java.util.List;

public class Salesman {

    private int id;
    private String cpf;
    private String name;
    private Double salary;
    private List<Sale> sales;

    private Salesman() {
        sales = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public Double getTotalSales() {
        Double total = 0.0;
        for (Sale sale : sales) {
            total += sale.getPriceTotal();
        }
        return total;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public static class Builder {

        private int id;
        private String cpf;
        private String name;
        private Double salary;

        public Builder(int id) {
            this.id = id;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Salesman build() {
            Salesman salesman = new Salesman();
            salesman.id = this.id;
            salesman.name = this.name;
            salesman.cpf = this.cpf;
            salesman.salary = this.salary;

            return salesman;
        }
    }
}
