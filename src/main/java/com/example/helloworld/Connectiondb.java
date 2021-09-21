package com.example.helloworld;

import java.sql.*;

public class Connectiondb {
    private static String URL = "jdbc:h2:~/tdb";
    private static String Username = "talha";
    private static String Password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, Username, Password);
            System.out.println("Connection is established");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
