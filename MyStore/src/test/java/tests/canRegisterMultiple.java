package tests;

import java.util.List;

import org.testng.annotations.Test;

import framework.CsvReader;
import framework.TestBase;
import framework.UserObject;
import pages.AccountDetailsPage;
import pages.RegisterPage;

public class canRegisterMultiple extends TestBase{
  @Test
  public void canRegisterMultipleUsers() throws Exception {
	  List<UserObject> accountsToRegister = new CsvReader("src/test/resources/AccountInfo.csv")
			  .makeDataObjectsFromCsv()
			  .getUsers();
	  
	  for(UserObject user:accountsToRegister) {
		  new RegisterPage(webDriver, baseUrl)
		  .navigate()
		  .sendData(user)
		  .clickRegister();
		  
		  new AccountDetailsPage(webDriver, baseUrl).signOut();
	  }
  }
}
