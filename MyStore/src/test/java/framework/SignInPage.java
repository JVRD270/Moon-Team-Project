package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObjectBase{
	private final String urlPath = "/index.php?controller=authentication&back=my-account";
	
	public SignInPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="passwd")
	WebElement passwordInput;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	public SignInPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	// Can add wrappers to these inputs?
	public SignInPage sendEmailInput(String email) {
		emailInput.sendKeys(email);
		return this;
	}
	
	public SignInPage sendPassInput(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	
	public SignInPage submitCredentials() {
		submitButton.click();
		return this;
	}
}
