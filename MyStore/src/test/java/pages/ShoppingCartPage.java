package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		SignInPage sip = new SignInPage();
		sip.navigate()
			.sendEmailInput("butt@gmail.com");
			.sendPassInput("butts");
			.submitCredentials();
			
		AddToCart atc = new AddToCart();
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
			String xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
			WebElement proceed = driver.findElement(By.xpath(xpath));
			proceed.click();
			return (AddressPage)this;
		}

}
