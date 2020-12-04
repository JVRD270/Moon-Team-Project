package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankWirePage extends PaymentPage{
	
	public BankWirePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public BankWirePage navigate(){
		super.navigate("?fc=module&module=bankwire&controller=payment");
		return this;
	}
	
	public BankWirePage confirmOrder() {
		String xpath = "//span[contains(text(),'I confirm my order')]\r\n";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return this;
	}
	
}
