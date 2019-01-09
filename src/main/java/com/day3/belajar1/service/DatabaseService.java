package com.day3.belajar1.service;

import com.day3.belajar1.model.Account;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {

    private BasicDataSource dataSource;
    private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/learn-jdbc";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "";
    private static final String DATABASE_INSERT_STATEMENT = "INSERT INTO ACCOUNT(name, balance) values (?,?)";
    private static final String DATABASE_SELECT_STATEMENT = "SELECT * FROM ACCOUNT";

    public DatabaseService(){
        this.dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
    }

    public boolean saveData(Account account){
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DATABASE_INSERT_STATEMENT)){
                preparedStatement.setString(1, account.getName());
                preparedStatement.setInt(2, account.getBalance());
                return preparedStatement.executeUpdate() == 1;
            }
        } catch (SQLException e){
            System.out.println("Failed Connection");
            e.printStackTrace();
        }

        return false;
    }

    public ResultSet getAccountData(){
        try (Connection connection = dataSource.getConnection()) {
            try (ResultSet resultSet = connection.createStatement().executeQuery(DATABASE_SELECT_STATEMENT) ){
                while (resultSet.next()){
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("NAME");
                    int balance = resultSet.getInt("BALANCE");

                    System.out.println(id + " | " + name + " | " + balance);
                }
            }
        } catch (SQLException e){
            System.out.println("Failed Connection");
            e.printStackTrace();
        }

        return null;
    }
}

