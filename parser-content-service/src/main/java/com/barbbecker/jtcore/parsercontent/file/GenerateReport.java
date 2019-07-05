package com.barbbecker.jtcore.parsercontent.file;

import com.barbbecker.jtcore.parsercontent.domain.Customer;
import com.barbbecker.jtcore.parsercontent.domain.DataId;
import com.barbbecker.jtcore.parsercontent.domain.Sale;
import com.barbbecker.jtcore.parsercontent.domain.Salesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateReport {

    private List<Customer> customers;
    private List<Sale> sales;
    private List<Salesman> salesmans;
    private List<String> result;

    public GenerateReport() {
        this.customers = new ArrayList<>();
        this.sales = new ArrayList<>();
        this.salesmans = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public List<String> dataAnalyzed(List<DataId> dataObjects) {
        createDataObjects(dataObjects);

        countCustomers();
        countSalesman();
        idMostExpensiveSale();
        worstSalesman();

        return Collections.unmodifiableList(result);
    }

    private void createDataObjects(List<DataId> dataObjects) {
        dataObjects.stream().forEach(obj -> {
            if (obj.getId() == 1) {
                salesmans.add((Salesman) obj);
            } else if (obj.getId() == 2) {
                customers.add((Customer) obj);
            } else {
                sales.add((Sale) obj);
            }
        });

        putSalesToOwner();
    }

    private void putSalesToOwner() {
        sales.forEach(sale ->
                salesmans.forEach(salesman -> {
                    if (salesman.getName().equals(sale.getSalesmanName())) salesman.addSale(sale);
                })
        );
    }

    private void worstSalesman() {
        if (!sales.isEmpty()) {
            Double lowerSales = Double.MAX_VALUE;
            String worstSalesman = null;
            for (Salesman salesman : salesmans) {
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
        result.add("Quantity of Salesman: " + salesmans.size());
    }

    private void countCustomers() {
        result.add("Quantity of Customers: " + customers.size());
    }


}
