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
		@FindBy (xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
		WebElement dressesLink;
	
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
		
		@FindBy (xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[4]/div[1]/div[2]/div[2]/a[2]/span[1]")
        WebElement summerDress; 

        @FindBy (id = "group_1")
        WebElement sizeBar;

        @FindBy (xpath = "//span[contains(text(),'Add to cart')]")
        WebElement altAdd2Cart;

        @FindBy (id = "layer_cart_product_attributes")
        WebElement sizeMessage;


        //Created for Select Size Test 
        public AddItemPage clickSummerDress() {
        	summerDress.click();
            return this;
        }

        //Created for Select Size Test
        public AddItemPage clickYourSize() {
            sizeBar.click();
            sizeBar.sendKeys(Keys.DOWN);
            return this;
        }



        //Created for Select Size Test
        public AddItemPage addSizeToCart() {
            altAdd2Cart.click();
            return this;

        }

        //Created for Select Size Test- add explicit wait?
        public String confirmSize() {
            String size = "";
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sizeMessage));
            String message = sizeMessage.getText();
            if (message.contains(", M")) {
                 size = "M";
                return size; 
            }
            return size; 

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
		 
		 public AddItemPage goToDresses() {
             dressesLink.click();
             new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(summerDress));
             return this;
         }
		
}
