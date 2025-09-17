package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CartDetailsPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceedToBuyBtnElement;

	public CartDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnProceedToBuyButton() {
		wait.until(ExpectedConditions.visibilityOf(proceedToBuyBtnElement));
		proceedToBuyBtnElement.click();
		Reporter.log("Clicked on Proceed To Buy button...");
	}

}
