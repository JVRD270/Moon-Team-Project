package framework;

import org.openqa.selenium.WebDriver;

import pages.RegisterPage;

public class FormFiller {
	RegisterPage registerPage;
	UserObject data;
	
	public FormFiller(UserObject data, WebDriver driver, String baseUrl) {
		this.registerPage = new RegisterPage(driver, baseUrl);
		this.data = data;
	}
	
	public void sendData() {
		registerPage.sendEmailInput(data.email)
		.clickCreateAccount()
		.sendFirstNameInput(data.firstName)
		.sendLastNameInput(data.lastName)
		.sendPassInput(data.password)
		.sendAddressInput(data.houseNumber + " " + data.street)
		.sendCityInput(data.city)
		.selectState(data.state)
		.sendZipInput(data.postalCode)
		.selectCountry(data.country)
		.sendMobileInput(data.mobilePhone);
	}
}
