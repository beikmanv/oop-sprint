package org.northcoders;

public class Main {
    public static void main(String[] args) {
        // Create users
        User seller = new User("testUser1", "seller@example.com");
        User buyer = new User("testUser2", "buyer@example.com"); // Make sure this line exists

        // List an item for sale
        Item item = seller.listItem("Cheese", 20, "A lovely cheese");

        // Print the current date
        System.out.println(item.getName() + " was " + item.getPrettyDateListed());

        // Display initial balances
        System.out.println(buyer.getUsername() + " balance: " + buyer.getBalance());
        System.out.println(seller.getUsername() + " balance: " + seller.getBalance());

        // Buyer tries to purchase the item
        PurchaseResult result = buyer.purchaseItem(item, seller);
        System.out.println("Purchase result: " + result);

        // Display updated balances
        System.out.println(buyer.getUsername() + " balance: " + buyer.getBalance());
        System.out.println(seller.getUsername() + " balance: " + seller.getBalance());
    }
}
