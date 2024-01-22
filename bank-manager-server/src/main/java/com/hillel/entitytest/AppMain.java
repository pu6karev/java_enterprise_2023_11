package com.hillel.entitytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        var context = SpringApplication.run(AppMain.class, args);
        CustomerEntService customerService = context.getBean(CustomerEntService.class);

        CustomerEnt customer1 = new CustomerEnt("Tim Burton", "burton@gmail.com");
        CustomerEnt customer2 = new CustomerEnt("Rob Snider", "snider1968@yahoo.us");

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);

        List<CustomerEnt> customers = customerService.getAllCustomers();
        for (CustomerEnt customer : customers) {
            System.out.println(customer.getName());
        }
    }
}