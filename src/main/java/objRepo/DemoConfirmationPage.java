package objRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoConfirmationPage {

	 WebDriver driver;
	public DemoConfirmationPage(WebDriver driver)
	{
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-animation='pop']//h2")
	WebElement confirmationMessage;
	
	public String getConfirmationText()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
		 String confirmationText = confirmationMessage.getText();
		 return confirmationText;
		
	}
	
}
