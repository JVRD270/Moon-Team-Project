package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseStepDefinitions;
import pages.SignInPage;

public class AddToWishlistStepDefinitions extends BaseStepDefinitions{
	@Given("user is logged into their account")
	public void user_is_logged_into_their_account() {
	    // Write code here that turns the phrase above into concrete actions
		SignInPage sip = new SignInPage(webDriver, baseUrl);
		sip.navigate().sendEmailInput("butt@gmail.com").sendPassInput("butts").submitCredentials();
		webDriver.navigate().to("http://automationpractice.com/index.php");
	}

	@When("user opens the printed dress")
	public void user_opens_the_printed_dress() {
		String xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/a[1]/img[1]";
		WebElement dress = webDriver.findElement(By.xpath(xpath));
		dress.click();
	    
	}

	@When("user click add to wishlist")
	public void user_click_add_to_wishlist() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement wishlist = //driver.findElement(By.id("wishlist_button"));
				new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("wishlist_button")));
		wishlist.click();
	}

	@Then("user will see the printed dress in the wishlist")
	public void user_will_see_the_printed_dress_in_the_wishlist() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement customerAccount = webDriver.findElement(By.xpath("//span[contains(text(),'Yuri Nader')]"));
		customerAccount.click();
		WebElement myWishlistSpan = webDriver.findElement(By.xpath("//span[contains(text(),'My wishlists')]"));
		myWishlistSpan.click();
		WebElement myWishlistLink = webDriver.findElement(By.xpath("//a[contains(text(),'My wishlist')]"));
		myWishlistLink.click();
		
		WebElement title =// driver.findElement(By.id("s_title"));
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("s_title")));
		
		String expected = "Printed Dress";
		String actual = title.getText();
		
		if(actual.contains(expected)) {
			System.out.println("Text matching");
		} else {
			System.out.println("Text not matching");
		}
	}
}
