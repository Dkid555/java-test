package com.hiber;

import com.hiber.entity.customers;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.close();
//        for (customers cust: new customerHelper().getCustomersList()
//             ) {
//            System.out.println("customer's name: " + cust.getName());
//            System.out.println("customer's address: " + cust.getAddress());
//            System.out.println("==============================================");
//        }
//        new customerHelper().insertHQL("John Malkovich", "69 Hippy Street");
//        new customerHelper().addCustomer("John Malkovich", "69 Hippy Street");
        ReadCsv Data = new ReadCsv();
        Data.read();
        List<customers> newOnes = new ArrayList<>();
        for (String[] line : Data.file
        ) {
            newOnes.add(new customers(line[0], line[1]));
        }
//        newOnes.add(new customers("Kagney Linn Carter","420 Jump Street"));
//        newOnes.add(new customers("Shayla Buff", "69 Horny Street"));

//        new customerHelper().addListCustomers(newOnes);


//        new customerHelper().addCustomer("Chuck", "69420 Street");
        new customerHelper().addListCustomers(newOnes);
        new customerHelper().deleteByName("Chuck");
        for (customers cust : new customerHelper().getCustomersHQL()
        ) {
            System.out.println("customer's name: " + cust.getName());
            System.out.println("customer's address: " + cust.getAddress());
            System.out.println("==============================================");
        }
    }
}
