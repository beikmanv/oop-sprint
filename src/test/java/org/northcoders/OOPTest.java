package org.northcoders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class OOPTest {

    @Test
    @DisplayName("This test always passes")
    public void testAlwaysPasses() {
        assertTrue(true);
    }

/*
    @Test
    @DisplayName("User class must have required fields")
    public void testUserHasRequiredFields() {
        User testUser = new User("test", "test@northcoders.com");
        assertEquals("test", testUser.getUsername());
        assertEquals("test@northcoders.com", testUser.getEmail());

    }

*/
/*
    @Test
    @DisplayName("User class must start with zero balance")
    public void testUserStartsWithZeroBalance() {
        User testUser = new User("test", "test@northcoders.com");
        int actual = testUser.getBalance();
        int expected = 0;
        assertEquals(expected, actual);
    }
*/
/*
    @Test
    @DisplayName("User class can update balance")
    public void testUserUpdateBalance() {
        User testUser = new User("test", "test@northcoders.com");

        testUser.updateBalance(55);

        assertEquals(55, testUser.getBalance());

        testUser.updateBalance(-5);
        assertEquals(50, testUser.getBalance());
    }

*/
/*
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

*/
/*
    @Test
    @DisplayName("Item class must have required fields")
    public void testItemHasRequiredFields() {

        Item testItem = new Item("testUser", "test", 10, "testing it out");
        assertEquals("testUser", testItem.getOwner());
        assertEquals("test", testItem.getName());
        assertEquals(10, testItem.getPrice());
        assertEquals("testing it out", testItem.getDescription());

        testItem.setName("newname");
        assertEquals("newname", testItem.getName());

        testItem.setOwner("newowner");
        assertEquals("newowner", testItem.getOwner());

        testItem.setDescription("newdesc");
        assertEquals("newdesc", testItem.getDescription());

        testItem.setPrice(99);
        assertEquals(99, testItem.getPrice());

    }

*/
/*
    @Test
    @DisplayName("User class must store items listed for sale by that user")
    public void testUserStoresListedItems() {

        var testUser = new User("testUser", "test@northcoders.com");

        Item first = testUser.listItem("testItemName1", 20, "test description1");
        var firstItemForSale = testUser.getItemsForSale().get(0);

        assertEquals(first, firstItemForSale);

        var second = testUser.listItem("testItemName2", 30, "test description2");
        assertEquals(second, testUser.getItemsForSale().get(1));

       }

*/
/*
    @Test
    @DisplayName("User class must be able to purchase an item that's for sale")
    public void testUserCanPurchaseItem() {

        var seller = new User("testUser1", "test@northcoders.com");
        var item = seller.listItem("Cheese", 20, "A lovely cheese");
        var buyer = new User("testUser2", "test@northcoders.com");

        buyer.updateBalance(50);
        var result = buyer.purchaseItem(item);

        assertEquals(PurchaseResult.SUCCESS, result);
        assertEquals(30, buyer.getBalance());

    }
*/
/*
    @Test
    @DisplayName("User class must not be able to purchase an item without sufficient funds")
    public void testPurchaseItemWithoutFunds() {
        var seller = new User("testUser1", "test@northcoders.com");
        var item = seller.listItem("Cheese", 20, "A lovely cheese");

        var buyer = new User("testUser2", "test@northcoders.com");
        assertEquals(0, buyer.getBalance());

        var purchaseItemResult = buyer.purchaseItem(item);
        assertEquals(PurchaseResult.INSUFFICIENT_FUNDS, purchaseItemResult);

        buyer.updateBalance(50);

        purchaseItemResult = buyer.purchaseItem(item);
        assertEquals(PurchaseResult.SUCCESS, purchaseItemResult);
        assertEquals(30, buyer.getBalance());
    }

*/
/*
    @Test
    @DisplayName("User class must not be able to purchase an item that belongs to itself")
    public void testCantPurchaseOwnItem() {
        var seller = new User("testUser1", "test@northcoders.com");
        var item = seller.listItem("Cheese", 20, "A lovely cheese");

        var purchaseItemResult = seller.purchaseItem(item);
        assertEquals(PurchaseResult.ALREADY_OWNED, purchaseItemResult);
    }
    */
}