package demoBlaze;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genUtility.BaseClass;
import genUtility.ExcelUtil;
import objRepo.DemoSignUpPage;
import objRepo.DemoAddtoCartPageTest;
import objRepo.DemoCartPage;
import objRepo.DemoConfirmationPage;
import objRepo.DemoHomePage;
import objRepo.DemoLoginPage;
import objRepo.DemoPlaceOrder;

@Listeners(listenerUtil.ListenerImplementation.class)
public class LoginTest extends BaseClass{

	@Test
public void signUp() throws EncryptedDocumentException, IOException, InterruptedException
{
	//Read data from excel file
	ExcelUtil elib=new ExcelUtil();
	String USERNAME = elib.toReadfromExcel("Sheet1", 1, 0);
	String PASSWORD = elib.toReadfromExcel("Sheet1", 1, 1);
	
	   //Signup using POM
	try
	{
		DemoSignUpPage dsp=new DemoSignUpPage(driver);
	    dsp.toSignUp(USERNAME, PASSWORD);
	}
	catch(Exception e)
	{
		System.out.println("User already login");
	}
	
	//Login using POM
	
	DemoLoginPage dlp=new DemoLoginPage(driver);
	dlp.loginDetails(USERNAME, PASSWORD);
	
	Thread.sleep(3000);
	DemoHomePage dhp=new DemoHomePage(driver);
	String demohomepagetext = dhp.ClickOnRandomProductAndText();
	
	Thread.sleep(2000);
	String prodPageText = driver.findElement(By.className("name")).getText();
	System.out.println("Prd_name on product page: " + prodPageText);
	System.out.println("Prd_name on home page: " + demohomepagetext);
	
	Assert.assertEquals(prodPageText, demohomepagetext, "Product name does not match");
	
	//add product to cart
	DemoAddtoCartPageTest dacp = new DemoAddtoCartPageTest(driver);
	dacp.addToCart();

	
	DemoCartPage dcp = new DemoCartPage(driver);
	dcp.clickOnCartLink();
	dcp.clickOnPlaceOrder();
	
	
	//to read from excel for place order details
	
	String NAME = elib.toReadfromExcel("Sheet2", 1, 0);
	String COUNTRY = elib.toReadfromExcel("Sheet2", 1, 1);
	String CITY = elib.toReadfromExcel("Sheet2", 1, 2);
	String CARD = elib.toReadfromExcel("Sheet2", 1, 3);
	String MONTH = elib.toReadfromExcel("Sheet2", 1, 4);
	String YEAR = elib.toReadfromExcel("Sheet2", 1, 5);
	
	//System.out.println(NAME);
	
	
     DemoPlaceOrder dpo=new DemoPlaceOrder(driver);
     dpo.toPlaceOrder(NAME, COUNTRY, CITY, CARD, MONTH, YEAR);
	
	  DemoConfirmationPage dp=new DemoConfirmationPage(driver);
	  String currentTxt = dp.getConfirmationText();
	  Assert.assertTrue(currentTxt.contains("Thank you for your purchase"), "Order not placed successfully");
	  
}
}
