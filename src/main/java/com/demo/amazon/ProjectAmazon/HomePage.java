package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

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
	}

	public void moveToAccountsTab() {
		Actions act = new Actions(driver);
		act.moveToElement(tabAccountsAndListsElement).perform();
		UtilityClass.waitToLoad(2000);
	}

	public void clickSignInBtn() {
		signInBtnElement.click();
		UtilityClass.waitToLoad(2000);
	}

	public void performSearch(String searchValue) {
		searchTxtElement.sendKeys(searchValue + Keys.ENTER);
		UtilityClass.waitToLoad(2000);
	}

	public void clickYourWishlistButton() {
		yourWishlistElement.click();
		UtilityClass.waitToLoad(2000);
	}

	public void clickSignOutBtn() {
		signOutBtnElement.click();
		UtilityClass.waitToLoad(1000);
	}

	public int productInCarts() {
		UtilityClass.waitToLoad(2000);
		return Integer.parseInt(cartCountElement.getText());
	}
}
