package com.demo.amazon.ProjectAmazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmzAddToCartToPayment extends BaseClass {
	HomePage objHomePage;
	LoginPage objLoginPage;
	SearchResultPage objSearchResultPage;
	ProductDetailsPage objProductDetailsPage;
	CartDetailsPage objCartDetailsPage;
	PaymentDetailsPage objPaymentDetailsPage;

	@Test
	void verifyCheckoutProcess() {
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);
		objSearchResultPage = new SearchResultPage(driver);
		objProductDetailsPage = new ProductDetailsPage(driver);
		objCartDetailsPage = new CartDetailsPage(driver);
		objPaymentDetailsPage = new PaymentDetailsPage(driver);

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

		objHomePage.performSearch("xiaomi");
		Reporter.log("Searched for product xiaomi...");
		UtilityClass.scrollPageVertically(driver, 500);

		objSearchResultPage.clickOnTheProduct();
		Reporter.log("Clicked on 1st product from search result...");

		Set<String> allHandlesSet = driver.getWindowHandles();
		List<String> allHandlesList = new LinkedList<>(allHandlesSet);
//		String parentWindowString = allHandlesList.get(0);
		String productWindowString = allHandlesList.get(1);
		driver.switchTo().window(productWindowString);
		UtilityClass.waitToLoad(2000);
		UtilityClass.scrollPageVertically(driver, 600);
		objProductDetailsPage.clickOnAddToCartButton();
		UtilityClass.waitToLoad(2000);
		driver.navigate().refresh();
		UtilityClass.scrollPageVertically(driver, -600);
		objProductDetailsPage.clickOnCartIcon();
		objCartDetailsPage.clickOnProceedToBuyButton();
		Reporter.log("Clicked on Proceed To Buy button...");

		UtilityClass.scrollPageVertically(driver, 600);
		objPaymentDetailsPage.clickOnCardRadioButton();
		Reporter.log("Clicked on the Card Radio Button...");
		UtilityClass.waitToLoad(1000);
		objPaymentDetailsPage.clickOnAddNewCardLink();
		Reporter.log("Clicked on the Add New Card Link...");
		UtilityClass.waitToLoad(2000);
		objPaymentDetailsPage.enterCreditCardNumber("1111222233334444");
		Reporter.log("Credit card number entered...");
		UtilityClass.waitToLoad(1000);
	}
}
