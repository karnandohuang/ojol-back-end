package com.day3.belajar1;

import com.day3.belajar1.model.Account;
import com.day3.belajar1.service.DatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Belajar1Application {

	public static void main(String[] args) {
        SpringApplication.run(Belajar1Application.class, args);


//        Account account = new Account();
//        account.setName("Karnando");
//        account.setBalance(0);
//        DatabaseService databaseService = new DatabaseService();
//        if(!databaseService.saveData(account))
//            System.out.println("Failed");
//
//        databaseService.getAccountData();
    }

}

