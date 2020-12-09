package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItem {
	private String name;
	private String qty;
	
	public CartItem(WebElement cartItem, WebDriver driver) {
		this.name = cartItem.findElement(By.className("product-name")).getText();
		this.qty = cartItem.findElement(By.className("cart_quantity_input")).getAttribute("value");
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getQuantity() {
		return qty;
	}
}
