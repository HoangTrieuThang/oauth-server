package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    static Connection connection;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc.mysql://35.247.152.191:3306/user_validation",
                    "self_growth_user","QuocAnhCanh");

        }catch (Exception ex) {
            System.out.println("This is my connection" +ex);
        }
        return connection;
    }
}
