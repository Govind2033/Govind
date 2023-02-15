package com.webshop.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webshop.base.BaseClass;

public class WaitUtils extends BaseClass{

	public static WebDriverWait wait;
	
	public static void waitForElementToLocate(WebElement ele) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void elementClickable(WebElement ele) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	
}
