package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class AccountDetailsPage extends PageObjectBase{
	
	public AccountDetailsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public AccountDetailsPage navigate(){
		super.navigate("");
		return this;
	}
	
	
	public AccountDetailsPage myAccount() {
		SignInPage sip = new SignInPage(driver, baseUrl);
		sip.navigate()
			.sendEmailInput("butt@gmail.com")
			.sendPassInput("butts")
			.submitCredentials();
		
		WebElement myAccount = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]"));
		myAccount.click();
		
		WebElement personalInformation = driver.findElement(By.xpath("//span[contains(text(),'My personal information')]"));
		personalInformation.click();
		return this;
	}
	
	public String getTitle() {
		WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Your personal information')]"));
		return title.getText();
	}
}
