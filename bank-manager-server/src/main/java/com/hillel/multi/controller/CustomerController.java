package com.hillel.multi.controller;

import com.hillel.api.CustomersApi;
import com.hillel.model.CustomerDTO;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.service.CustomerEntityService;
import com.hillel.multi.service.mapper.CustomerMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController implements CustomersApi {
    private final CustomerEntityService customerService;

    public CustomerController(CustomerEntityService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerService.createCustomer(customerDTO);
        CustomerDTO newCustomerDTO = CustomerMapper.INSTANCE.toDTO(customerEntity);
        return ResponseEntity.status(201).body(newCustomerDTO);
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomer(Integer customerId) {
        CustomerEntity customerEntity = customerService.getCustomerById(customerId);
        CustomerDTO customerDTO = CustomerMapper.INSTANCE.toDTO(customerEntity);
        return ResponseEntity.ok(customerDTO);
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getCustomers(String cacheControl, Integer limit) {
        List<CustomerEntity> customersEntity = customerService.getAllCustomers();
        List<CustomerDTO> customersDTO = CustomerMapper.INSTANCE.toDTOList(customersEntity);
        return ResponseEntity.ok(customersDTO);
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(Integer customerId, CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerService.updateCustomer(customerId, customerDTO);
        CustomerDTO updatedCustomerDTO = CustomerMapper.INSTANCE.toDTO(customerEntity);
        return ResponseEntity.ok(updatedCustomerDTO);
    }
}
