package com.example.jersey.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {

    private String url = "ondora02.hu.nl";
    private String port = "8521";
    private String username = "tosad_2017_het_team1";
    private String password = "tosad_2017_het_team1";
    private String service = "cursus02.hu.nl";

    Connection connection;

    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//"+ url +":"+ port + "/" + service,username, password);
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