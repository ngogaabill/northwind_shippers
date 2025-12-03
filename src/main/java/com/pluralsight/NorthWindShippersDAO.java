package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NorthWindShippersDAO {

    public static void insertShipper(BasicDataSource dataSource) {
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");

        String name = "Billion Company";
        String phone = "123-232-1231";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shippers(CompanyName,Phone) VALUE(?,?);")) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phone);

            int rows = preparedStatement.executeUpdate();
            System.out.println("inserted rows: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
