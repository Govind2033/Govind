package com.webshop.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//a[text()='Log in']")
	public WebElement loginLink;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailText;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordText;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String userName,String password) {
		try {
			emailText.sendKeys(userName);
			passwordText.sendKeys(password);
			loginbtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
