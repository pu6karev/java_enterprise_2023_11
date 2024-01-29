package com.hillel.multi.service;

import com.hillel.model.CustomerDTO;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.repository.CustomerEntityRepository;
import com.hillel.multi.service.mapper.CustomerMapper;
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
    public CustomerEntity createCustomer(CustomerDTO customerDTO){
        CustomerEntity customerEntity = CustomerMapper.INSTANCE.toEntity(customerDTO);
        return customerRepository.save(customerEntity);
    }

    @Transactional
    public CustomerEntity updateCustomer(Integer customerId, CustomerDTO customerDTOUpdated){
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();

        customerEntity.setName(customerDTOUpdated.getName());
        customerEntity.setEmail(customerDTOUpdated.getEmail());

        return customerRepository.save(customerEntity);
    }

    @Transactional
    public void deleteCustomer(Integer customerId){
        customerRepository.deleteById(customerId);
    }
}
