package objRepo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSignUpPage {

	WebDriver driver;
	public DemoSignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin2")
	WebElement signUpLink;
	
	@FindBy(id="sign-username")
	WebElement suname;
	
	@FindBy(id="sign-password")
	WebElement spwd;
	
	@FindBy(xpath="//button[.='Sign up']")
	WebElement signbtn;
	
	@FindBy(xpath="(//span[.='×'])[2]")
	WebElement closebtn;
	
	public WebElement getUsername()
	{
		return suname;
	}
	
	public WebElement getPassword()
	{
		return spwd;
	}
	
	public void toSignUp(String username,String password)
	{
		signUpLink.click();
		suname.sendKeys(username);
		spwd.sendKeys(password);
		signbtn.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		closebtn.click();
		
		
	}
	
}
