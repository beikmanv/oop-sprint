package org.northcoders;
import java.util.ArrayList;

public class User {
    //QUESTION: Why getters are automatically inserted before parameters/attributes?

    // Fields should be private (can only be modified through specific methods or are not modifiable)
    private static int userCount = 0; // Static counter for user IDs
    private int userId; // Unique ID for the user
    private String username;
    private String email;
    private int balance;
    //QUESTION: Can I generate a method similar to Getter, Setter, etc.?
    //QUESTION: Why static don't need a constructor?
    static private int accountsCreated = 0;
    private ArrayList<Item> itemsForSale; // Private field to hold items for sale

    // Constructor with validation
    public User(String username, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        this.userId = ++userCount; // Increment and set userId
        this.username = username;
        this.email = email;
        this.balance = 0;
        accountsCreated++;
        this.itemsForSale = new ArrayList<>();
    }
    //Getter for user ID
    public int getUserId() { return userId; }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    //Getter for balance
    public int getBalance() {
        return balance;
    }

    // Email validation method using regex
    private boolean isValidEmail(String email) {
        // Regex pattern for valid email format
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    // Method to get the list of items for sale
    public ArrayList<Item> getItemsForSale() {
        return itemsForSale;
    }

    // Method to add an item for sale
    public void setItemsForSale(ArrayList<Item> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }

    //QUESTION: Why it's public?
    //Method for updating the balance with positive or negative amount
    public void updateBalance(int amount) {
        balance += amount;
    }

    // Method for counting the amount of accounts
    public static int getAccountsCreated() {
        return accountsCreated;
    }

    // Method for resetting the count of accounts created
    public static void resetAccountsCount() {
        accountsCreated = 0;
    }

    /*
    This method should take 3 arguments: name, price, description.
    It should create a new instance of Item with the Owner set to the users Username and the rest of the fields set to the values from the method parameters.
    It should then add that newly created item to the itemsForSale list.
    Finally, it should return the newly created item.
    */
    // Method to list an item for sale
    public Item listItem(String name, int price, String description) {
        Item newItem = new Item(this.userId, name, price, description); // Create a new Item
        itemsForSale.add(newItem); // Add it to the itemsForSale list
        return newItem; // Return the newly created item
    }

    /*
    Add a new method called purchaseItem to the User class which takes an argument of an instance of Item.
    This method reduces the users balance by the price of the item
    It should return the enum value PurchaseResult.SUCCESS
     */
    // Method for buying an item (enum is declared in PurchaseResult.java file)
    public PurchaseResult purchaseItem(Item item, User seller) {
        if (item == null) {
            return PurchaseResult.ITEM_NOT_FOUND; // Check if item exists
        }

        // Check if the user is trying to purchase their own item (when we use a String (Username))
        /*
        if (item.getOwner().equals(this.username)) {
            return PurchaseResult.ALREADY_OWNED; // Return if trying to buy own item
        }
         */

        // Check if the user is trying to purchase their own item (when we use int (used ID))
        if (item.getOwner() == this.userId) {  // Compare userId values
            return PurchaseResult.ALREADY_OWNED; // Return if trying to buy own item
        }


        int itemPrice = item.getPrice(); // Assuming Item has a getPrice() method

        // Check if the user has enough funds
        if (itemPrice > balance) {
            return PurchaseResult.INSUFFICIENT_FUNDS; // Return if insufficient balance
        }

        balance -= itemPrice; // Deduct the price from the user's balance
        seller.unlistItem(item);
        return PurchaseResult.SUCCESS; // Return success if purchase is valid
    }

    private void unlistItem(Item item) {
        itemsForSale.remove(item);
    }

}

