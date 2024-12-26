
package com.mycompany.fuelmanagementsystem;

//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.Scanner;
//import java.io.PrintWriter; 
import java.io.IOException;
import java.io.File;
//import java.io.FileWriter;

public class FuelBunkOwner {
    
    public static void ViewFuelList(){
            
          
        try{
            File file1 = new File("fuellist.txt");
            Scanner readfile = new Scanner(file1);
            while(readfile.hasNextLine()){
            String data = readfile.nextLine();
            System.out.println(data);
            }
            readfile.close();
         }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
         }
         System.out.println("---------------------------------------------------------");
       
      } 

    
       public static void UpdateFuelList(){
          
                System.out.println("\t\t---------FUEL LIST & PRICE LIST---------\t\t");
               
                String fuellist [][] = {{"FUEL ID","FUEL NAME","Availability"},
                    {"F001","Petrol Octane 92",Preference.OilStatusReceiver("Petrol Octane 92")},
                    {"F002","Petrol Octane 95",Preference.OilStatusReceiver("Petrol Octane 95")},
                    {"F003","Lanka Super Diesel 2",Preference.OilStatusReceiver("Lanka Super Diesel 2")},
                    {"F004","Lanka Super Diesel 4",Preference.OilStatusReceiver("Lanka Super Diesel 4")}}; 
                printArray(fuellist);
                int x=0;
                String content;
                Scanner s = new Scanner(System.in);
                System.out.print("Please enter the row need to modify[enter 1,2,3,...]: ");
                x = s.nextInt();
               
                System.out.print("Enter the update availability detail: ");
                content = s.next();
                
                Preference.oilStatusStore(fuellist[x][1], content);
                fuellist[x][2]=content;
                printArray(fuellist);
               
       
           }
           private static void printArray(String[][] fuellist){
                 for(int row = 0; row<fuellist.length;row++){
                 for(int column = 0; column < fuellist[row].length; column ++){
                     System.out.print( fuellist[row][column] +"\t\t");
             }
             System.out.print("\n");
        }
             
        System.out.println("---------------------------------------------------------");
    }

        

      
    public static void main(String args[]){
       
        System.out.println("\t\t\t\t\t\t\t--------------WELCOME RUTHERFORD FUEL STATION---------------\t\t\t");
        System.out.println("\n\nselect :=>\n");
        System.out.print("\t\t<1>View Fuel List & Price\t\t");
        System.out.print("\t\t<2>Update Fuel List & Price\t\t");
        System.out.print("\t\t<3>Delete Fuel List & Price\t\t\n");
        System.out.print("\t\t<4>Create Avaialbility List\t\t");
        System.out.print("\t\t<5>Create Customer Registration List\t\t");
        System.out.print("\t<6>Update Customer Registration List\t\t\n");
        System.out.print("\t\t<7>Delete Customer Registration List\t\t");
        System.out.print("\t<8>View Developer Info\t\t");
        System.out.print("\t\t\t<9>Exit\n");
       
        int ans1;
        Scanner s = new Scanner(System.in);
        System.out.print("\nAnswer : ");
        ans1 = s.nextInt();
        switch(ans1){
            case 1:
                ViewFuelList();
            break;
            case 2:
               
                UpdateFuelList();
            try{
                File file1 = new File("fuellist.txt");
                boolean f = file1.createNewFile();
                if(f){
                    System.out.println("File created");
                }
                else{
                    System.out.println("File already present");
                }
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            break;
            case 3:
                //DeleteFuleList();
            break;
            case 4:
               // AvailibiltyList();
            break;
            case 5:
                //CreateCustomerReg();
            break;
            case 6:
               // UpdateCustomerReg();
            break;
            case 7:
                //DeleteCustomerReg();
            break;
            case 8:
                //DeveloperInfo();
            break;
            case 9:
                //Exit();
            break;
            default:
                
        }
      //FuelList();
}
    
}

