package stepDefinitions;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.CsvReader;
import framework.BaseStepDefinitions;
import framework.TestBase;
import framework.UserObject;
import pages.AccountDetailsPage;
import pages.RegisterPage;



public class ExampleStepDefinitions extends BaseStepDefinitions{

    String baseURL = "https://www.google.com";

    @Given("user launches Google webapp")
    public void user_launches_Google_webapp() throws Throwable {
        webDriver.get(baseURL);
    }

    @When("user searches for a \"([^\"]*)\"")
    public void user_searches_for_a(String arg1) throws Throwable {
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys(arg1);
    }

    @And("click on search button")
    public void click_on_search_button() throws Throwable {
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.submit();
    }

    @Then("results retrieved should contain the \"([^\"]*)\" used")
    public void results_retreived_should_contain_the_used(String resultString) throws Throwable {
        WebElement result = webDriver.findElement(By.className("LC20lb"));
        if (result.getText().toLowerCase().contains(resultString.toLowerCase())) {
            System.out.println("Text is matching");
        } else {
            System.out.println("Text is not matching");

        }
    }
    
    
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
