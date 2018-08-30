package com.example.jersey.database.repository;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
=======

import com.example.jersey.resources.ResourceFacade;
import org.json.JSONObject;

import java.lang.ref.PhantomReference;
import java.sql.*;
>>>>>>> origin/martijndev
import java.util.ArrayList;

public class DatabaseHelper_Repo {

    private String url = "ondora02.hu.nl";
    private String port = "8521";
    private String username = "tosad_2017_her_team1";
    private String password = "tosad_2017_her_team1";
    private String service = "cursus02.hu.nl";

    public Connection connection;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
=======
    public int getId(String table) throws Exception{
        int id = 0;
        connect();
        PreparedStatement statement = connection.prepareStatement("select max(id) as max from " + table);
        ResultSet s = statement.executeQuery();
        while (s.next()){
            id = s.getInt("max");
        }
        disconnect();
        return id + 1;
    }

    public void deleteRule(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("delete from businessrule where id = ?");
        statement.setInt(1, object.getInt("id"));
        statement.execute();
        disconnect();
    }

    public void saveRule(JSONObject object) throws Exception{
        PreparedStatement statement = connection.prepareStatement("update BUSINESSRULE set NAME = ?, STATUS = ? where id = ?");
        statement.setString(1, object.getString("name"));
        statement.setString(2, object.getString("status"));
        statement.setInt(3, object.getInt("id"));
        statement.execute();
    }

    public void insertRule(JSONObject object, int id, int composite_id) throws Exception{
        PreparedStatement statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS, database_id) values (?, ?, ?, ?)");
        statement.setInt(1, id);
        statement.setString(2, object.getString("name") + composite_id);
        statement.setString(3, object.getString("status"));
        statement.setInt(4, object.getInt("database_id"));
        statement.execute();
    }

    public void activate(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("update businessrule set status = ? where id = ?");
        statement.setString(1, "activated");
        statement.setInt(2, object.getInt("id"));
        statement.execute();
        disconnect();
    }

    public void deactivate(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("update businessrule set status = ? where id = ?");
        statement.setString(1, "deactivated");
        statement.setInt(2, object.getInt("id"));
        statement.execute();
        disconnect();
    }

>>>>>>> origin/martijndev
}