package objRepo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoCartPage {

	
	WebDriver driver;
	public DemoCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(id="cartur")
	private WebElement cartLink;
	
	@FindBy(xpath="//button[.='Place Order']")
	private WebElement placeOrderButton;
	
	public void clickOnCartLink()
	{
		cartLink.click();
	}
	
	public void clickOnPlaceOrder()
	{
		placeOrderButton.click();
	}
}
