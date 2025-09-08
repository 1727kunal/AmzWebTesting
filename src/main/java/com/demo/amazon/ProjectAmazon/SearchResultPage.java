package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SearchResultPage {
	WebDriver driver;
	@FindBy(xpath = "//h2[contains(@aria-label,'Sponsored Ad - iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black')]")
	WebElement selectedProductElement;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTheProduct() {
		selectedProductElement.click();
		Reporter.log("Clicked on the product...");
		UtilityClass.waitToLoad(5000);
	}

}
