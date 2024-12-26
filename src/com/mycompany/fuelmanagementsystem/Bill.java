package com.mycompany.fuelmanagementsystem; 

import java.util.ArrayList;
import java.util.Scanner;



public class Bill {
    
    
    static String fuellist [][] = {{"FUEL ID","FUEL NAME","Availability"},
                    {"1","Petrol Octane 92",Preference.OilStatusReceiver("Petrol Octane 92")},
                    {"2","Petrol Octane 95",Preference.OilStatusReceiver("Petrol Octane 95")},
                    {"3","Lanka Super Diesel 2",Preference.OilStatusReceiver("Lanka Super Diesel 2")},
                    {"4","Lanka Super Diesel 4",Preference.OilStatusReceiver("Lanka Super Diesel 4")}};
    
    private static final Scanner scanner = new Scanner(System.in);
    private static float total = 0;
    
    static final int[] price = {420 , 450 , 400 , 430};
    static ArrayList<String> oilTypeArray = new ArrayList<>();

    public static void main(String[] args) {
        boolean answer;

        do {
            Bill bill = new Bill();
            int type = bill.oilTypes();
            float amount = bill.getOilAmount();
            scanner.nextLine();

            float tempTotal = amount  * price[type - 1];
            total += tempTotal;
            oilTypeArray.add(fuellist[type][1]  + " × "+ amount + "    \t\t:  " + tempTotal);

            System.out.print("Do you need more oil (Y/Any) : ");
            answer = scanner.nextLine().equalsIgnoreCase("Y");
            System.out.println();

        }while (answer);

        System.out.println();
        for (String item: oilTypeArray) {
            System.out.println(item);
        }
        System.out.println("Total bill\t\t\t\t\t\t: " + total);
        System.out.println("****************************************************************************");
    }

    private int oilTypes(){
        for(String[] lines :fuellist){
           for(String val: lines){
               System.out.print(val+"\t\t");
           }
           System.out.println();

        }
        System.out.print("Select oil type : ");
        return scanner.nextInt();
    }

    private float getOilAmount(){
        System.out.print("Enter oil amount in 'L' : ");
        return scanner.nextFloat();
    }
}
