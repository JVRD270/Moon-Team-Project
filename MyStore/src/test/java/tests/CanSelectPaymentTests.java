package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.ShoppingCartPage;

public class CanSelectPaymentTests extends TestBase{
	@Test
	public void tc1CanSelectPayment() {
		String expectedPaymentHeader = "CHECK PAYMENT";
		ShoppingCartPage sp = new ShoppingCartPage(webDriver, baseUrl);
		String selectedPaymentHeader = sp.goToShoppingCart()
			.navigate()
			.proceedToCheckOut()//address
			.proceedToCheckOut()
			.proceedToCheckOut()
			.selectPaymentByString("check")
			.getSelectedPaymentHeader();
		
		// Could potentially confirm order and check for check payment from there
		Assert.assertEquals(selectedPaymentHeader, expectedPaymentHeader);
			
	}

}
