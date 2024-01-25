package com.hillel.multi.controller;

import com.hillel.api.CustomersApi;
import com.hillel.model.CustomerDTO;
import com.hillel.multi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController implements CustomersApi {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customer) {
        CustomerDTO newCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(201).body(newCustomer);
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomer(Integer customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getCustomers(String cacheControl, Integer limit) {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(Integer customerId, CustomerDTO customer) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}
