import java.util.Scanner;

public class LibraryTracker{
    public static void main(String... args){
        Scanner input = new Scanner(System.in);
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        
        String welcomeMessage = """
    Welcome to PANTHERA LIBRARY
    
    ENTER - PRESS 1
    LEAVE - PRESS 0
        """;
        
        int userInput = -1;
        while(userInput != 0){
            IO.println(welcomeMessage);
            userInput = input.nextInt();
            
            switch(userInput){
                case 1:
                    String libraryMessage = """
    TO CHECK SHELF -> PRESS 1
    TO ADD BOOK -> PRESS 2
    TO TAKE BOOK -> PRESS 3
    TO SEARCH FOR BOOK -> PRESS 4
    TO EXIT -> PRESS 0
                    """;
                    int libraryChoice = -1;
                    while(libraryChoice != 0){
                        IO.println(libraryMessage);
                        libraryChoice = input.nextInt();
                        
                        switch(libraryChoice){
                            case 1:
                                String [] books = library.checkShelf();
                                for(int index = 0; index < books.length; index++){
                                    IO.println("SHELF " + ( index + 1) + " -> " + books[index]);
                                }
                                IO.println();
                                break;
                            case 2:
                                while(true){
                                    IO.println("Enter SHELF position: ");
                                    int shelfPositionChoice = input.nextInt();
                                    
                                    input.nextLine();
                                    
                                    IO.println("Enter Book Title: ");
                                    String userBookTitle = input.nextLine();
                                    
                                    if(shelfPositionChoice > 0 && shelfPositionChoice <= 30 &&  library.isShelfEmpty(shelfPositionChoice)){
                                        library.addBook(shelfPositionChoice, userBookTitle);
                                        break;
                                    }else{
                                        IO.println("Invalid Shelf position");
                                    }
                                }
                                IO.println();
                                break;
                            case 3:
                                String bookLog = """
    TO CHECK BOOKS -> PRESS 1
    TO TAKE BOOK -> PRESS 2
    TO EXIT -> PRESS 0
                                """;
                                
                                int libraryLog = -1;
                                while(libraryLog != 0){
                                    IO.println(bookLog);
                                    libraryLog = input.nextInt();
                                    
                                    switch(libraryLog){
                                        case 1: 
                                            IO.println();
                                            String [] arrangedShelf = library.displayShelf();
                                            IO.println("BOOK AVAILABLE");
                                            IO.println();
                                            for(int index = 0; index < arrangedShelf.length; index++){
                                                IO.println((index + 1) + " -> " + arrangedShelf[index]);
                                            }
                                            IO.println();
                                            break;
                                        case 2:
                                            while(true){
                                                IO.println();
                                                IO.println("Enter SHELF choice: ");
                                                int userShelfChoice = input.nextInt();
                                                
                                                if(userShelfChoice > 0 && userShelfChoice <= 30 && !library.isShelfEmpty(userShelfChoice)){
                                                    IO.println();
                                                    IO.println("Your Have Taken the Book -> " + library.takeBook(userShelfChoice));
                                                    IO.println("Have a lovely day!!!");
                                                    IO.println();
                                                    break;
                                                }else{
                                                    IO.println();
                                                    IO.println("Invalid Input");
                                                }
                                            }                                                                                    
                                            break;
                                       case 0: break;
                                    }
                                }
                                break;
                        case 4:
                            input.nextLine();
                            IO.println("Enter Book Title");
                            String userBookSelection = input.nextLine();
                            if(library.searchShelf(userBookSelection)){
                                IO.println(userBookSelection + " is avalable on SHELF -> " + library.locateBook(userBookSelection));
                                IO.println("PRESS 2 to Take Book");
                                IO.println();
                            }else{
                                IO.println(userBookSelection + " is not available in the Library");
                                IO.println("Check Books to see available books");
                                IO.println();
                            }
                            break;                                
                        }
                        
                    }
                    break;
                
                case 0: break;
                default:
                    IO.println("Invalid Input");
                    break;
            }
        }
    }
} 
