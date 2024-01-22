package com.hillel.entitytest;

import com.hillel.entitytest.repository.CustomerEntRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntService {

    private final CustomerEntRepository customerRepository;

    @Autowired
    public CustomerEntService(CustomerEntRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEnt> getAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerEnt getCustomerById(Integer customerId){
        return customerRepository.getReferenceById(customerId);
    }

    @Transactional
    public CustomerEnt createCustomer(CustomerEnt customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(Integer customerId, CustomerEnt customerUpdated){
        CustomerEnt customer = customerRepository.findById(customerId).orElseThrow();
        customer.setName(customerUpdated.getName());
        customer.setEmail(customerUpdated.getEmail());
        customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomer(Integer customerId){
        customerRepository.deleteById(customerId);
    }
}
