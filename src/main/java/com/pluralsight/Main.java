package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");

//      NorthWindShippersDAO.insertShipper(dataSource);
    //    NorthWindShippersDAO.updateShipper(dataSource);
        NorthWindShippersDAO.deleteShipper(dataSource);
        NorthWindShippersDAO.getAllShippers(dataSource);
    }
}