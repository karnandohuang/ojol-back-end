package com.day3.belajar1.controller;

import com.day3.belajar1.model.Account;
import com.day3.belajar1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAccountList(){

        List<Account> accountList = null;
        try {
            accountList = accountService.getAccountList();
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account insertAccount(@RequestBody Account request){
        Account account = new Account();
        account.setName(request.getName());
        account.setBalance(request.getBalance());

        try {
            if(accountService.saveAccount(account)!=null)
                return account;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account findAccount(@PathVariable("id") int id){

        try {
            Account account = accountService.getAccount(id);
            if(account!=null)
                return account;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
