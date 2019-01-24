package com.day3.belajar1.webmodel.account;

import com.day3.belajar1.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponse {
    Account data;
}
