package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "add-to-wishlist-button-submit")
	WebElement addToWishListElement;
	@FindBy(xpath = "//i[@class='a-icon a-icon-close']")
	WebElement closePopUpBtnElement;
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	WebElement addToCartBtnElement;
	@FindBy(id = "nav-cart-count")
	WebElement cartIconElement;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void clickOnWishListButton() {
		wait.until(ExpectedConditions.visibilityOf(addToWishListElement));
		addToWishListElement.click();
	}

	public void clickOnClosePopUpButton() {
		wait.until(ExpectedConditions.visibilityOf(closePopUpBtnElement));
		closePopUpBtnElement.click();
	}

	public void clickOnAddToCartButton() {
		wait.until(ExpectedConditions.visibilityOf(addToCartBtnElement));
		addToCartBtnElement.click();
	}

	public void clickOnCartIcon() {
		wait.until(ExpectedConditions.visibilityOf(cartIconElement));
		cartIconElement.click();
	}
}
