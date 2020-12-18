package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.BaseMyStorePage;
import framework.TestBase;
import pages.AddItemPage;
import pages.SignInPage;

public class CanUtilizeBreadcrumbs extends TestBase{
	@Test
	public void tc1CanUtilizeBreadcrumbs() {
		String expectedPageTitle = "My Store";
		new AddItemPage(webDriver, baseUrl).navigate()
        .goToDresses()
        .clickSummerDress()
        .clickHomeBreadcrumb();
		
		
		// Is there a better way to check for signing in?
		String currentPageTitle = webDriver.getTitle();
		Assert.assertEquals(currentPageTitle, expectedPageTitle);
	}
}
