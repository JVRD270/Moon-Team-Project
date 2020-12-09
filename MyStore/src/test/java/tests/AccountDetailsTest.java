package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.AccountDetailsPage;

public class AccountDetailsTest extends TestBase{
	
	@Test
	public void canViewAccountDetails() {
		String expectedTitle = "YOUR PERSONAL INFORMATION";
		String actualTitle = new AccountDetailsPage(webDriver, baseUrl).navigate()
				.myAccount()
				.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
