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
        inStock[productIndex - 1] += stockAdded;
    }
}
