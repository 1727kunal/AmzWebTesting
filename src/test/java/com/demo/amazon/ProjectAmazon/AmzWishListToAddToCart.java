package com.demo.amazon.ProjectAmazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmzWishListToAddToCart extends BaseClass {
	HomePage objHomePage;
	LoginPage objLoginPage;
	SearchResultPage objSearchResultPage;
	ProductDetailsPage objProductDetailsPage;
	WishListDetailsPage objWishListDetailsPage;

	@Test
	void fromAddToWishListToAddToCart() {
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);
		objSearchResultPage = new SearchResultPage(driver);
		objProductDetailsPage = new ProductDetailsPage(driver);
		objWishListDetailsPage = new WishListDetailsPage(driver);

		objHomePage.moveToAccountsTab();
		Reporter.log("Moved to Accounts and List...");
		objHomePage.clickSignInBtn();
		Reporter.log("Clicked on Sign In button...");

		objLoginPage.enterMobileOrEmail("7264811720");
		Reporter.log("Mobile number entered...");
		objLoginPage.clickContinueButton();
		Reporter.log("Clicked on Continue button...");
		objLoginPage.enterPassword("1163kunal1727");
		Reporter.log("Password entered...");
		objLoginPage.clickSignInButton();
		Reporter.log("Clicked on Sign In button...");

		objHomePage.performSearch("iphone");
		Reporter.log("Searched for product iPhone...");
		UtilityClass.scrollPageVertically(driver, 400);

		objSearchResultPage.clickOnTheProduct();
		Reporter.log("Clicked on 1st product from search result...");

		Set<String> allHandlesSet = driver.getWindowHandles();
		List<String> allHandlesList = new LinkedList<String>(allHandlesSet);
		String parentWindowString = allHandlesList.get(0);
		String productWindowString = allHandlesList.get(1);
		driver.switchTo().window(productWindowString);
		UtilityClass.scrollPageVertically(driver, 600);
		objProductDetailsPage.clickOnWishListButton();
		Reporter.log("Clicked on Add To Wish List button...");
		objProductDetailsPage.clickOnClosePopUpButton();
		Reporter.log("Pop-up closed...");
		UtilityClass.waitToLoad(2000);
		driver.close();
		UtilityClass.waitToLoad(1000);
		driver.switchTo().window(parentWindowString);
		driver.navigate().refresh();
		UtilityClass.scrollPageVertically(driver, -400);

		objHomePage.moveToAccountsTab();
		Reporter.log("Moved to Accounts and List...");

		objHomePage.clickYourWishlistButton();
		Reporter.log("Clicked on Your Wish List button...");

		objWishListDetailsPage.clickOnAddToCartButton();
		Reporter.log("Clicked on Add To Cart button...");

		Assert.assertEquals(objHomePage.productInCarts() > 0, true);

		objHomePage.moveToAccountsTab();
		objHomePage.clickSignOutBtn();

	}

}
