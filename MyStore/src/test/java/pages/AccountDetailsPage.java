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
	
	public void signOut() {
		WebElement signOutButton = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
		signOutButton.click();
	}

	public AccountDetailsPage changePersonalInformation(String first, String last, String pass, String day, String month, String year) {
		changeFirstName(first);
		changeLastName(last);
		enterPassword(pass);
		enterDate(day, month, year);
		WebElement save = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/fieldset[1]/div[11]/button[1]"));
		save.click();
		return this;
	}
	
	private AccountDetailsPage changeFirstName(String first) {
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.clear();
		firstName.sendKeys(first);
		return this;
	}
	
	private AccountDetailsPage changeLastName(String last) {
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.clear();
		lastName.sendKeys(last);
		return this;
	}
	
	private AccountDetailsPage enterPassword(String pass) {
		WebElement oldPassword = driver.findElement(By.id("old_passwd"));
		oldPassword.sendKeys(pass);
		return this;
	}
	
	private AccountDetailsPage enterDate(String day, String month, String year) {
		WebElement daySelect = driver.findElement(By.id("days"));
		WebElement monthSelect = driver.findElement(By.id("months"));
		WebElement yearSelect = driver.findElement(By.id("years"));
		
		daySelect.sendKeys(day);
		monthSelect.sendKeys(month);
		yearSelect.sendKeys(year);
		
		return this;
	}
	
	public String getResults() {
		WebElement results = driver.findElement(By.xpath("//p[contains(text(),'Your personal information has been successfully up')]"));
		return results.getText();
	}


}
