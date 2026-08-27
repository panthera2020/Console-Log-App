import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLibraryTrackerFunctions {

    @Test
    void TestThatWhenICheckShelfItShowsWhatIsInTheLibrary(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //When
        String [] actualLibraryReport = library.checkShelf();
        
        String [] expectedLibraryReport = {"No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        //Check
        assertArrayEquals(expectedLibraryReport,actualLibraryReport);
    }
    
    @Test
    void TestThatWhenIAddABookToAParticluarSlotItAddsToTheShelf(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        String bookTitle = "Harry Potter";
        
        library.addBook(shelfPosition, bookTitle);
        
        //When
        String [] actualLibraryReport = library.checkShelf();
        
        String [] expectedLibraryReport = {"Harry Potter","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        //Check
        assertArrayEquals(expectedLibraryReport,actualLibraryReport);
    }
    
    @Test
    void TestThatWhenIAddABookAndTheSlotIsFilledAnotherBookCannotBeAddedToSameShelfPosition(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        String bookTitleOne = "Harry Potter";
        String bookTitleTwo = "Black Panther";
        
        library.addBook(shelfPosition, bookTitleOne);
        library.addBook(shelfPosition, bookTitleTwo);
        
        //When
        String [] actualLibraryReport = library.checkShelf();
        
        String [] expectedLibraryReport = {"Harry Potter","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        //Check
        assertArrayEquals(expectedLibraryReport,actualLibraryReport);
    }
    
    @Test
    void TestThatWhenITakeABookWhenAfterIJustPutABookIGetBook(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        String bookTitle = "Harry Potter";
        
        library.addBook(shelfPosition, bookTitle);
        
        //When                                
        String actualTakenBook = library.takeBook(shelfPosition);
        String expectedTakenBook = "Harry Potter";
                                
        //Check
        assertEquals(expectedTakenBook, actualTakenBook);
    }
    
    @Test
    void TestThatWhenITakeBookShelfBecomesEmpty(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        String bookTitle = "Harry Potter";
        
        library.addBook(shelfPosition, bookTitle);
        library.takeBook(shelfPosition);
        
        //When
        String [] actualLibraryReport = library.checkShelf();
        
        String [] expectedLibraryReport = {"No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        //Check
        assertArrayEquals(expectedLibraryReport,actualLibraryReport);
        
    }
    
    @Test
    void TestThatWhenITryToTakeFromAnEmptyShelfIGetNothing(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        //When                                
        String actualTakenBook = library.takeBook(shelfPosition);
        String expectedTakenBook = "";
                                
        //Check
        assertEquals(expectedTakenBook, actualTakenBook);
    }
    
    @Test
    void TestThatIfIfShelfIsEmptyItReturnsTrue(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        
        //When
        boolean actualAnswer = library.isShelfEmpty(shelfPosition);
        
        boolean expectedAnswer = true;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer); 
    }
    
    @Test
    void TestThatIfIfIAddABookAndICheckIfShelfIsEmptyItReturnsFalse(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPosition = 1;
        String bookTitle = "Harry Potter";
        
        library.addBook(shelfPosition, bookTitle);
        
        //When
        boolean actualAnswer = library.isShelfEmpty(shelfPosition);
        
        boolean expectedAnswer = false;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer); 
    }
    
    @Test
    void TestThatWHenIEnterVariousBooksAndICheckShelfItIsDisplayedInAlphabeticalOrder(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPositionOne = 1;
        int shelfPositionTwo = 2;
        int shelfPositionThree = 5;
        int shelfPositionFour = 8;
        int shelfPositionFive = 15;
        
        String bookOne = "Legend of The Seeker";
        String bookTwo = "Avatar";
        String bookThree = "Black Panther";
        String bookFour = "Dare Devil";
        String bookFive = "Fast and Furious";
        
        library.addBook(shelfPositionOne, bookOne);
        library.addBook(shelfPositionTwo, bookTwo);
        library.addBook(shelfPositionThree, bookThree);
        library.addBook(shelfPositionFour, bookFour);
        library.addBook(shelfPositionFive, bookFive);
        
        //when
        String [] actualLibraryReport = library.displayShelf();
        
        String [] expectedLibraryReport = {"Avatar","Black Panther","Dare Devil","Fast and Furious","Legend of The Seeker","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        //Check
        assertArrayEquals(expectedLibraryReport,actualLibraryReport);
    }
    
    @Test
    void TestThatWhenISearchForABookItReturnsTrueIfTheBookIsOnTheShelf(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPositionOne = 1;
        int shelfPositionTwo = 2;
        int shelfPositionThree = 5;
        int shelfPositionFour = 8;
        int shelfPositionFive = 15;
        
        String bookOne = "Legend of The Seeker";
        String bookTwo = "Avatar";
        String bookThree = "Black Panther";
        String bookFour = "Dare Devil";
        String bookFive = "Fast and Furious";
        
        library.addBook(shelfPositionOne, bookOne);
        library.addBook(shelfPositionTwo, bookTwo);
        library.addBook(shelfPositionThree, bookThree);
        library.addBook(shelfPositionFour, bookFour);
        library.addBook(shelfPositionFive, bookFive);
        
        //When
        boolean actualAnswer = library.searchShelf(bookTwo);
        
        boolean expectedAnswer = true;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer);
    }
    
    @Test
    void TestThatWhenICheckForABookAndItIsOnTheShelfItReturnsShelfLocation(){
        LibraryTrackerFunctions library = new LibraryTrackerFunctions();
        //Given
        int shelfPositionOne = 1;
        int shelfPositionTwo = 2;
        int shelfPositionThree = 5;
        int shelfPositionFour = 8;
        int shelfPositionFive = 15;
        
        String bookOne = "Legend of The Seeker";
        String bookTwo = "Avatar";
        String bookThree = "Black Panther";
        String bookFour = "Dare Devil";
        String bookFive = "Fast and Furious";
        
        library.addBook(shelfPositionOne, bookOne);
        library.addBook(shelfPositionTwo, bookTwo);
        library.addBook(shelfPositionThree, bookThree);
        library.addBook(shelfPositionFour, bookFour);
        library.addBook(shelfPositionFive, bookFive);
        
        //When
        int actualBooklocation = library.locateBook(bookTwo);
        
        int expectedBookLocation = 2;
        
        //Check
        assertEquals(expectedBookLocation, actualBooklocation);
    }
}


























