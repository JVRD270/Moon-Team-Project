package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseStepDefinitions;
import framework.TestBase;
import pages.AddItemPage;

public class BreadcrumbStepDefinitions extends BaseStepDefinitions{

	@Given("user goes to the home page")
	public void given_user_is_on_the_home_page() throws Throwable {
	    // When implemented, should return use new homePage instead...
		new AddItemPage(webDriver, baseUrl).navigate();
	}

	@When("user goes to the dresses page")
	public void user_goes_to_dresses_page() throws Throwable {
		new AddItemPage(webDriver, baseUrl).goToDresses();
	}

	@When("user clicks on the summer dress item")
	public void user_clicks_on_the_summer_dress_item() throws Throwable {
		new AddItemPage(webDriver, baseUrl).clickSummerDress();
	}

	@When("user clicks the home breadcrumb")
	public void user_clicks_the_home_breadcrumb() throws Throwable {
		new AddItemPage(webDriver, baseUrl).clickHomeBreadcrumb();
	}

	@Then("user is on the home page")
	public void then_user_is_on_the_home_page() throws Throwable {
	    Assert.assertEquals(webDriver.getTitle(), "My Store");
	}
	
	
	
}
