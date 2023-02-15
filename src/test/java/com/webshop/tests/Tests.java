package com.webshop.tests;

import java.util.LinkedHashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webshop.base.BaseClass;
import com.webshop.utils.KeyboardAndMouseUtils;

public class Tests extends BaseClass{

	@Test(dataProvider="getTC1Data")
	public void checkoutProduct(LinkedHashMap<String,String> map) throws InterruptedException {
		loginpage.loginLink.click();
		loginpage.doLogin(config.getProperty("email"), config.getProperty("password"));
		homepage.verifyHomePageUser(config.getProperty("email"));
		KeyboardAndMouseUtils.mouserHover(homepage.computersLink);
		
		homepage.desktopsLinks.click();
		productpage.addCartToProduct(map.get("ProductAddMsg"));
		cartpage.validateSubTotal();
		cartpage.checkOut();
		
		
		
		billingaddresspage.processCheckout(map.get("CODSuccessmsg"),map.get("ProductProcessSucessMessage"));
		cartpage.removeItemsFromCart();
		homepage.logOutButton.click();
	}
	
	
	
	@DataProvider
	public Object[][] getTC1Data(){
		return getData("TC1_Purchareproduct", "Sheet1");
	}
}
