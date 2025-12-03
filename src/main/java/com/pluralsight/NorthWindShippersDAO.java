package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NorthWindShippersDAO {

    public static void insertShipper(BasicDataSource dataSource) {
        //prompts
        String name = "Billion Company";
        String phone = "123-232-1231";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shippers(CompanyName,Phone) VALUE(?,?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);

            int rows = preparedStatement.executeUpdate();
            System.out.println("inserted rows: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAllShippers(BasicDataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shippers");
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int shipperId = resultSet.getInt("shipperID");
                String name = resultSet.getString("CompanyName");
                String phone = resultSet.getString("Phone");

                System.out.println("\nShipperId: " + shipperId + "\nCompany Name: " + name + "\nPhone: " + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateShipper(BasicDataSource dataSource) {
        String newPhone = "111-111-1111";
        int shipperId = 4;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shippers SET phone = ? WHERE shipperID = ?");) {

            preparedStatement.setString(1, newPhone);
            preparedStatement.setInt(2, 4);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Updated record: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteShipper(BasicDataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shippers WHERE shipperId = ?");) {

            preparedStatement.setInt(1, 4);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Successfully Deleted row: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
