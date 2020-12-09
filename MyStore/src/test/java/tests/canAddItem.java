package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddItemPage;

public class canAddItem extends TestBase {

	@Test
	public void canAddItemToCart() {

		//Arrange:
		String expectedText= "Printed Summer Dress";

		//Act:
		String actualText = new AddItemPage(webDriver, baseUrl)
				.navigate()
				.searchForDress()
				.addFirstDress()
				.proceedToCheckout()
				.getItemTextFromCart();

		//Assert: (actual vs expected) 
		Assert.assertEquals(actualText, expectedText);


	}
	
	@BeforeTest
	public void beforeTest() {
		super.beforeTest();
	}
	
	@AfterTest
	public void afterTest() {
		super.afterTest();
	}


}
