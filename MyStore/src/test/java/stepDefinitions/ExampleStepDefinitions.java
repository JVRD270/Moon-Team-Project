package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseStepDefinitions;
import framework.TestBase;



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

}
