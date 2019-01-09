package com.day3.belajar1.repository;

import com.day3.belajar1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByName(String name);
    Account findAccountById(int id);
}
