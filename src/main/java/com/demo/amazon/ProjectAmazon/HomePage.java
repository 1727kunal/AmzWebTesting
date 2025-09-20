package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[@data-nav-role='signin']")
	WebElement tabAccountsAndListsElement;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTxtElement;
	@FindBy(xpath = "(//span[text()='Sign in'])[1]")
	WebElement signInBtnElement;
	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signOutBtnElement;
	@FindBy(xpath = "//a[@class='nav-link nav-item']/span[text()='Your Wish List']")
	WebElement yourWishlistElement;
	@FindBy(id = "nav-cart-count")
	WebElement cartCountElement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void moveToAccountsTab() {
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(tabAccountsAndListsElement));
		act.moveToElement(tabAccountsAndListsElement).perform();
		Reporter.log("Moved to Accounts and List...");
	}

	public void clickSignInBtn() {
		wait.until(ExpectedConditions.visibilityOf(signInBtnElement));
		signInBtnElement.click();
	}

	public void performSearch(String searchValue) {
		wait.until(ExpectedConditions.visibilityOf(searchTxtElement));
		searchTxtElement.sendKeys(searchValue + Keys.ENTER);
	}

	public void clickYourWishlistButton() {
		wait.until(ExpectedConditions.visibilityOf(yourWishlistElement));
		yourWishlistElement.click();
	}

	public void clickSignOutBtn() {
		wait.until(ExpectedConditions.visibilityOf(signOutBtnElement));
		signOutBtnElement.click();
	}

	public int productInCarts() {
		wait.until(ExpectedConditions.visibilityOf(cartCountElement));
		return Integer.parseInt(cartCountElement.getText());
	}
}
