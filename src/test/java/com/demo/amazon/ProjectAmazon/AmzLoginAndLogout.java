package com.demo.amazon.ProjectAmazon;

import org.testng.annotations.Test;

public class AmzLoginAndLogout extends BaseClass {
	HomePage objHomePage;
	LoginPage objLoginPage;

	@Test
	void performLoginAndLogout() {
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);

		objHomePage.moveToAccountsTab();
		objHomePage.clickSignInBtn();

		objLoginPage.enterMobileOrEmail("7264811720");
		objLoginPage.clickContinueButton();
		objLoginPage.enterPassword("1163kunal1727");
		objLoginPage.clickSignInButton();

		objHomePage.moveToAccountsTab();
		objHomePage.clickSignOutBtn();
	}

}
