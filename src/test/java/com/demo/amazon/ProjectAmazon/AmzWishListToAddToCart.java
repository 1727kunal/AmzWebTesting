package com.demo.amazon.ProjectAmazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
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
		objHomePage.clickSignInBtn();

		objLoginPage.enterMobileOrEmail("7264811720");
		objLoginPage.clickContinueButton();
		objLoginPage.enterPassword("1163kunal1727");
		objLoginPage.clickSignInButton();

		objHomePage.performSearch("iphone");
		UtilityClass.scrollPageVertically(driver, 400);

		objSearchResultPage.clickOnTheProduct();

		Set<String> allHandlesSet = driver.getWindowHandles();
		List<String> allHandlesList = new LinkedList<String>(allHandlesSet);
		String parentWindowString = allHandlesList.get(0);
		String productWindowString = allHandlesList.get(1);
		driver.switchTo().window(productWindowString);
		UtilityClass.scrollPageVertically(driver, 600);
		objProductDetailsPage.clickOnWishListButton();
		objProductDetailsPage.clickOnClosePopUpButton();
		UtilityClass.waitToLoad(2000);
		driver.close();
		UtilityClass.waitToLoad(1000);
		driver.switchTo().window(parentWindowString);
		driver.navigate().refresh();
		UtilityClass.scrollPageVertically(driver, -400);

		objHomePage.moveToAccountsTab();
		objHomePage.clickYourWishlistButton();

		objWishListDetailsPage.clickOnAddToCartButton();

		Assert.assertEquals(objHomePage.productInCarts() > 0, true);

		objHomePage.moveToAccountsTab();
		objHomePage.clickSignOutBtn();

	}

}
