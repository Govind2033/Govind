package com.webshop.pages.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webshop.base.BaseClass;

public class ProductPage extends BaseClass{

	
	@FindBy(xpath="//img[@alt='Picture of Build your own cheap computer']")
	WebElement addToKartLink;
	
	@FindBy(xpath="//input[@class='qty-input']")
	WebElement quantityText;
	
	@FindBy(xpath="//input[@class='qty-input']/following::input[1]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//p[text()='The product has been added to your ']")
	WebElement productAddedMsg;
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addCartToProduct(String successmsg) throws InterruptedException {
		
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", addToKartLink);
		addToKartLink.click();
		Thread.sleep(5000);
		quantityText.clear();
		quantityText.sendKeys("2");
		addToCartButton.click();
		
		String actualProductAddMsg=productAddedMsg.getText();
		Assert.assertEquals(actualProductAddMsg, successmsg);
		Thread.sleep(10000);
		
	}

}
