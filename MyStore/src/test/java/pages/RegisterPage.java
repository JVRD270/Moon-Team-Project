package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class RegisterPage extends PageObjectBase{
	private final String urlPath = "?controller=authentication&back=my-account";
	
	public RegisterPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="email_create")
	WebElement emailInput;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccountButton;
	
	@FindBy(id="customer_firstname")
	WebElement firstNameInput;
	
	@FindBy(id="customer_lastname")
	WebElement lastNameInput;
	
	@FindBy(id="passwd")
	WebElement passInput;
	
	@FindBy(id="address1")
	WebElement addressInput;
	
	@FindBy(id="city")
	WebElement cityInput;
	
	@FindBy(id="id_state")
	WebElement stateInput;
	
	@FindBy(id="postcode")
	WebElement zipInput;
	
	@FindBy(id="id_country")
	WebElement countryInput;
	
	@FindBy(id="phone_mobile")
	WebElement mobileInput;
	
	@FindBy(id="submitAccount")
	WebElement registerButton;
	
	
	
	public RegisterPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public RegisterPage sendEmailInput(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	public RegisterPage clickCreateAccount() {
		createAccountButton.click();
		waitForRegisterPage();
		return this;
	}
	
	private void waitForRegisterPage() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(firstNameInput));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public RegisterPage sendFirstNameInput(String firstName) {
		firstNameInput.sendKeys(firstName);
		return this;
	}
	public RegisterPage sendLastNameInput(String lastName) {
		lastNameInput.sendKeys(lastName);
		return this;
	}
	public RegisterPage sendPassInput(String pass) {
		passInput.sendKeys(pass);
		return this;
	}
	public RegisterPage sendAddressInput(String address) {
		addressInput.sendKeys(address);
		return this;
	}
	public RegisterPage sendCityInput(String city) {
		cityInput.sendKeys(city);
		return this;
	}
	public RegisterPage selectState(String state) {
		new Select(stateInput).selectByVisibleText(state);
		return this;
	}
	public RegisterPage sendZipInput(String zip) {
		zipInput.sendKeys(zip);
		return this;
	}
	public RegisterPage selectCountry(String country) {
		new Select(countryInput).selectByVisibleText(country);
		return this;
	}
	public RegisterPage sendMobileInput(String mobile) {
		mobileInput.sendKeys(mobile);
		return this;
	}
	public RegisterPage clickRegister() {
		registerButton.click();
		return this;
	}
	
	
}
