package com.hillel.multi.persistent.repository;

import com.hillel.multi.persistent.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Integer> {
}
