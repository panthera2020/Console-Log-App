import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TestInventoryStockManagerFunctions{
    private InventoryStockManagerFunctions manager;
    
    @BeforeEach
    public void createObject(){
        manager = new InventoryStockManagerFunctions();
    }
    
    @Test
    public void testThatWhenICheckStockItReturnsTheNumberOfProductsInStock(){
        int [] actualInstock = manager.checkStock();
        int [] expectedInStock = new int[25];
        
        assertArrayEquals(expectedInStock,actualInstock);
    }
    
    @Test
    public void testThatWhenIAddToAnyStockItIncreaseByAmountYouAddToStock(){
        int productLocation = 1;
        int stockAdded = 20;
        
        manager.addToStock(productLocation,stockAdded);
        
        int [] actualInstock = manager.checkStock();
        int [] expectedInStock = {20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        assertArrayEquals(expectedInStock,actualInstock);
    }
    
    @Test
    public void testThatWhenIAddAnegativeToAnyStockItDoesNotAddToStock(){
        int productLocation = 1;
        int stockAdded = -1;
        
        manager.addToStock(productLocation,stockAdded);
        
        int [] actualInstock = manager.checkStock();
        int [] expectedInStock = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        assertArrayEquals(expectedInStock,actualInstock);
    }
    
    @Test
    void testThatWHenISellAProductItReducesByTheNumberOfProductBought(){
        int productLocation = 1;
        int stockAdded = 20;
        int numberOfProducts = 2;
        
        manager.addToStock(productLocation,stockAdded);
        manager.sellProduct(productLocation, numberOfProducts);
        
        int [] actualInstock = manager.checkStock();
        int [] expectedInStock = {18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        assertArrayEquals(expectedInStock,actualInstock);
    }
    
    @Test
    void testThatWhenITryToSellAndStockIsAtZeroOrLessThanAmountOfProductsToBeBoughtStockDoesNotChange(){
        int productLocation = 1;
        int numberOfProducts = 2;
        
        manager.sellProduct(productLocation,numberOfProducts);
        
        int [] actualInstock = manager.checkStock();
        int [] expectedInStock = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        assertArrayEquals(expectedInStock,actualInstock);
    }
    
    @Test
    void testThatWhenICheckStockAndStockIsEmptyItReturnsTrue(){
        int productIndex = 1;
        
        boolean actualAnswer = manager.isStockEmpty(productIndex);
        boolean expectedAnswer = true;
        
        assertEquals(expectedAnswer,actualAnswer);
    }
    
    @Test
    void testThatWhenICheckForProductsIGetTheProductsAndItStock(){
        int [] stock = {50,35,45,40,60,33,10,12,5};
        
        for(int index = 0; index < stock.length; index++){
            manager.addToStock(index + 1, stock[index]);
        }        
        
        ArrayList<Object[]> actualStockReport = manager.displayStock();
        Object[][] expectedStockReport = {
            {"Ballpoint Pens", 50},{"Note Books", 35},{"Sticky Notes", 45},{"Staplers", 40},{"Desk Chair", 60},
            {"LED Desk Lamp", 33},{"USB-C Cable", 10},{"Wireless Mouse", 12},{"Mechanical Keyboard", 5},
            {"27-inch Monitor", 0},{"Cofee Beans(1kg)", 0},{"Paper Towel", 0},{"Face Wipes", 0},{"Scissors", 0},
            {"Hand Sanitizer(500ml)", 0},{"Whiteboard Marker set", 0},{"Paper Clip", 0},{"HDMI Cable(2m)", 0},
            {"Bottle Water(50cl)", 0},{"Face Cap", 0},{"Bread", 0},{"Baby Oil(150ml)", 0},{"Laptop Stand", 0},
            {"Bluetooth Headphones", 0},{"Printer Paper (A4)", 0}
        };

        
        for(int index = 0; index < expectedStockReport.length; index++){
            assertArrayEquals(expectedStockReport[index], actualStockReport.get(index));
        }
    }
    
    @Test
    void testThatWhenIWantToCheckStockWithTheHighestCountIGetTheItemWithTheHighestStockCount(){
        int [] stock = {50,35,45,40,60,33,10,12,5};
        
        for(int index = 0; index < stock.length; index++){
            manager.addToStock(index + 1, stock[index]);
        }
        
        String actualItem = manager.getHighestItem();
        String expectedItem = "Desk Chair";
        
        assertEquals(expectedItem,actualItem);
    }
    
    @Test
    void testThatWhenIAskForTotalStockIgetTheTotalNumberOfItemsAcrossAllProducts(){
        int [] stock = {50,35,45,40,60,33,10,12,5};
        
        for(int index = 0; index < stock.length; index++){
            manager.addToStock(index + 1, stock[index]);
        }
        
        int actualTotalStock = manager.getTotalStock();
        int expectedTotalStock = 290;
        
        assertEquals(expectedTotalStock, actualTotalStock);
    }
    
    @Test
    void testThatWhenIWantItemsBelowAParticluarAmountIGetAListOfItemsBelowThatNumber(){
        int [] stock = {50,35,45,40,60,33,10,12,5};
        
        for(int index = 0; index < stock.length; index++){
            manager.addToStock(index + 1, stock[index]);
        }
        
        int minimumAmount = 40;
        
        Object [] actualItemsBelow = manager.getItemsBelow(minimumAmount);
        Object [] expectedItemsBelow = {
                "Note Books","LED Desk Lamp","USB-C Cable","Wireless Mouse","Mechanical Keyboard",
                "27-inch Monitor","Cofee Beans(1kg)","Paper Towel","Face Wipes","Scissors",
                "Hand Sanitizer(500ml)","Whiteboard Marker set","Paper Clip","HDMI Cable(2m)",
                "Bottle Water(50cl)","Face Cap","Bread","Baby Oil(150ml)","Laptop Stand", 
                "Bluetooth Headphones", "Printer Paper (A4)"
                };
                
        assertArrayEquals(expectedItemsBelow,actualItemsBelow);
    }
}
