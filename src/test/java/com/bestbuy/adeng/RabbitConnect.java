package com.bestbuy.adeng;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class RabbitConnect {

    public static final String  POSTGRES_URL = "jdbc:postgresql://adengineering-baseline-cockroach1.omnitank.bestbuy.com:26257/clearinghouse";
    public static final int port = 5672;
    public static final Properties Property_POSTGRES = new Properties();


    public static void init(){
        Property_POSTGRES.setProperty("user","root");
        Property_POSTGRES.setProperty("password","");
        Property_POSTGRES.setProperty("ssl","false");
    }


    public static Connection connectToCockroachDb(){
        init();
        java.sql.Connection conn =null;
        try {
            conn = DriverManager.getConnection(POSTGRES_URL, Property_POSTGRES);
            System.out.println("connection "+conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return conn;
    }

    public static void printTablesClearingHouse(){
        try {
            java.sql.Connection conn = connectToCockroachDb();
            System.out.println("connection "+conn);
            tablePrint(conn,"advertiser","name");
            tablePrint(conn, "bid_accelerator","text_val");
            tablePrint(conn, "campaign","name");
        }catch(Exception sqle){
            sqle.printStackTrace();
        }
    }

   public static void tablePrint(java.sql.Connection conn, String tableName, String columnName){
      try {
            ResultSet res = conn.createStatement().executeQuery("SELECT id, "+columnName+" FROM "+tableName);
            System.out.println(res);
            while (res.next()) {
                System.out.println(res.getDouble("id") + "   " + res.getString(columnName) + "   ");
            }
       }catch(SQLException sqle){
          sqle.printStackTrace();
      }
    }

    public static void main(String args[]) throws Exception{
        printTablesClearingHouse();

    }

}
