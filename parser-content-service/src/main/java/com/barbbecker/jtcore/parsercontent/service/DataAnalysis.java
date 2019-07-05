package com.barbbecker.jtcore.parsercontent.service;

import com.barbbecker.jtcore.parsercontent.domain.Customer;
import com.barbbecker.jtcore.parsercontent.domain.DataId;
import com.barbbecker.jtcore.parsercontent.domain.Sale;
import com.barbbecker.jtcore.parsercontent.domain.Salesman;
import com.barbbecker.jtcore.parsercontent.exception.DataTypeNotFound;

public class DataAnalysis {

    private final static String SALESMAN_ID = "01";
    private final static String CUSTOMER_ID = "02";
    private final static String SALE_ID = "03";

    public DataId verifyDatas(String[] data) {

        if (data[0].equals(SALESMAN_ID)) {
            return new Salesman.Builder(1)
                    .cpf(data[1])
                    .name(data[2])
                    .salary(Double.valueOf(data[3]))
                    .build();
        } else if (data[0].equals(CUSTOMER_ID)) {
            return new Customer.Builder(2)
                    .cnpj(data[1])
                    .name(data[2])
                    .businessArea(data[3])
                    .build();
        } else if (data[0].equals(SALE_ID)) {
            return new Sale.Builder(3)
                    .saleId(Integer.valueOf(data[1]))
                    .itens(data[2])
                    .salesmanName(data[3])
                    .build();

        }

        throw new DataTypeNotFound("Data type not found. Verify your information!");
    }
}
