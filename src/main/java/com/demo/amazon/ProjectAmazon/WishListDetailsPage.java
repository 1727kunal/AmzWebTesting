package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListDetailsPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
	WebElement addToCartBtnElement;

	public WishListDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCartButton() {
		addToCartBtnElement.click();
		UtilityClass.waitToLoad(2000);
	}
}
