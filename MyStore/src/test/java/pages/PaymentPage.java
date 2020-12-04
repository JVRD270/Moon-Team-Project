package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("Payment Page");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceed));
		proceed.click();
		return new BankWirePage(driver, baseUrl);
	}
	
	//Make this CheckPage
	public PaymentPage PayByCheck(){
		String xpath = "//a[@class='cheque']";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceed));
		proceed.click();
		return this;
	}
}
