package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.RegisterPage;

public class CanRegisterTests extends TestBase{

	@Test
	public void tc1CanUserRegister() {
		String expectedPageTitle = "My account - My Store";
		// Reconsider email creation
		String email = randomEmailString();
		String firstName = "testFirst";
		String lastName = "testLast";
		String pass = "testPass";
		String address = "111 test road";
		String city = "test city";
		String state = "Tennessee";
		String zip = "11111";
		String country = "United States";
		String mobile = "111-111-1111";
		new RegisterPage(webDriver, baseUrl)
			.navigate()
			.sendEmailInput(email)
			.clickCreateAccount()
			.sendFirstNameInput(firstName)
			.sendLastNameInput(lastName)
			.sendPassInput(pass)
			.sendAddressInput(address)
			.sendCityInput(city)
			.selectState(state)
			.sendZipInput(zip)
			.selectCountry(country)
			.sendMobileInput(mobile)
			.clickRegister();
		String currentPageTitle = webDriver.getTitle();
		Assert.assertEquals(currentPageTitle, expectedPageTitle);
	}
	
	public String randomEmailString() {
		 
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    String domain = "@qtrix20.com";
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
	    return generatedString + domain;
	}
}
