package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PaymentDetailsPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//input[@type='radio' and @value='SelectableAddCreditCard']")
	WebElement cardRadioElement;
	@FindBy(partialLinkText = "Add a new credit or debit card")
	WebElement addNewCardElement;
	@FindBy(xpath = "(//div[@class='a-fixed-left-grid-col a-col-right'])[5]/child::iframe")
	WebElement paymentFrameElement;
	@FindBy(name = "addCreditCardNumber")
	WebElement creditCardTxtElement;

	public PaymentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnCardRadioButton() {
		wait.until(ExpectedConditions.visibilityOf(cardRadioElement));
		cardRadioElement.click();
		Reporter.log("Clicked on the Card Radio Button...");
	}

	public void clickOnAddNewCardLink() {
		wait.until(ExpectedConditions.visibilityOf(addNewCardElement));
		addNewCardElement.click();
		Reporter.log("Clicked on the Add New Card Link...");
	}

	public void enterCreditCardNumber(String cardNum) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameElement));
		Reporter.log("Switched to Credit Card Details frame...");
		wait.until(ExpectedConditions.visibilityOf(creditCardTxtElement));
		creditCardTxtElement.sendKeys(cardNum);
		Reporter.log("Credit card number entered...");
	}
}
