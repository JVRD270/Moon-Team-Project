package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AddItemPage;

public class SetPriceRange extends TestBase {
	
	
  @Test
  public void canFilterSearchByPrice() {
	    
	        //Arrange:
			String expectedText= "Printed Summer Dress";

			//Act:
			new AddItemPage(webDriver, baseUrl)
					.navigate()
					.goToDresses()
					.clickAndSetPriceRange(17.85)
					.waitForPageLoad();



		}
	  
	  
	  
  }
  
  
  

