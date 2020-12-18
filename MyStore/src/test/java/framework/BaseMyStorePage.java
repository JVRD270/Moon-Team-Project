package framework;

import org.openqa.selenium.WebDriver;

public abstract class BaseMyStorePage extends PageObjectBase{

	protected BaseMyStorePage(WebDriver driver, String url) {
		super(driver, url);
	}

}
