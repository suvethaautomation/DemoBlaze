package objRepo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import genUtility.JavaUtil;

public class DemoHomePage {

	
	WebDriver driver;
	
	public DemoHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[@class='card-title']/child::a")
     List<WebElement> products;
	
	public List<WebElement> getProductNames()
	{
		return products;
	}
	
	//click random product
	public String ClickOnRandomProductAndText()
	{
		By productsLocator = By.xpath("//a[@class='hrefch']");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productsLocator, 0));
	    
	    List<WebElement> prodLists = driver.findElements(productsLocator);
	    if(prodLists==null||prodLists.isEmpty())
	    {
	    	throw new RuntimeException("No products found in this page");
	    }
	    
	    //Random Number
	    
	    JavaUtil jlib=new JavaUtil();
	    int randomnum = jlib.randomNumber(prodLists.size());
	    
	   String prodtext = prodLists.get(randomnum).getText();//store text before clicking to avoid stale element
	   
	   //click to navigate to product page
	   prodLists.get(randomnum).click(); 
	   
	   return prodtext;
	   
	    
	    
	    
	}
    
}
