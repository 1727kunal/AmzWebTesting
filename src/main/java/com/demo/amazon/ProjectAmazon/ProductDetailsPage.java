package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductDetailsPage {
	WebDriver driver;

	@FindBy(id = "add-to-wishlist-button-submit")
	WebElement addToWishListElement;
	@FindBy(xpath = "//i[@class='a-icon a-icon-close']")
	WebElement closePopUpBtnElement;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnWishListButton() {
		addToWishListElement.click();
		Reporter.log("Clicked on Add To WishList Button...");
		UtilityClass.waitToLoad(5000);
	}

	public void clickOnClosePopUpButton() {
		closePopUpBtnElement.click();
		Reporter.log("Pop-up closed...");
		UtilityClass.waitToLoad(2000);
	}

}
