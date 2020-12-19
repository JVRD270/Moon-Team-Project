package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.CsvReader;
import framework.TestBase;
import framework.UserObject;
import pages.AccountDetailsPage;
import pages.RegisterPage;

public class canRegisterMultiple extends TestBase{
  @Test
  public void canRegisterMultipleUsers() throws Exception {
	  String expectedPageTitle = "My account - My Store";
	  
	  List<UserObject> accountsToRegister = new CsvReader("src/test/resources/AccountInfo.csv")
			  .makeDataObjectsFromCsv()
			  .getUsers();
	  
	  for(UserObject user:accountsToRegister) {
		  new RegisterPage(webDriver, baseUrl)
		  .navigate()
		  .sendData(user)
		  .clickRegister();
		  
		  String currentPageTitle = webDriver.getTitle();
		  Assert.assertEquals(currentPageTitle, expectedPageTitle);
		  
		  new AccountDetailsPage(webDriver, baseUrl).signOut();
	  }
  }
}
