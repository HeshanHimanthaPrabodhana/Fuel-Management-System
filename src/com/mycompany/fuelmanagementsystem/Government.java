package com.mycompany.fuelmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author Heshan Himantha
 */
public class Government {
    private int fuelquan;
    private double fprice;

    public static void controlprice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.customer");
        
        

       }
        public static void controlprice1(String name, String foldername){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Current Price");
        String newprice = scan.next();
        File file = new File(foldername+"/"+name+".txt");
        try {
            FileWriter fw = new FileWriter("price/"+name+".txt");
            fw.write(newprice);
            fw.close();
        } catch (IOException e) {
        }

    }

    public static void readprice() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("select the oil type");
        System.out.println("1.Petrol Octane 95");
        System.out.println("2.Petrol Octane 92");
        System.out.println("3.Lanka Super Diesel 4");
        int x = scan.nextInt();
        switch (x) {
            case 1: {
                String file = Files.readString(Path.of("price/Petrol Octane 95.txt"));
                System.out.println("Price = "+file+"/=");
                break;
            }
            case 2: {
                String file = Files.readString(Path.of("price/Petrol Octane 92.txt"+"/="));
                System.out.println("Price = "+file);
                break;
            }
            case 3: {
                String file = Files.readString(Path.of("price/Lanka Super Diesel 4.txt"+"/="));
                System.out.println("Price = "+file);
                break;
            }


            default:
                System.out.println("Invalid input!!!!");
        }
    }
}

   