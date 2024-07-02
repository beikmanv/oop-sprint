package org.northcoders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class OOPTest {

    @Test
    @DisplayName("User class must have required fields")
    public void testUserHasRequiredFields() {
        User testUser = new User("test", "test@northcoders.com");
        assertEquals("test", testUser.getUsername());
        assertEquals("test@northcoders.com", testUser.getEmail());
    }

    @Test
    @DisplayName("User class must start with zero balance")
    public void testUserStartsWithZeroBalance() {
        User testUser = new User("test", "test@northcoders.com");
        int actual = testUser.checkBalance();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User class must keep track of number of created accounts")
    public void testUserCountsAccountsCreated() {
        User.resetAccountsCount();

        assertEquals(0, User.getAccountsCreated());

        User testUser1 = new User("test1", "test1@northcoders.com");
        assertEquals(1, User.getAccountsCreated());

        User testUser2 = new User("test2", "test2@northcoders.com");
        assertEquals(2, User.getAccountsCreated());
    }

    @Test
    @DisplayName("User class must be able to add balance to an individual user")
    public void testUserCanAddBalance() {
        var testUser = new User("test", "test@northcoders.com");
        testUser.AddBalance(50);
        assertEquals(testUser.checkBalance(), 50);
        testUser.AddBalance(50);
        assertEquals(testUser.checkBalance(), 100);
    }

    @Test
    @DisplayName("Item class must have required fields")
    public void testItemHasRequiredFields() {

        Item testItem = new Item("testUser", "test", 10, "testing it out");
        assertEquals("testUser", testItem.getOwner());
        assertEquals("test", testItem.getName());
        assertEquals(10, testItem.getPrice());
        assertEquals("testing it out", testItem.getDescription());

    }

    @Test
    @DisplayName("User class must store items listed for sale by that user")
    public void testUserStoresListedItems() {

        var testUser = new User("testUser", "test@northcoders.com");

        String actual = testUser.ListItem("testItemName1", 20, "test description1");
        String expected = "testItemName1 has been listed for sale";

        assertEquals(actual, expected);

        var firstItemForSale = testUser.getItemsForSale()[0];

        assertEquals("testUser", firstItemForSale.getOwner());
        assertEquals("testItemName1", firstItemForSale.getName());
        assertEquals(20, firstItemForSale.getPrice());
        assertEquals("test description1", firstItemForSale.getDescription());

        actual = testUser.ListItem("testItemName2", 30, "test description2");
        expected = "testItemName2 has been listed for sale";
        assertEquals(actual, expected);

        var secondItemForSale = testUser.getItemsForSale()[1];

        assertEquals("testUser", secondItemForSale.getOwner());
        assertEquals("testItemName2", secondItemForSale.getName());
        assertEquals(30, secondItemForSale.getPrice());
        assertEquals("test description2", secondItemForSale.getDescription());
    }


    @Test
    @DisplayName("User class must be able to reduce balance")
    public void testUserCanReduceBalance() {
        var testUser = new User("test", "test@northcoders.com");
        testUser.addBalance(50);
        testUser.reduceBalance(10);
        assertEquals(testUser.checkBalance(), 40);
    }


    @Test
    @DisplayName("User class must be able to purchase an item that's for sale")
    public void testUserCanPurchaseItem() {

        var testUser1 = new User("testUser1", "test@northcoders.com");
        var testUser2 = new User("testUser2", "test@northcoders.com");
        testUser2.addBalance(50);
        Item testItem = new Item("testUser1", "testItemName", 20, "test description");

        String actual = testUser2.PurchaseItem(testItem);

        assertEquals("Your purchase of testItemName has been confirmed!", actual);
        assertEquals(30, testUser2.checkBalance());

    }


    @Test
    @DisplayName("User class must not be able to purchase an item that belongs to itself")
    public void testCantPurchaseOwnItem() {
        var testUser1 = new User("testUser1", "test1@northcoders.com");
        Item testItem1 = new Item("testUser1", "testItemName1", 20, "test description1");

        String purchaseItem1 = testUser1.purchaseItem(testItem1);
        assertEquals("This item belongs to you already!", purchaseItem1);
    }

    @Test
    @DisplayName("User class must not be able to purchase an item without sufficient funds")
    public void testPurchaseItemValidation() {
        var testUser = new User("testUser1", "test1@northcoders.com");
        Item testItem = new Item("testUser1", "testItemName2", 30, "test description2");

        String purchaseItemResult = testUser.purchaseItem(testItem);
        assertEquals("Insufficient funds", purchaseItemResult);

        assertEquals(0, testUser.checkBalance());
        testUser.addBalance(50);

        String purchaseItemResult2 = testUser.purchaseItem(testItem);
        assertEquals("Your purchase of testItemName2 has been confirmed!", purchaseItemResult2);

        assertEquals(20, testUser.checkBalance());

    }
}