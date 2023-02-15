package com.webshop.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webshop.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="(//a[@href='/customer/info'])[1]")
	WebElement userAccountLabel;
	
	@FindBy(xpath="(//a[@href='/computers'])[1]")
	public WebElement computersLink;
	
	@FindBy(xpath="(//a[@href='/desktops'])[1]")
	public WebElement desktopsLinks;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	public WebElement logOutButton;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * This function verifies user from home page
	 * 
	 */
	public void verifyHomePageUser(String expectedMail) {
		try {
			String actualEmailText=userAccountLabel.getText();
			Assert.assertEquals(actualEmailText, expectedMail);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}   
	
	public void gotoProductPage() {
		desktopsLinks.click();
	}
	
	
	
	
	
	public void doLogout() {
		logOutButton.click();
	}
	
	
}
