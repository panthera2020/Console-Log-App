import java.util.Scanner;

import java.util.ArrayList;

public class InventoryStockManager {
    public static void main(String... args){
        Scanner input = new Scanner(System.in);
        InventoryStockManagerFunctions manager = new InventoryStockManagerFunctions();
        
        String welcomeMessage = """
============================================
WELCOME TO PANTHER STORE 
============================================

TO DISPLAY STOCK                  -> PRESS 1
TO ADD STOCK                      -> PRESS 2
TO SELL STOCK                     -> PRESS 3
TO CHECK TOTAL ITEMS              -> PRESS 4
TO FIND HIGHEST ITEM IN STOCK     -> PRESS 5
TO CHECK STOCK BELOW AN AMOUNT    -> PRESS 6

=============================================
TO EXIT                           -> PRESS 0
=============================================

        """;
        
        int menuChoice = -1;
        while(menuChoice != 0){
            IO.println(welcomeMessage);
            String userMenuChoice = input.nextLine();
            if(userMenuChoice.length() == 1){
                menuChoice = Integer.valueOf(userMenuChoice);
                
                switch (menuChoice){
                    case 1:
                        IO.println();
                        IO.println("=================================================");
                        IO.println(String.format("%-5s %-25s %12s %10s","SHELF", "PRODUCT", "IN-STOCK", "PRICE($)"));
                        ArrayList<Object[]> itemCountPrice = manager.displayStock();
                        for(int index = 0; index < itemCountPrice.size(); index++){
                            Object[] item = itemCountPrice.get(index);
                            IO.println(String.format("%-5s %-25s %12s %10s", (index + 1),item[0], item[1], item[2]));
                        }
                        IO.println();
                        break;
                    case 2:                        
                        while(true){
                            IO.println();
                            IO.println("Which SHELF spot?");
                            String adminShelfChoice = input.nextLine();
                            IO.println("Number of stock added: ");
                            String adminStockAdded = input.nextLine();
                            if(adminShelfChoice.length() == 1 && manager.isNumberValid(adminStockAdded)){
                                manager.addToStock(Integer.valueOf(adminShelfChoice), Integer.valueOf(adminStockAdded));
                                IO.println();
                                IO.println("Do you want to add more stock? (Yes/No)");
                                String adminContinue = input.nextLine();
                                if(adminContinue.toLowerCase().equals("no")){
                                    break;
                                }
                            }else{
                                IO.println();
                                IO.println("Invalid Input");
                            }
                        }
                        break;
                    case 3:
                        while(true){
                            IO.println();
                            IO.println("Which Shelf do you want to sell from? ");
                            String adminSellChoice = nextLine();
                            IO.println("How many do you want to sell?");
                                                     
                        }
                    case 4:
                    case 5:
                    case 6:
                    
                }
            }else{
                IO.println("Invalid Input");
            }
        }
        
    }
}
