package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		String xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
//		WebElement proceed = driver.findElement(By.xpath(xpath));
		WebElement proceed = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		String checkboxXpath = "//div[@id='uniform-cgv']";
		WebElement checkbox = driver.findElement(By.xpath(checkboxXpath)).findElement(By.cssSelector("span"));
		System.out.println("Shipping Page");
		checkbox.click();
		proceed.click();
		return new PaymentPage(driver, baseUrl);
	}
}
