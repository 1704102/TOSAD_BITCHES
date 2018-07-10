package com.example.jersey.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {

    private final String USERNAME = "tosaduser2";
    private final String PASSWORD = "catonmylaptop";

    Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe",  USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        }catch (Exception e){
            return null;
        }

    }
}