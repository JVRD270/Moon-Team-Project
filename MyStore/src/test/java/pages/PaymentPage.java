package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends ShippingPage{
	public PaymentPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public PaymentPage navigate(){
		super.navigate("?controller=order&multi-shipping=");
		return this;
	}
	
	public BankWirePage PayByBankWire(){
		String xpath = "//a[@class='bankwire']";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return (BankWirePage)this;
	}
	
	//Make this CheckPage
	public PaymentPage PayByCheck(){
		String xpath = "//a[@class='cheque']";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return this;
	}
}
