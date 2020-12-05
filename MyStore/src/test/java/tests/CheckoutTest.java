package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.ShoppingCartPage;

public class CheckoutTest extends TestBase{
	@Test
	public void canCheckoutProduct() {
		String expectedHeader = "ORDER CONFIRMATION";
		ShoppingCartPage sp = new ShoppingCartPage(webDriver, baseUrl);
		sp.goToShoppingCart()
			.navigate()
			.proceedToCheckOut()//address
			.proceedToCheckOut()
			.proceedToCheckOut()
			.PayByBankWire()
			.confirmOrder();
		String actualHeader = webDriver.findElement(By.xpath("//h1[contains(text(),'Order confirmation')]")).getText();
		
		Assert.assertEquals(actualHeader, expectedHeader);
			
	}
}
