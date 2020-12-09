package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddItemPage;

public class SelectSize extends TestBase{
	
	@Test
	public void canSelectSize(){

	    String expectedSize = "M";

	    String actualSize = new AddItemPage(webDriver, baseUrl).navigate()
	              .goToDresses()
	              .clickSummerDress()
	              .clickYourSize()
	              .addSizeToCart()
	              .confirmSize();

	      Assert.assertEquals(actualSize, expectedSize); 

	  }

}
