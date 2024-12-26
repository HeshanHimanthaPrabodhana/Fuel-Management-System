
package com.mycompany.fuelmanagementsystem;


public class Fulllistprice {
    
      public static void FuelList(){
           String fuelName [][] = {{"Oil001","Petrol Octane 92","420.00"},{"Oil002","Petrol Octane 95","450.00"},{"Oil003","Petrol Octane 95","450.00"},{"Oil004","Lanka Super Diesel 4","445.00"}};
             for (int row=0; row<fuelName.length; row++){
                for (int column = 0; column< fuelName[row].length;column++){
                    System.out.println(fuelName[row][column] + "\t\t");
         }   
             System.out.print("\n");
        }
               System.out.print("-----------------------------------");
    }
}
