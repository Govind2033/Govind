package com.webshop.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webshop.base.BaseClass;
import com.webshop.utils.WaitUtils;

public class ProductPage extends BaseClass{

	
	@FindBy(xpath="//a[text()='Build your own cheap computer']")
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
		
		addToKartLink.click();
		Thread.sleep(10000);
		quantityText.clear();
		quantityText.sendKeys("2");
		addToCartButton.click();
		
		String actualProductAddMsg=productAddedMsg.getText();
		Assert.assertEquals(actualProductAddMsg, successmsg);
		Thread.sleep(15000);
		
	}

}
