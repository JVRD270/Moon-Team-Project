package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage extends ShoppingCartPage{
	public AddressPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public AddressPage navigate(){
		super.navigate("?controller=order&step=1&multi-shipping=0");
		return this;
	}
	
	public ShippingPage proceedToCheckOut(){
		String xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return (ShippingPage)this;
	}
}
