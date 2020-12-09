package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.CartItem;
import framework.TestBase;
import pages.AddItemPage;
import pages.ShoppingCartPage;

public class AddMultipleItems extends TestBase {
  @Test
  public void canAddMultipleItems() {
	//Arrange:
			String expectedText= "Printed Summer Dress";
			int expectedNumberOfDuplicates = 4;

			//Act:
			new AddItemPage(webDriver, baseUrl)
					.navigate()
					.searchForDress()
					.addMultiple(expectedNumberOfDuplicates)
					.proceedToCheckout();
			
			CartItem myItem = new ShoppingCartPage(webDriver, baseUrl)
					.navigate()
					.getCartItem(expectedText);
			
			String itemName = myItem.getName();
			String itemQty = myItem.getQuantity();

			//Assert: (actual vs expected) 
			Assert.assertEquals(itemName, expectedText);
			Assert.assertEquals(Integer.parseInt(itemQty), expectedNumberOfDuplicates);
  }
}
