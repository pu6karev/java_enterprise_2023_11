package com.hillel.multi.persistent.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<AccountEntity> accountEntityList;

    public CustomerEntity(){}

    public CustomerEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountEntity> getAccountEntityList() {
        return accountEntityList;
    }

    public void setAccountEntityList(List<AccountEntity> accountEntityList) {
        this.accountEntityList = accountEntityList;
    }
}
