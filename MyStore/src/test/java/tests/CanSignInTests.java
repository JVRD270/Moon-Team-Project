package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.SignInPage;

public class CanSignInTests extends TestBase{
	@Test
	public void tc1CanUserSignIn() {
		String expectedPageTitle = "My account - My Store";
		String email = "butt@gmail.com";
		String password = "butts";
		new SignInPage(webDriver, baseUrl)
			.navigate()
			.sendEmailInput(email)
			.sendPassInput(password)
			.submitCredentials();
		// Is there a better way to check for signing in?
		String currentPageTitle = webDriver.getTitle();
		Assert.assertEquals(currentPageTitle, expectedPageTitle);
	}
	
}
