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
	
	@Test
	public void canChangeAccountDetails() {
		String expected = "Your personal information has been successfully updated.";
		String actual = new AccountDetailsPage(webDriver, baseUrl).navigate()
				.myAccount()
				.changePersonalInformation("Yuri", "Nader", "butts", "4", "6", "2008")
				.getResults();
		Assert.assertEquals(actual, expected);
	}
}
