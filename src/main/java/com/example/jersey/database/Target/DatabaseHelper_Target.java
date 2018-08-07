package com.example.jersey.database.Target;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper_Target {

    private String url = "ondora02.hu.nl";
    private String port = "8521";
    private String username = "tosad_2017_her_team1_target";
    private String password = "tosad_2017_her_team1_target";
    private String service = "cursus02.hu.nl";

    Connection connection;

    public void connect() {
        try {
            System.out.println("connecting to " + url + " with username " + username);
            System.out.println(url);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//"+ url +":"+ port + "/" + service,username, password);
            System.out.println("connection successful");
        } catch (Exception e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }

    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}