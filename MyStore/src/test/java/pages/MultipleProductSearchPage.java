package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.PageObjectBase;

public class MultipleProductSearchPage extends PageObjectBase {
	
	public  MultipleProductSearchPage(WebDriver driver, String url) {
		super(driver, url);
}
	
	      //Web elements:
	
	      @FindBy (css = "#search_query_top")
	      WebElement theSearchBox; 
	      
	      @FindBy (xpath = "//form[@id='searchbox']//button[@type='submit']")
	      WebElement theSearchBttn; 
	      
	      @FindBy (xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line hovered']//div[@class='product-container']//div[@class='left-block']//div[@class='product-image-container']")
	      WebElement yellowDress;  
	      
	      @FindBy (xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line hovered']//div[@class='product-container']//div[@class='right-block']//h5[@itemprop='name']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]")
	      WebElement dressTxt; 
	      
	      @FindBy (xpath = "//img[@class='logo img-responsive']")
	      WebElement returnToHome; 
	    
	      @FindBy (xpath = "//div[@class='product-image-container']")
	      WebElement tShirt; 
	      
	      @FindBy (xpath = "//h5[@itemprop='name']//a[@class='product-name'][contains(text(),'Faded Short Sleeve T-shirts')]")
	      WebElement tShirtTxt;
	      
	
	
	        //Create method to navigate page: 
			public MultipleProductSearchPage navigate() {
				super.navigate("");
				return this;
			}
			
			
			//search for "yellow dress":
			public MultipleProductSearchPage searchYellowDress() {
				 theSearchBox.click();
				 theSearchBox.sendKeys("yellow dress");
			     theSearchBttn.click();
				return this;
            }

            //verify dress in search result 
			public String verifyDressResult() {
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(yellowDress));
		        String dress = dressTxt.toString();
		        returnToHome.click();
				return dress;
			}
			
			//search for t-shirt:
			public MultipleProductSearchPage searchShirt() {
				 theSearchBox.click();
				 theSearchBox.sendKeys("t-shirt");
			     theSearchBttn.click();
				return this;
           }
			
			 //verify dress in search result 
			public String verifyShirtResult() {
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(tShirt));
		        String shirt = tShirtTxt.toString();
		        returnToHome.click();
				return shirt;
			}
}
			
			
