package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class AddItemPage extends PageObjectBase {
	
	public AddItemPage(WebDriver driver, String url) {
		super(driver, url);
	}
		@FindBy (xpath = "//input[@id='search_query_top']")
		WebElement searchBox; 
		
		@FindBy (xpath = "//form[@id='searchbox']//button[@type='submit']")
		WebElement submitBttn; 
		
		@FindBy (xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']//div[@class='left-block']//div[@class='product-image-container']//a[@class='product_img_link']//img[@class='replace-2x img-responsive'] ")
		WebElement firstDress;
		
		@FindBy (xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']//div[@class='right-block']//div[@class='button-container']//a[@class='button ajax_add_to_cart_button btn btn-default']//span[contains(text(),'Add to cart')]")
		WebElement add2CartBttn;
		
		@FindBy (xpath = "//span[contains(text(),'Proceed to checkout')] ")
		WebElement proceedCheckout; 
		
		@FindBy (xpath = "//td[@class='cart_description']//p[@class='product-name']//a[contains(text(),'Printed Summer Dress')]")
		WebElement dressInCart;
		
		@FindBy (xpath = "//span[text()[contains(.,'More')]]")
		WebElement moreButton;
		
		
		public AddItemPage addMultiple(int numberToAdd) {
			Actions actions = new Actions(driver);
			actions.moveToElement(firstDress).perform();
			moreButton.click();
			WebElement addDuplicatesButton = driver.findElement(By.className("icon-plus"));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addDuplicatesButton));
			for (int i=1; i < numberToAdd; i++) {
				addDuplicatesButton.click();
			}
			driver.findElement(By.id("add_to_cart")).click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceedCheckout));
			return this;
		}
		
		
		//2) Create method to navigate page: 
		public AddItemPage navigate() {
			super.navigate("");
			return this;
		}
		
		
		public AddItemPage searchForDress() {
			searchBox.sendKeys("dress");
			submitBttn.click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(firstDress));
			return this;
			
		}
		
		public AddItemPage addFirstDress() {
			Actions actions = new Actions(driver);
			actions.moveToElement(firstDress).perform();
			add2CartBttn.click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceedCheckout));
			return this;
		}
		
		public AddItemPage proceedToCheckout() {
	    proceedCheckout.click();
		return this;
		}
		
		
		 public String getItemTextFromCart() {
		    	
		        String cartItem = dressInCart.getText();
		 		
		 		System.out.print("THIS MESSAGE SAYS: " + cartItem);
		 		
		 	   return cartItem; 
		 }
		
}
