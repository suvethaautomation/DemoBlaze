package objRepo;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoAddtoCartPageTest {

	 WebDriver driver;
	public DemoAddtoCartPageTest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(className ="name")
	WebElement prodName;
	
	@FindBy(xpath="//a[.='Add to cart']")
	WebElement addtoCartbtn;
	
	public void addToCart()
	{
		addtoCartbtn.click();
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	     alert.accept();
	}
	
	
	
	
	
}
