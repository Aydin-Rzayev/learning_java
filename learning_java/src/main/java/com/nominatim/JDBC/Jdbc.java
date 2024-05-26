package com.nominatim.JDBC;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  
public class Jdbc {
    final static String DRIVER = "org.h2.Driver";
    final static String DB_URL = "jdbc:h2:~/test";
    final static String USER = "saa";
    final static String PASS = "";

    public static void addToTable(int id, String operation,  int lat, int lon, String category) throws SQLException{
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = conn.createStatement();
            /*String sql = "CREATE TABLE INFO" + 
            "(id INTEGER not NULL, " +
            "operation VARCHAR(255), " + 
            "lat INTEGER, " +
            "lon, INTEGER, " +
            "category, VARCHAR(255) " + 
            "PRIMARY KEY(id))";*/
            //stm.executeUpdate(sql);
            String sql = "INSERT INTO INFO" + "VALUES( " + id + ", " + operation + ", " + lat + ", " + lon + ", " + category + ")";
            stm.executeUpdate(sql);
            stm.close();
            conn.close(); 
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
        
}

