import java.util.ArrayList;

public class PhoneBookFunctions {
    private ArrayList<String[]> phoneBook = new ArrayList<>();
    
    public PhoneBookFunctions(){
        this.phoneBook = phoneBook;
    }
    
    public void addContact(String name, String number){
        if(number.length() == 11 && isNumberValid(number) && !isNameDuplicate(name)){
            String [] contact = new String[2];
            contact[0] = name;
            contact[1] = number;
            phoneBook.add(contact);
        }
    }
    
    public String[][] checkContact(){
        arrangeContact();
        String[][] contacts = new String[phoneBook.size()][];
        if(phoneBook.size() > 0){
            
            for(int index = 0; index < contacts.length; index++){
                contacts[index] = phoneBook.get(index);
            }
        }
        return contacts;
    }
    
    public boolean isNumberValid(String number){
        boolean isValid = true;
        for(int index = 0; index < number.length(); index++){
            char digit = number.toLowerCase().charAt(index);
            if(digit >= 'a' && digit <= 'z'){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    
    public boolean isNameDuplicate(String name){
        boolean isDuplicate = false;
        String [][] contacts = checkContact();
        String [] contactNames = new String[phoneBook.size()];
        
        for(int index = 0; index < phoneBook.size(); index++){
            contactNames[index] = contacts[index][0];
        }
        
        for(int index = 0; index < contactNames.length; index++){
            String eachName = contactNames[index];
            if(name.equals(eachName)){
                isDuplicate = true;
                break;
            }
        }
        
        return isDuplicate;
    }
    
    public void deleteContact(String name){
        if(isNameDuplicate(name)){
            int contactLocation = 0;
            for(int index = 0; index < phoneBook.size(); index++){
                String [] contactNameAndNumber = phoneBook.get(index);
                String contactName = contactNameAndNumber[0];

                if(name.equals(contactName)){
                    contactLocation = index;
                    break;
                }
            }
            
            phoneBook.remove(contactLocation);
        }
    }
    
    public void arrangeContact(){

        for(int index = 0; index < phoneBook.size(); index++){
            for(int count = 0; count < phoneBook.size(); count++){
                String contactName = phoneBook.get(index)[0];
                String otherContactName = phoneBook.get(count)[0];
                if(contactName.compareTo(otherContactName) < 0){
                    String [] store = phoneBook.get(index);
                    phoneBook.set(index, phoneBook.get(count));
                    phoneBook.set(count, store);
                } 
            }
        }
    }
    
    public String[] searchContact(String name){
        String [] contactFound = new String[2];
        if(isNameDuplicate(name)){
            String [][] contact = checkContact();
            
            for(int index = 0; index < contact.length; index++){
                String contactNames = contact[index][0];
                if(contactNames.equals(name)){
                    contactFound = contact[index];
                    break;
                }
            }
        }
        return contactFound;
    }
}




