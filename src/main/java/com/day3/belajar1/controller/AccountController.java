package com.day3.belajar1.controller;

import com.day3.belajar1.model.Account;
import com.day3.belajar1.repository.AccountRepository;
import com.day3.belajar1.service.AccountService;
import com.day3.belajar1.webmodel.BaseResponse;
import com.day3.belajar1.webmodel.account.AccountListResponse;
import com.day3.belajar1.webmodel.account.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccountList(){
        List<Account> accountList = null;

        try {
            accountList = accountService.getAccountList();

            AccountListResponse accountListResponse = new AccountListResponse(accountList);
            BaseResponse<AccountListResponse> response = new BaseResponse<>("OK", "200", accountListResponse, "");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<AccountListResponse> response = new BaseResponse<>("Fail", "404", null, "");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertAccount(@RequestBody Account request){
        Account account = new Account();
        account.setName(request.getName());
        account.setBalance(request.getBalance());

        try {
            if(accountService.saveAccount(account)!=null) {

                AccountResponse accountResponse = new AccountResponse(null);
                BaseResponse<AccountResponse> response = new BaseResponse<>("OK", "200", accountResponse, "");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

            BaseResponse<AccountResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);


        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<AccountResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAccount(@PathVariable("id") int id){

        try {
            Account account = accountService.getAccount(id);

            if(account!=null){
                AccountResponse accountResponse = new AccountResponse(account);
                BaseResponse<AccountResponse> response = new BaseResponse<>("OK", "200", accountResponse, "");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<AccountResponse> response = new BaseResponse<>("OK", "200", null, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return null;
    }



}
