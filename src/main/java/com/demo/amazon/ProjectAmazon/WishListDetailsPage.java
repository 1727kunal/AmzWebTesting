package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListDetailsPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
	WebElement addToCartBtnElement;

	public WishListDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnAddToCartButton() {
		wait.until(ExpectedConditions.visibilityOf(addToCartBtnElement));
		addToCartBtnElement.click();
	}
}
