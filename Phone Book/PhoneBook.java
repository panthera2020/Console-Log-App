import java.util.Scanner;

public class PhoneBook {
    public static void main(String... args){
        Scanner input = new Scanner(System.in);
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        
        String phoneBookMenu = """
    TO ADD CONTACT          -> PRESS 1
    TO SEARCH for CONTACT   -> PRESS 2
    TO DELETE CONTACT       -> PRESS 3
    TO CHECK PHONEBOOK      -> PRESS 4
    TO EXIT                 -> PRESS 0
        """;
        int userPhoneMenuChoice = -1;
        while(userPhoneMenuChoice != 0){
            IO.println(phoneBookMenu);
            userPhoneMenuChoice = input.nextInt();
            IO.println();
            
            switch(userPhoneMenuChoice){
                case 1:
                    while(true){
                        input.nextLine();
                        IO.println("Enter Name: ");
                        String contactName = input.nextLine();
                        IO.println();
                        
                        IO.println("Enter Number: ");
                        String contactNumber = input.nextLine();
                        IO.println();
                        if(phoneBook.isNumberValid(contactNumber)){
                            if(phoneBook.isNameDuplicate){
                                IO.println("Name already exist");
                                IO.println("Try Another Name");
                                IO.println();
                            }
                            else{
                                phoneBook.addContact(contactName,contactNumber);
                                IO.println("Contact Saved.");
                                IO.println();
                                break;
                            }
                        }
                        else{
                            IO.println("Invalid Number");
                            IO.println();
                        }
                    }
                    IO.println();
                    break;
                case 2:
                    input.nextLine();
                    IO.println("Enter Name: ");
                    String searchName = input.nextLine();
                    
                    if(phoneBook.isNameDuplicate(searchName)){
                        String [] contactFound = phoneBook.searchContact(searchName);
                        IO.println("Contact Found");
                    
                        IO.println("--------------------------");
                        IO.println("Name -> " + contactFound[0]);
                        IO.println("Number -> " + contactFound[1]);
                        IO.println("--------------------------");
                        IO.println();
                        
                    }else{
                        IO.println("Contact Not Found.");
                        IO.println();
                    }
                    break;
                case 3:
                    if(phoneBook.isPhoneBookEmpty()){
                        IO.println("PhoneBook is Empty");
                        IO.println();
                    }else{
                        IO.println("Enter Name: ");
                        String deleteContact = input.nextLine();
                        
                        if(phoneBook.isNameDuplicate(deleteContact)){
                            IO.println("Enter Yes to Confirm \nEnter No to Cancel");
                            String deleteChoice = input.nextLine();
                            
                            if(deleteChoice.equalsIgnoreCase("Yes")){
                                phoneBook.deleteContact(deleteContact);
                                IO.println("Contact Deleted");
                                IO.println();
                            }else if(deleteChoice.equalsIgnoreCase("No")){
                                IO.print("Okay!!!");
                                IO.println();
                            }
                            else{
                                IO.println("Invalid Input");
                                IO.println();
                            }
                            
                        }
                        else{
                            IO.println("Contact Not Found");
                        }
                    }
                    break;
                case 4: 
                    if(phoneBook.isPhoneBookEmpty()){
                        IO.println("PhoneBook is Empty");
                        IO.println();
                    }
                    else{
                        String [][] contactList = phoneBook.checkContact();
                        for(int index = 0; index < contactList.length; index++){
                            IO.println("--------------------------");
                            IO.println(contactList[index][0]);
                            IO.println(contactList[index][1]);
                            IO.println("--------------------------");
                        }
                        IO.println();
                    }
                case 0: break;
                default:
                    IO.println("Invalid Input");
            }
        }
    }
}
