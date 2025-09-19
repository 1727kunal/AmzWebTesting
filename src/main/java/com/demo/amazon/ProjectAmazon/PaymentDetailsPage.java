package com.demo.amazon.ProjectAmazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDetailsPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//input[@type='radio' and @value='SelectableAddCreditCard']")
	WebElement cardRadioElement;
	@FindBy(partialLinkText = "Add a new credit or debit card")
	WebElement addNewCardElement;
	@FindBy(xpath = "(//div[@class='a-fixed-left-grid-col a-col-right'])[6]/child::iframe")
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
	}

	public void clickOnAddNewCardLink() {
		wait.until(ExpectedConditions.visibilityOf(addNewCardElement));
		addNewCardElement.click();
	}

	public void enterCreditCardNumber(String cardNum) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameElement));
		wait.until(ExpectedConditions.visibilityOf(creditCardTxtElement));
		creditCardTxtElement.sendKeys(cardNum);
	}
}
