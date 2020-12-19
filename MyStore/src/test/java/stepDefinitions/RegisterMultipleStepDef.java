package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseStepDefinitions;
import framework.CsvReader;
import framework.UserObject;
import pages.AccountDetailsPage;
import pages.RegisterPage;

public class RegisterMultipleStepDef extends BaseStepDefinitions {
    //////////////////////////////////// STARTS REGISTER MULTIPLE TEST
    
    
    List<UserObject> accountsToRegister = new ArrayList<UserObject>();
    RegisterPage registerPage;
    
    @Given("I want to register multiple clients from a csv file to my store")
    public void readMyCSV() throws Exception {
    	accountsToRegister = new CsvReader("src/test/resources/AccountInfo.csv")
		  .makeDataObjectsFromCsv()
		  .getUsers();
    }
    
    @When("I navigate to register page")
    public void navigateToRegisterPage() {
    	registerPage = new RegisterPage(webDriver, baseUrl).navigate();
    }
    
    @And("submit required data for multiple users")
    public void submitUsersData() {
    	for(int i=0; i<accountsToRegister.size(); i++) {
    		registerPage.sendData(accountsToRegister.get(i)).clickRegister();
    		
   		  new AccountDetailsPage(webDriver, baseUrl).signOut();
    	}
    }
    
    @Then("I verify each user already has their email registered")
    public void verifyUsersAreRegistered() {
    	for(int i=0;i<accountsToRegister.size();i++) {
    		registerPage.navigate()
    		.sendEmailInput(accountsToRegister.get(i).getEmail())
    		.clickCreateAccount();
    		
    		new WebDriverWait(webDriver, 5).until(d -> webDriver.getPageSource().contains("An account using this email address has already been registered. Please enter a valid password or request a new one."));
    	}
    }
    
    

}
