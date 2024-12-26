package com.mycompany.fuelmanagementsystem;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class NewClass {
        
    static final String USERNAME = "root";
    static String PASSWORD = "";
    static Connection dbc = null;
    final static String URL = "jdbc:mysql://localhost:3306/supplydb";
    
        public static void getConnection(String sql){
        try{
        
        Statement statement = dbc.createStatement();
        ResultSet result =statement.executeQuery(sql);
       
        
            
            System.out.println("SupplyID\tSupplierName\t\tSupplierBirthday\tSupplierAddress\t\tSupplierNIC\tSupplierPhone");
        while(result.next()){
            System.out.print(result.getString("SupplyID")+"\t\t");
            System.out.print(result.getString("SupplierName")+"\t\t");
            System.out.print(result.getString("SupplierBirthday")+"\t\t");
            System.out.print(result.getString("SupplierAddress")+"\t\t");
            System.out.print(result.getString("SupplierNIC")+"\t\t");
            System.out.println(result.getString("SupplierPhone")+"\t\t");

        }
        
        }catch(Exception e){
         System.out.print(e);
        }
       supply1();
    }
        
        
        
        
    public static void main(String[] args){
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbc = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
     catch(Exception e){
        System.out.println("Somthing went error");
        }
        getConnection("select * from supdetail");
        typeOli();
        avalabe();
        
    }
    
   
  
    
    public static void supply1(){
        System.out.println("---------------------------------------------------------");
        System.out.println("1.Create Supply");
        System.out.println("2.Edit Supply");
        System.out.println("3.Delet Supply");
        System.out.println("---------------------------------------------------------");
        
        supply2();
    }
    
    public static void supply2(){
        Scanner input = new Scanner(System.in);
        System.out.print("Select : ");
        int supply = input.nextInt();
        System.out.println("---------------------------------------------------------");
        if (supply == 1){
            creatSupply();
        }
        else if(supply == 2){
            editSupply();
        }
        else if (supply == 3){
            delettSupply();
        }
        else if (supply == 4){
            Government.controlprice();
        }
        else if (supply == 5){
            try {
                Government.readprice();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("invalide pin");
        }
        
        System.out.println("---------------------------------------------------------");
    }
    
    public static void creatSupply(){
        System.out.println("---------------------------------------------------------");
        Scanner input1 = new Scanner(System.in);
        System.out.print("Supply Name : ");
        String name = input1.nextLine();
        System.out.print("Supply DOB : ");
        String dob= input1.nextLine();
        System.out.print("Supply Addres : ");
        String address= input1.nextLine();
        System.out.print("Supply NIC : ");
        String nic= input1.nextLine();
        System.out.print("Supply Telephone number : ");
        int number= input1.nextInt();
        System.out.println("---------------------------------------------------------");
        
        try{
        Statement statement = dbc.createStatement();
        statement.executeUpdate("Insert into supdetail values(default,'"+name+"',"+dob+",'"+address+"','"+nic+"',"+number+");");
        }catch(Exception e){
         System.out.println(e);
        }
        getConnection("select * from supdetail");
    }
   
    public static void editSupply(){
        System.out.println("---------------------------------------------------------");
        Scanner input2 = new Scanner(System.in);
        
        System.out.print("Select SupplyID : ");
        int row = input2.nextInt();
        System.out.println("SupplierName -1 \nSupplierBirthday -2 \nSupplierAddress -3 \nSupplierNIC -4 \nSupplierPhone -5");
 
        System.out.print("Enter Selection : ");
        int column = input2.nextInt();
        input2.nextLine();
        System.out.print("Enter new value: ");
        String newval = input2.nextLine();
    
        System.out.println("---------------------------------------------------------");
        String columnname;
        switch(column){
            case 1:
               columnname = "SupplierName";
            break;
            case 2:
               columnname = "SupplierBirthday";
            break;
            case 3:
               columnname = "SupplierAddress";
            break;
            case 4:
               columnname = "SupplierNIC";
            break;
            default:
               columnname = "SupplierPhone";
        }
        try{
        Statement statement = dbc.createStatement();
    
        statement.executeUpdate("Update supdetail set "+columnname+ " = " +(column==5 ? Integer.valueOf(newval):"\""+newval+"\"")+" where SupplyID = "+row+";");
        }catch(Exception e){
         System.out.println(e);
        }
        getConnection("select * from supdetail");
    }
    
    
    
    public static void delettSupply(){
        System.out.println("---------------------------------------------------------");
        Scanner input3 = new Scanner(System.in);
        System.out.print("what is the supply ID of the supply to be deleted : ");
        int supplyID = input3.nextInt();
        
        try{
        Statement statement = dbc.createStatement();
    
        statement.executeUpdate("Delete from supdetail where SupplyID = "+supplyID);
        }catch(Exception e){
         System.out.println(e);
        }
        getConnection("select * from supdetail");
    }
    
    public static void typeOli(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Type of Oli-------");
        String type [][] = {{"Oil001","Petrol"},
        {"Oil002","Diesel"},
        {"Oil003","Super Petrol"},
        {"Oil004","Super Petrol"},
        
        };
        for(int row = 0; row<type.length;row++){
            for(int column = 0; column < type[row].length; column ++){
                System.out.print( type[row][column] +"\t\t");
            }
            System.out.print("\n");
        }
        
        litters();
    }
    public static void litters(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Litters of Oli-------");
        String litters [][] = {{"Sup001","560000","Oil001"},
        {"Sup002","490000","Oil004"},
        {"Sup003","70000","Oil002"},
        {"Sup004","750000","Oil001"},
        {"Sup005","9000","Oil003"}
        };
        
        for(int row = 0; row<litters.length;row++){
            for(int column = 0; column < litters[row].length; column ++){
                System.out.print( litters[row][column] +"\t\t");
            }
            System.out.print("\n");
        }
        
    }
    
    public static void avalabe(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Avalable-------");
        String avalabe [][] = {{"Sup001","360000",},
        {"Sup002","400000"},
        {"Sup003","1000"},
        {"Sup004","50000"},
        {"Sup005","9000"}
        };
        
        for(int row = 0; row<avalabe.length;row++){
            for(int column = 0; column < avalabe[row].length; column ++){
                System.out.print( avalabe[row][column] +"\t\t");
            }
            System.out.print("\n");
        }
    }
}
    
    
    
    

