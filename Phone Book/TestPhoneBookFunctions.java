import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPhoneBookFunctions {
    
    @Test
    void TestThatWhenICheckPhoneBookItIsEmpty(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        
        //When
        String[][] actualPhoneBook = phoneBook.checkContact();
        
        //Check
        assertEquals(0,actualPhoneBook.length);
    }
    
    @Test
    void TestThatWhenIAddOneContactItIsAddedToPhoneBook(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        phoneBook.addContact(name,number);
        
        //When
        String[][] actualPhoneBook = phoneBook.checkContact();
        
        String[][] expectedPhoneBook = {{"Bayo Danladi", "08028878717"}};
        
        //Check
        assertArrayEquals(expectedPhoneBook,actualPhoneBook);
    }
    
    @Test
    void TestThatWhenIAddMoreThanOneContactsItIsAddedToPhoneBook(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        String nameTwo = "Segun Adimula";
        String numberTwo = "08028876543";
        
        String nameThree = "Ugo Vivian";
        String numberThree = "08023458717";
        
        
        phoneBook.addContact(name,number);
        phoneBook.addContact(nameTwo,numberTwo);
        phoneBook.addContact(nameThree,numberThree);
        
        //When
        String[][] actualPhoneBook = phoneBook.checkContact();
        
        String[][] expectedPhoneBook = {{"Bayo Danladi", "08028878717"},{"Segun Adimula","08028876543"},{"Ugo Vivian","08023458717"}};
        
        //Check
        assertArrayEquals(expectedPhoneBook,actualPhoneBook);
    }
    
    @Test
    void TestThatWhenTheNumberInputIncludesCharactersIGetFalseForIsValidNumber(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String number = "080ya726361";
        
        //When
        boolean actualAnswer = phoneBook.isNumberValid(number);
        
        boolean expectedAnswer = false;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer);
    }
    
    @Test
    void TestThatWhenIEnterADuplicateNameItReturnsTrueThatTheNameExistInThePhoneBook(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        phoneBook.addContact(name,number);
        
        //When
        boolean actualAnswer = phoneBook.isNameDuplicate(name);
        
        boolean expectedAnswer = true;
        
        //Check
        assertEquals(expectedAnswer, actualAnswer);
    }
    
    @Test
    void TestThatWhenIDeleteAContactItIsRemovedFromTheContactList(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        String nameTwo = "Segun Adimula";
        String numberTwo = "08028876543";
        
        String nameThree = "Ugo Vivian";
        String numberThree = "08023458717";
        
        
        phoneBook.addContact(name,number);
        phoneBook.addContact(nameTwo,numberTwo);
        phoneBook.addContact(nameThree,numberThree);
        
        phoneBook.deleteContact(name);
        
        //When
        String[][] actualPhoneBook = phoneBook.checkContact();
        
        String[][] expectedPhoneBook = {{"Segun Adimula","08028876543"},{"Ugo Vivian","08023458717"}};
        
        //Check
        assertArrayEquals(expectedPhoneBook,actualPhoneBook);
    }
    
    @Test
    void TestThatWhenICheckBalanceItIsArrangedInAplhabeticalOrder(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        String nameTwo = "Segun Adimula";
        String numberTwo = "08028876543";
        
        String nameThree = "Ugo Vivian";
        String numberThree = "08023458717";
        
        
        phoneBook.addContact(nameThree, numberThree);
        phoneBook.addContact(nameTwo,numberTwo);
        phoneBook.addContact(name,number);
        
        //When
        String[][] actualPhoneBook = phoneBook.checkContact();
        
        String[][] expectedPhoneBook = {{"Bayo Danladi", "08028878717"},{"Segun Adimula","08028876543"},{"Ugo Vivian","08023458717"}};
        
        //Check
        assertArrayEquals(expectedPhoneBook,actualPhoneBook);
    }
    
    @Test
    void TestThatWhenISearchForANameItReturnsTheNameAndNumber(){
        //Given
        PhoneBookFunctions phoneBook = new PhoneBookFunctions();
        String name = "Bayo Danladi";
        String number = "08028878717";
        
        String nameTwo = "Segun Adimula";
        String numberTwo = "08028876543";
        
        String nameThree = "Ugo Vivian";
        String numberThree = "08023458717";
        
        
        phoneBook.addContact(nameThree, numberThree);
        phoneBook.addContact(nameTwo,numberTwo);
        phoneBook.addContact(name,number);
        
                
        //When
        String [] actualFoundContact = phoneBook.searchContact(nameTwo);
        
        String[] expectedFoundCount = {"Segun Adimula","08028876543"};
        
        //Check
        assertArrayEquals(expectedFoundCount, actualFoundContact);
    }
}














