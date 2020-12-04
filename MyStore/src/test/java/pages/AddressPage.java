package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends ShoppingCartPage{
	public AddressPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public AddressPage navigate(){
		super.navigate("?controller=order&step=1&multi-shipping=0");
		return this;
	}
	
	public ShippingPage proceedToCheckOut(){
		System.out.println("Address Page");
		String xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceed));
		proceed.click();
		return new ShippingPage(driver, baseUrl);
	}
}
