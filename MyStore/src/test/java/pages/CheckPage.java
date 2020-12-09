package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPage extends PaymentPage{
	
	public CheckPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public CheckPage navigate(){
		super.navigate("?fc=module&module=cheque&controller=payment");
		return this;
	}
	
	public CheckPage confirmOrder() {
		String xpath = "//span[contains(text(),'I confirm my order')]\r\n";
		WebElement proceed = driver.findElement(By.xpath(xpath));
		proceed.click();
		return this;
	}
	
}
