package tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddressPage;
import pages.ShoppingCartPage;

public class CheckoutTest extends TestBase{
	@Test
	public void canCheckoutProduct() {
		String expectedURL = "http://automationpractice.com/index.php?controller=order-confirmation&id_cart=2438500&id_module=3&id_order=262704&key=3edb94b4bcf988091cb45f9530a2f4e2";
		ShoppingCartPage sp = new ShoppingCartPage(webDriver, baseUrl);
		sp.goToShoppingCart()
			.proceedToCheckOut()//address
			.proceedToCheckOut()
			.proceedToCheckOut()
			.proceedToCheckOut()
			.proceedToCheckOut()
			.PayByBankWire()
			.confirmOrder();
		String actualURL = webDriver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
			
	}
	
	@BeforeTest
	public void before() {
		super.beforeTest();
	}
	
	@AfterTest
	public void after() {
		super.afterTest();
	}
}
