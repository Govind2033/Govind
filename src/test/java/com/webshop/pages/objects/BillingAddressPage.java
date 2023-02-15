package com.webshop.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.webshop.base.BaseClass;

public class BillingAddressPage extends BaseClass {
	@FindBy(xpath="//select[@fdprocessedid='vmswex']")
	WebElement countryDropdown;
	
	@FindBy(xpath="//select[@fdprocessedid='urlgjr']")
	WebElement stateDropdown;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement cityText;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	WebElement billingAddress1;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address2']")
	WebElement billingAddress2;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement zipText;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement phoneNumberText;
	
	@FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[1]")
	WebElement continueButton1;
	
	@FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[2]")
	WebElement continueButton2;
	
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	WebElement continueButton3;
	
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	WebElement continueButton4;
	
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
	WebElement continueButton5;
	
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
	WebElement confirmButton;
	
	@FindBy(xpath="//span[text()='Sub-Total:']/following::span[2]")
	WebElement subtotal;
	
	@FindBy(xpath="//label[text()='Next Day Air (0.00)']/preceding::input[1]")
	WebElement nextDayByAir;
	
	@FindBy(xpath="//p[text()='You will pay by COD']")
	WebElement payByCOD;
	
	@FindBy(xpath="//strong[text()='Your order has been successfully processed!']")
	WebElement successprocessmsg;
	
	@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
	WebElement continueButton6;
	public BillingAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * This function creates billing address
	 * 
	 */
	public void createBillingaddress(String country,String state,String billAdd1,String billAdd2,String zip,String phNum) {
		new Select(stateDropdown).selectByVisibleText(country);
		//new Select(stateDropdown).selectByVisibleText(state);
		billingAddress1.sendKeys(billAdd1);
		billingAddress2.sendKeys(billAdd2);
		zipText.sendKeys(zip);
		phoneNumberText.sendKeys(phNum);
	}
	
	/*
	 * This function completes checkout process
	 * 
	 */
	public void processCheckout(String expectedPayMessage,String expectedSuccessmsg) {

		continueButton1.click();
		continueButton2.click();
		nextDayByAir.click();
		continueButton3.click();
		continueButton4.click();
		String payMessage=payByCOD.getText();
		Assert.assertEquals(payMessage, expectedPayMessage);
		continueButton5.click();
		confirmButton.click();
		String actualSuccesmessage=successprocessmsg.getText();
		Assert.assertEquals(actualSuccesmessage, expectedSuccessmsg);
		continueButton6.click();
	}
	
	}
