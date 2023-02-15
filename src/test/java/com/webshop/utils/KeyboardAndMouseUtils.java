package com.webshop.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webshop.base.BaseClass;

public class KeyboardAndMouseUtils extends BaseClass{

	public static Actions a;
	
	public static void mouserHover(WebElement ele) {		
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
}
