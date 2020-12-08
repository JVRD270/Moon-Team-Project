package pages;

import org.openqa.selenium.Keys;
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
		
		@FindBy (css = "div#layered_price_slider a:nth-child(0)")
		WebElement priceBar;
		
		@FindBy (xpath = "//p[text()[contains(.,'Loading...')]]")
		WebElement load; 
		
		
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
		 


			//Click price range and set
		    //click right arrow x 5 ($17.85)
			public AddItemPage clickAndSetPriceRange(double minPrice) {
				
				priceBar.click();
				
				int numberOfSteps = (int) Math.abs((minPrice - 16.00)/0.34);
			  
				for(int i=1;i<=numberOfSteps;i++) {
	                priceBar.sendKeys(Keys.ARROW_RIGHT);
	            }
				
				priceBar.sendKeys(Keys.ENTER);
				
				return this;
			}
			
			
		 
			//wait for page to stop loading 
			public AddItemPage waitForPageLoad() {
				
				try {
					
					new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(load));
					
				} catch (Exception e) { 
					
				   System.out.println( e ); 
					
				}
				
				
				return this;
			}
		 
		 
		
}
