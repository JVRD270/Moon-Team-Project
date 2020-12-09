package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddItemPage;

public class SetPriceRange extends TestBase {
	

  //This test fails because page never stops loading
  @Test
  public void canFilterSearchByPrice() {
	    

			//Act:
			Boolean pageLoaded = new AddItemPage(webDriver, baseUrl)
					.navigate()
					.goToDresses()
					.clickAndSetPriceRange(17.85)
					.waitForPageLoad();
			
			Assert.assertTrue(pageLoaded);
		}
  }
  
  
  

