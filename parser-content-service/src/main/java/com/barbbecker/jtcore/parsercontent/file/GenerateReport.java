package com.barbbecker.jtcore.parsercontent.file;

import com.barbbecker.jtcore.parsercontent.domain.Customer;
import com.barbbecker.jtcore.parsercontent.domain.Sale;
import com.barbbecker.jtcore.parsercontent.domain.Salesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateReport {

    private List<Customer> customers;
    private List<Sale> sales;
    private List<Salesman> salesmen;
    private List<String> result;

    public GenerateReport() {
        customers = new ArrayList<>();
        sales = new ArrayList<>();
        salesmen = new ArrayList<>();
    }

    public List<String> dataAnalyzed(List<String> dataObjects) {
        countCustomers();
        countSalesman();
        idMostExpensiveSale();
        worstSalesman();

        return Collections.unmodifiableList(result);
    }

    private void worstSalesman() {
        if (!sales.isEmpty()) {
            Double lowerSales = Double.MAX_VALUE;
            String worstSalesman = null;
            for (Salesman salesman : salesmen) {
                if (salesman.getTotalSales() < lowerSales) {
                    lowerSales = salesman.getTotalSales();
                    worstSalesman = salesman.getName();
                }
            }
            result.add("Worst Salesman: " + worstSalesman);
        } else {
            result.add("There are no sales");
        }
    }

    private void idMostExpensiveSale() {
        if (!sales.isEmpty()) {
            Double biggestPrice = 0.0;
            Sale moreExpensiveSale = null;
            for (Sale sale : sales) {
                if (sale.getPriceTotal() > biggestPrice) {
                    biggestPrice = sale.getPriceTotal();
                    moreExpensiveSale = sale;
                }
            }
            result.add("Id of more expensive sale: " + moreExpensiveSale.getSaleId());
        } else {
            result.add("There are no sales");
        }
    }

    private void countSalesman() {
        result.add("Quantity of Salesman: " + salesmen.size());
    }

    private void countCustomers() {
        result.add("Quantity of Customers: " + customers.size());
    }


}
