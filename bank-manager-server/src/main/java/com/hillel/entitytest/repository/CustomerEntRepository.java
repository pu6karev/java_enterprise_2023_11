package com.hillel.entitytest.repository;

import com.hillel.entitytest.CustomerEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntRepository extends JpaRepository<CustomerEnt, Integer> {
}
