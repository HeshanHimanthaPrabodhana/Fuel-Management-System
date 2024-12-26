
package com.mycompany.fuelmanagementsystem;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class FuelManagementSystem {
    private static final String FuelBunkOwnerLogin="owner123";
    private static final String FuelSupplierLogin ="fuel123";
    private static final String GovernmentLogin="gov123";
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Fuel Bunk Owner Login - 1 \nFuel Supplier Login - 2 \nGovernment Login - 3 \nCustomer Login - 4");
        System.out.print("Enter selection : ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        
        switch(selection){
            case 1 -> {
                do{
                    System.out.print("Enter password : ");
                    String password = scanner.nextLine();
                    if(password.equals(FuelBunkOwnerLogin)){
                         FuelBunkOwner.main(args);
                         break;
                    }else{
                        System.out.println("Incorrect password. try again\n");
                    }
                }while(true); 
            }
            
            case 2 -> {
                do{
                    System.out.print("Enter password : ");
                    String password = scanner.nextLine();
                    if(password.equals(FuelSupplierLogin)){
                         NewClass.main(args);
                         break;
                    }else{
                        System.out.println("Incorrect password. try again\n");
                    }
                }while(true);
               
            }
             
            case 3 -> {
                do{
                    System.out.print("Enter password : ");
                    String password = scanner.nextLine();
                    if(password.equals(GovernmentLogin)){
                        try {
                            Government.readprice();
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(FuelManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        System.out.println("Incorrect password. try again\n");
                    }
                }while(true); 
            }
            
            default -> {
                    System.out.println("Login - 1 \nRegister - 2");
                    System.out.print("Enter your selection : ");
                    int method = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(method == 1){
                         boolean looping = false;
                         do{
                                System.out.print("Enter username : ");
                                String user = scanner.nextLine();

                                System.out.print("Enter password : ");
                                String password = scanner.nextLine();

                                if(Preference.userDataReceiver(user).equals(password)){
                                      Bill.main(args);
                                      looping = false;
                                }else{
                                      System.out.println("Incorrecr username and password combination. please try again");
                                      looping = true;
                                }     
                           }while(looping);
                           
                    }else{
                          System.out.print("Enter username : ");
                          String user = scanner.nextLine();
                            
                          System.out.print("Enter password : ");
                          String password = scanner.nextLine();
                            
                           Preference.userDtataStore(user , password);
                           Bill.main(args);
                    }
            }
        }
    }
}
