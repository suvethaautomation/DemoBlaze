package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoLoginPage {

	WebDriver driver;
	
	public DemoLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginusername")
	private WebElement un;
	
	@FindBy(id="loginpassword")
 private WebElement pwd;
	
	@FindBy(xpath="//button[.='Log in']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//a[.='Log in']")
	private WebElement lgn;
	
	public WebElement getUsername()
	{
		return un;
	}
	
	public WebElement getPassword()
	{
		return pwd;
	}
	
	public void loginDetails(String username,String password)
	{
	 lgn.click();
	 un.sendKeys(username);
	 pwd.sendKeys(password);
	 loginbtn.click();
	}
	public String getLoginAlertMessage() {

	    return driver.switchTo().alert().getText();
	}
	
}
