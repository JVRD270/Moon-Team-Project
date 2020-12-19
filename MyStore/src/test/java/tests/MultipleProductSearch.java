package tests;

import org.testng.Assert;
import framework.TestBase;
import pages.MultipleProductSearchPage;

import org.testng.annotations.Test;

public class MultipleProductSearch extends TestBase {
  @Test
  public void SearchingMultipleProducts() {
	  
	  
	  //Arrange:
	  String expectedDressText= "Printed Summer Dress";
	  String expectedShirtText= "Faded Short Sleeve T-shirts"; 
	  
	  //Act:
	  String actualDressText = new MultipleProductSearchPage(webDriver, baseUrl)
			  .navigate()
			  .searchYellowDress()
			  .verifyDressResult();
	  
	  String actualShirtText = new MultipleProductSearchPage(webDriver, baseUrl)
			  .navigate()
			  .searchShirt()
			  .verifyShirtResult();
	  
	  //Assert: (actual vs expected) 
	  Assert.assertEquals(actualDressText, expectedDressText);
	  
	  Assert.assertEquals(actualShirtText, expectedShirtText);
	  
  }
}
