package com.webshop.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webshop.base.BaseClass;

public class CartPage1 extends BaseClass {

	@FindBy(xpath="//input[@name='removefromcart']")
	WebElement removeCheckBox;
	
	@FindBy(xpath="//input[@name='termsofservice']")
	WebElement termsOfServiceChck;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	public WebElement shoppingCartlink;
	
	@FindBy(xpath="//input[@name='updatecart']")
	WebElement updateProductLink;
	
	@FindBy(xpath="//span[text()='Sub-Total:']/following::span[1]")
	WebElement subTotallabel;
	
	@FindBy(xpath="//span[@class='product-unit-price']")
	WebElement unitPriceCol;
	
	@FindBy(xpath="//input[@class='qty-input']")
	WebElement quantityText;

	
	public CartPage1() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * This function removes product from cart
	 * 
	 * 
	 */
	public void removeItemsFromCart() {
		shoppingCartlink.click();
		removeCheckBox.click();
		updateProductLink.click();
	}
	
	/*
	 * This function starts checkout process
	 * 
	 */
	public void checkOut() {
		shoppingCartlink.click();
		removeCheckBox.click();
		
		termsOfServiceChck.click();
		checkoutButton.click();
		
	}
	
	/*
	 * This function validates sub total from cart page
	 * 
	 */
	public void validateSubTotal() throws InterruptedException {
		Thread.sleep(3000);
		shoppingCartlink.click();
		String price=unitPriceCol.getText();
		double unitprc=Double.parseDouble(price);
		
		String quantity=quantityText.getAttribute("value");
		System.out.println(quantity);
		int qty=Integer.parseInt(quantity);
		
		double expSubtotal=unitprc*qty;
		
		String subTotalValue=subTotallabel.getText();
		double subTotal=Double.parseDouble(subTotalValue);
		
		Assert.assertEquals(subTotal, expSubtotal);
	}
	
	public void removeProduct() {
		shoppingCartlink.click();
		updateProductLink.click();
	}
	

}
