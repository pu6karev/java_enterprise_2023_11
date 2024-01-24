package com.hillel.multi.persistent.service;

import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.repository.CustomerEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntityService {

    private final CustomerEntityRepository customerRepository;

    @Autowired
    public CustomerEntityService(CustomerEntityRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(Integer customerId){
        return customerRepository.getReferenceById(customerId);
    }

    @Transactional
    public CustomerEntity createCustomer(CustomerEntity customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public CustomerEntity updateCustomer(Integer customerId, CustomerEntity customerUpdated){
        var customer = customerRepository.findById(customerId).orElseThrow();
        customer.setName(customerUpdated.getName());
        customer.setEmail(customerUpdated.getEmail());
        return customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomer(Integer customerId){
        customerRepository.deleteById(customerId);
    }
}
