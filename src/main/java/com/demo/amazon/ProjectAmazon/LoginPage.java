package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath = "//h1[contains(text(),'Sign in or create account')]")
	WebElement headerTxtElement;
	@FindBy(id = "ap_email_login")
	WebElement mobileTxtElement;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtnElement;
	@FindBy(id = "ap_password")
	WebElement passwordTxtElement;
	@FindBy(id = "auth-signin-button")
	WebElement signInBtnElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginHeader() {

		UtilityClass.waitToLoad(1000);
		return headerTxtElement.getText();
	}

	public void enterMobileOrEmail(String mobOrEmail) {
		mobileTxtElement.sendKeys(mobOrEmail);
		UtilityClass.waitToLoad(1000);

	}

	public void enterPassword(String password) {
		passwordTxtElement.sendKeys(password);
		UtilityClass.waitToLoad(2000);

	}

	public void clickContinueButton() {
		continueBtnElement.click();
		UtilityClass.waitToLoad(1000);

	}

	public void clickSignInButton() {
		signInBtnElement.click();
		UtilityClass.waitToLoad(3000);

	}

}
