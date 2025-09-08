package com.demo.amazon.ProjectAmazon;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	public static void waitToLoad(long miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollPageVertically(WebDriver driver, long scrollAmt) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + scrollAmt + ")");
	}
}
