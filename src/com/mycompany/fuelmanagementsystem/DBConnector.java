
package com.mycompany.fuelmanagementsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBConnector  {
    
   
    static final String USERNAME = "root";
    static String PASSWORD = "";
    final static String URL = "jdbc:mysql://localhost:3306/supplydb";
    
        public static void getConnection()
            
        {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbc = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = dbc.createStatement();
        
        String sql = "select * from supdetail";
        ResultSet result =statement.executeQuery(sql);
        
        while(result.next()){
            System.out.print(result.getString("SupplyID")+"\t");
            System.out.print(result.getString("SupplierName")+"\t");
            System.out.print(result.getString("SupplierBirthday")+"\t");
            System.out.print(result.getString("SupplierAddress")+"\t");
            System.out.print(result.getString("SupplierNIC")+"\t");
            System.out.println(result.getString("SupplierPhone")+"\t");

        }
        
        }catch(Exception e){
         System.out.print(e);
        }
       
    }
}






