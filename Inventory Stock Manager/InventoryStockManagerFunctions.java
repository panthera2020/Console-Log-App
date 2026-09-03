import java.util.ArrayList;

public class InventoryStockManagerFunctions{
    private int[] inStock = new int[25];
    
    private String [] products = {
                "Ballpoint Pens","Note Books","Sticky Notes","Staplers", "Desk Chair", 
                "LED Desk Lamp","USB-C Cable","Wireless Mouse","Mechanical Keyboard",
                "27-inch Monitor","Cofee Beans(1kg)","Paper Towel","Face Wipes","Scissors",
                "Hand Sanitizer(500ml)","Whiteboard Marker set","Paper Clip","HDMI Cable(2m)",
                "Bottle Water(50cl)","Face Cap","Bread","Baby Oil(150ml)","Laptop Stand", 
                "Bluetooth Headphones", "Printer Paper (A4)"
                };
    
    private double [] price = {
                5.50, 7.0, 1.50, 12, 85, 22.5, 8, 18, 45, 199.99, 14, 2.5, 4, 6.5, 9, 
                2.9, 10.5, 1.99, 8, 3.23, 7.25, 20, 35, 15.99, 4.75
    };
    
    public int [] checkStock(){
        return inStock;
    }
    
    public void addToStock(int productIndex, int stockAdded){
        if(stockAdded > 0){
            inStock[productIndex - 1] += stockAdded;
        }        
    }
    
    public void sellProduct(int productIndex, int numberOfProducts){
        if(inStock[productIndex -1] > numberOfProducts){
            inStock[productIndex - 1] -= numberOfProducts;
        }        
    }
    
    public boolean isStockEmpty(int productIndex){
        boolean isEmpty = false;
        if(inStock[productIndex - 1] == 0){
            isEmpty = true;
        }
        return isEmpty;
    }
    
    public ArrayList<Object[]> displayStock(){
        ArrayList<Object[]> productAndStock = new ArrayList<>();        
        for(int index = 0; index < inStock.length; index++){
            Object [] stockAndProduct = new Object[3]; 
            stockAndProduct[0] = products[index];
            stockAndProduct[1] = inStock[index];
            stockAndProduct[2] = price[index];
            
            productAndStock.add(stockAndProduct);
        }
        
        return productAndStock;
    }
    
    public String getHighestItem(){
        int highestInStock = inStock[0];
        int highestInStockIndex = 0;
        for(int index = 0; index < inStock.length; index++){
            if(inStock[index] > highestInStock){
                highestInStockIndex = index;
                
            }
        }
        
        String highestItem = products[highestInStockIndex];
        return highestItem;
    }
    
    public int getTotalStock(){
        int sumStock = 0;
        for(int index = 0; index < inStock.length; index++){
            sumStock += inStock[index];
        }
        return sumStock;
    }
    
    public Object [] getItemsBelow(int minimumAmount){
        ArrayList<String> itemsBelow = new ArrayList<>();
        for(int index = 0; index < inStock.length; index++){
            if(inStock[index] < minimumAmount){
                itemsBelow.add(products[index]);
            }
        }
        
        Object [] itemsBelowAmount = itemsBelow.toArray();
        return itemsBelowAmount;
    }
    
    public boolean isNumberValid(String number){
        boolean isValid = false;
        for(int index = 0; index < number.length(); index++){
            char digit = number.toLowerCase().charAt(index);
            if(Character.isDigit(digit)){
                isValid = true;
            }
            else{
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}





