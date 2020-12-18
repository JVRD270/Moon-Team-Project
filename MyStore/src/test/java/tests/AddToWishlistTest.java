package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddToWishlistPage;

public class AddToWishlistTest extends TestBase{
	
	@Test
	public void canAddToWishlist() {
		String expected = "Printed Dress";
		String actual = new AddToWishlistPage(webDriver, baseUrl).navigate()
				.addToWishlist()
				.checkWishList();
		Assert.assertTrue(actual.contains(expected));
	}
}
