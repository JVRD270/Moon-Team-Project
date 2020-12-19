package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseStepDefinitions;
import framework.TestBase;
import pages.AccountDetailsPage;

public class AccountDetailsStepDefinitions extends BaseStepDefinitions{
	
	@Given("^user views account details$")
	public void loginToAccount(){
		AccountDetailsPage adp = new AccountDetailsPage(webDriver, baseUrl);
		adp.navigate().myAccount();
	}
	
	@When ("^user enters \"([^\"]*)\" into First Name$")
	public void changeFirstName(String first) {
		WebElement firstName = webDriver.findElement(By.id("firstname"));
		firstName.clear();
		firstName.sendKeys(first);
	}
	
	@And ("^user enters  \"([^\"]*)\" into Last Name$")
	public void changeLastName(String last) {
		WebElement lastName = webDriver.findElement(By.id("lastname"));
		lastName.clear();
		lastName.sendKeys(last);
	}
	
	@And ("^user enters  \"([^\"]*)\" into Current Password$")
	public void enterPassword(String pass) {
		WebElement oldPassword = webDriver.findElement(By.id("old_passwd"));
		oldPassword.sendKeys(pass);
	}
	
	@And("^clicks save button$")
	public void saveChanges(){
		WebElement save = webDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/fieldset[1]/div[11]/button[1]"));
		save.click();
	}
	
	@Then("response given \"([^\"]*)\"")
	public void results(String expected){
		WebElement results = webDriver.findElement(By.xpath("//p[contains(text(),'Your personal information has been successfully up')]"));
		String actual = results.getText();
		if(actual.equals(expected)){
			System.out.println("Text is matching");
		} else {
			System.out.println("Text is not matching");
		}
	}
}
