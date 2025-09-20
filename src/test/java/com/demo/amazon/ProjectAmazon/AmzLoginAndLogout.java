package com.demo.amazon.ProjectAmazon;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmzLoginAndLogout extends BaseClass {
	HomePage objHomePage;
	LoginPage objLoginPage;

	@Test
	void performLoginAndLogout() {
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);

		objHomePage.moveToAccountsTab();
//		Reporter.log("Moved to Accounts and List...");
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

		objHomePage.moveToAccountsTab();
		Reporter.log("Moved to Accounts and List...");
		objHomePage.clickSignOutBtn();
		Reporter.log("Clicked on Sign Out button...");
	}

}
