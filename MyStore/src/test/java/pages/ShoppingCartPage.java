package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class ShoppingCartPage extends PageObjectBase{
	
	public ShoppingCartPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public ShoppingCartPage navigate(){
		super.navigate("?controller=order");
		return this;
	}
	
	public ShoppingCartPage goToShoppingCart(){
		SignInPage sip = new SignInPage(driver, baseUrl);
		sip.navigate()
			.sendEmailInput("butt@gmail.com")
			.sendPassInput("butts")
			.submitCredentials();
			
		AddItemPage atc = new AddItemPage(driver, baseUrl);
		atc.navigate()
		.searchForDress()
		.addFirstDress()
		.proceedToCheckout();
		
		//easiest way to shoppingCart page
		//super.navigate("?controller=order");
		
		return this;
	}
	
	//if signed in goes to address other wise it goes to sign in
		public AddressPage proceedToCheckOut(){
			String xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
			System.out.println("Shopping Cart Page");
			WebElement proceed = driver.findElement(By.xpath(xpath));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceed));
			proceed.click();
			return new AddressPage(driver, baseUrl);
		}

}
