package com.webshop.utils;
import org.openqa.selenium.Alert;

import com.webshop.base.BaseClass;

public class AlertUtils extends BaseClass {

	public static Alert a;
	
	public void alertForPositiveAction() {
		a=driver.switchTo().alert();
		a.accept();
	}
	
	public static void alertForNagativeAction() {
		a=driver.switchTo().alert();
		a.dismiss();
	}
}
