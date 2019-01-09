package com.day3.belajar1.service;

import com.day3.belajar1.model.Account;
import com.day3.belajar1.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger("abc");

    @Autowired
    AccountRepository accountRepository;

    public AccountService() {
        LOGGER.warn("account service");
    }

    public List<Account> getAccountList() throws Exception {
        LOGGER.warn("Bebas apapun yang kalian mau");

        List<Account> accountList = accountRepository.findAll();

        return accountList;
    }

    public Account saveAccount(Account account) throws Exception{

        return accountRepository.save(account);
    }

    public Account getAccount(int id) throws Exception{
        return accountRepository.findAccountById(id);
    }

}
