package com.webshop.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.webshop.pages.objects.BillingAddressPage;
import com.webshop.pages.objects.CartPage1;
import com.webshop.pages.objects.HomePage;
import com.webshop.pages.objects.LoginPage;
import com.webshop.pages.objects.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public CartPage1 cartpage;
	public ProductPage productpage;
	public BillingAddressPage billingaddresspage;

	public static Properties config;
	
	public static FileInputStream f;
	private static XSSFWorkbook w;
	private static XSSFSheet s;
	private static XSSFRow r;
	private static XSSFCell c;
	
	public static void setup(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(readProperty("QaUrl"));
	}
	
	public static String readProperty(String prop) {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.property");;
			config=new Properties();
			config.load(f);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return config.getProperty(prop);
	}
	
	public static void main(String[] args) {
		System.out.println(readProperty("email"));
		getData("TC1","Sheet1");
	}
	
	@BeforeMethod
	public void openAppAndInitPages() {
		setup("chrome");
		loginpage=new LoginPage();
		homepage=new HomePage();
		cartpage=new CartPage1();
		productpage=new ProductPage();
		billingaddresspage=new BillingAddressPage();
	}
	
	//@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	public static String getCellValue(String sheetName,int rowNum,int colNum) {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/WebShopData.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] getData(String tcName,String sheetName){
		int tcStartRow=0;
		
		while(!getCellValue(sheetName,tcStartRow,0).equals(tcName)) {

			tcStartRow++;
		}
		
		System.out.println(tcStartRow);
		
		int colsStartRow=tcStartRow+1;
		int cols=0;
		while(!getCellValue(sheetName, colsStartRow, cols).equals("N")) {
			//System.out.println(cols);
			cols++;
		}
		System.out.println(cols);
		
		int rows=0;
		int dataStartRow=tcStartRow+2;
		
		while(!getCellValue(sheetName, dataStartRow+rows, 0).equals("N")) {
			rows++;
		}
		System.out.println(rows);
		
		Object[][] data=new Object[rows][1];
		LinkedHashMap<String,String> dataMap;
		int index=0;
		for(int i=dataStartRow;i<dataStartRow+rows;i++) {
			dataMap=new LinkedHashMap();
			for(int j=0;j<cols;j++) {
				String key=getCellValue(sheetName, colsStartRow, j);
				String value=getCellValue(sheetName, i, j);
				dataMap.put(key, value);
				System.out.println(getCellValue(sheetName, i, j));
			}
			data[index][0]=dataMap;
			index++;
		}
		return data;
	}
	
}
