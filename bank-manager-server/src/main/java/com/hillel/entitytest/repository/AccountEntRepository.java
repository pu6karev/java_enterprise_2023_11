package com.hillel.entitytest.repository;

import com.hillel.entitytest.AccountEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntRepository extends JpaRepository<AccountEnt, Integer> {
}
