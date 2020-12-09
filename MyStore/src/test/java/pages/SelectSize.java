package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;

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
