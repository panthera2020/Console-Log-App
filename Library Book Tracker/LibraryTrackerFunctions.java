public class LibraryTrackerFunctions {
    private int [] bookTracker;
    private String [] bookTitle;
    
    public LibraryTrackerFunctions(){
        int [] bookTracker = new int [30];
        String [] bookTitle = {"No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                               "No Book","No Book","No Book","No Book","No Book","No Book",
                                };
                                
        this.bookTracker = bookTracker;
        this.bookTitle = bookTitle;
    }
    
    public String [] checkShelf(){
        return bookTitle;
    }
    
    public String [] displayShelf(){
        arrangeShelf();
        return bookTitle;
    }
    
    public void addBook(int shelfPosition, String book){
        if(bookTracker[shelfPosition - 1] == 0){
            bookTitle[shelfPosition - 1] = book;
            bookTracker[shelfPosition - 1]++;
        }
    }
    
    public String takeBook(int shelfPosition){
        String bookTaken = "";
        if(bookTracker[shelfPosition - 1] == 1){
            bookTaken = bookTitle[shelfPosition - 1];
            bookTracker[shelfPosition - 1]--;
            bookTitle[shelfPosition - 1] = "No Book";    
        }
                
        return bookTaken;
    }
    
    public boolean isShelfEmpty(int shelfPosition){
        boolean isEmpty = false;
        if(bookTracker[shelfPosition - 1] == 1 || bookTracker[shelfPosition - 1] == 0){
            if(bookTracker[shelfPosition - 1] == 0 ){
                isEmpty = true;
            }else{
                isEmpty = false;
            }
        }
        return isEmpty;
    }
    
    public String getBookTitle(int shelfPosition){
        String book = bookTitle[shelfPosition - 1];
        return book;
    } 
    
    public void arrangeShelf(){
        String store = "";
        for(int index = 0; index < bookTitle.length; index++){
            String book = bookTitle[index];
            for(int count = 0; count < bookTitle.length; count++){
                String otherBooks = bookTitle[count];
                if(book.compareTo(otherBooks) < 0){
                    store = bookTitle[index];
                    bookTitle[index] = bookTitle[count];
                    bookTitle[count] = store;
                }
            }
        }
    }
    
    public boolean searchShelf(String book){
        boolean isAvailable = false;
        for(int index = 0; index < bookTitle.length; index++){
            if(book.equalsIgnoreCase(bookTitle[index])){
                isAvailable = true;
            }
        }
        
        return isAvailable;
    }
    
    public int locateBook(String book){
        int bookLocation = -1;
        if(searchShelf(book)){
            for(int index = 0; index < bookTitle.length; index++){
                if(book.equalsIgnoreCase(bookTitle[index])){
                    bookLocation = index + 1;
                    break;
                }
            }
                        
        }
        return bookLocation;
    }
}











