package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage extends AddressPage{
	public ShippingPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public ShippingPage navigate(){
		super.navigate("?controller=order");
		return this;
	}
	
	//goes to payment
	public PaymentPage proceedToCheckOut(){
		String checkboxPath = "//input[@id='cgv']";
		driver.findElement(By.xpath(checkboxPath)).click();
		
		String xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return (PaymentPage)this;
	}
}
