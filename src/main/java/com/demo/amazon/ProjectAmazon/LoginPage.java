package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String getLoginHeader() {
		wait.until(ExpectedConditions.visibilityOf(headerTxtElement));
		return headerTxtElement.getText();
	}

	public void enterMobileOrEmail(String mobOrEmail) {
		wait.until(ExpectedConditions.visibilityOf(mobileTxtElement));
		mobileTxtElement.sendKeys(mobOrEmail);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordTxtElement));
		passwordTxtElement.sendKeys(password);
	}

	public void clickContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(continueBtnElement));
		continueBtnElement.click();
	}

	public void clickSignInButton() {
		wait.until(ExpectedConditions.visibilityOf(signInBtnElement));
		signInBtnElement.click();
	}
}
