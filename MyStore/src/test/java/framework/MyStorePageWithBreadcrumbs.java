package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MyStorePageWithBreadcrumbs extends BaseMyStorePage{

	protected MyStorePageWithBreadcrumbs(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy (className = "breadcrumb")
	WebElement breadcrumbDiv;

	public BaseMyStorePage clickHomeBreadcrumb() {
		return clickBreadcrumbWithTitle("Return to Home");
	}
	
	public BaseMyStorePage clickBreadcrumbWithTitle(String title) {
		List<WebElement> allBreadcrumbLinks = breadcrumbDiv.findElements(By.tagName("a"));
		for(WebElement breadcrumbLink : allBreadcrumbLinks) {
			String breadcrumbLinkTitle = breadcrumbLink.getAttribute("title");
			if(breadcrumbLinkTitle == null)
				continue;
			if(breadcrumbLinkTitle.equals(title)) {
				breadcrumbLink.click();
				return BreadcrumbPageFactory.getPageByTitle(title);
			}
		}
		System.err.println("Couldn't find breadcrumb link with title: " + title);
		return this;
	}
	
	
}
