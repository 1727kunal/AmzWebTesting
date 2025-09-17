package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDetailsPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceedToBuyBtnElement;
	@FindBy(xpath = "(//div[@class='a-row sc-action-links']/child::span[@data-action='delete-active'])[1]")
	WebElement deleteBtnElement;

	public CartDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnProceedToBuyButton() {
		wait.until(ExpectedConditions.visibilityOf(proceedToBuyBtnElement));
		proceedToBuyBtnElement.click();
	}

	public void clickOnDeleteItemButton() {
		wait.until(ExpectedConditions.visibilityOf(deleteBtnElement));
		deleteBtnElement.click();
	}
}
