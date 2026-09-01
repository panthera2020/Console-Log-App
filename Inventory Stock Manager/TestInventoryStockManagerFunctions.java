import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
