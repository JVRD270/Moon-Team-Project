package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class AddToWishlistPage extends PageObjectBase{
	
	public AddToWishlistPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public AddToWishlistPage navigate() {
		super.navigate("");
		return this;
	}
	
	public AddToWishlistPage addToWishlist() {
		SignInPage sip = new SignInPage(driver, baseUrl);
		sip.navigate().sendEmailInput("butt@gmail.com").sendPassInput("butts").submitCredentials();
		
		super.navigate("");
		
		String xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/a[1]/img[1]";
		WebElement dress = driver.findElement(By.xpath(xpath));
		dress.click();
		
		WebElement wishlist = //driver.findElement(By.id("wishlist_button"));
				new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("wishlist_button")));
		wishlist.click();
		
		return this;
	}
	
	public String checkWishList() {
		WebElement customerAccount = driver.findElement(By.xpath("//span[contains(text(),'Yuri Nader')]"));
		customerAccount.click();
		WebElement myWishlistSpan = driver.findElement(By.xpath("//span[contains(text(),'My wishlists')]"));
		myWishlistSpan.click();
		WebElement myWishlistLink = driver.findElement(By.xpath("//a[contains(text(),'My wishlist')]"));
		myWishlistLink.click();
		
		WebElement title =// driver.findElement(By.id("s_title"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("s_title")));
		
		return title.getText();
		
	}
}
