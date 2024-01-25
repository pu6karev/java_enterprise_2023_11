package com.hillel.multi.service;

import com.hillel.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public List<CustomerDTO> getAllCustomers(){
        return null;
    }

    public CustomerDTO getCustomerById(Integer customerId){
        return null;
    }

    public CustomerDTO createCustomer(CustomerDTO customer){
        return null;
    }

    public CustomerDTO updateCustomer(Integer customerId, CustomerDTO customer){
        return null;
    }

    public boolean deleteCustomer(Integer customerId){
        return false;
    }
}
