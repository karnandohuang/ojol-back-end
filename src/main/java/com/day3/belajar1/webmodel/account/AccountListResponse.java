package com.day3.belajar1.webmodel.account;

import com.day3.belajar1.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountListResponse {

    List<Account> data;
}
