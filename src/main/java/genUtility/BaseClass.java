package genUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objRepo.DemoLoginPage;

public class BaseClass {

	
public WebDriver driver;
public static WebDriver sdriver;
public PropUtil plib=new PropUtil();

@Parameters("browser")
@BeforeClass
public void beforeClass(@Optional("") String BROWSER) throws IOException
{
	if(BROWSER==null||BROWSER.isEmpty())
	{
		BROWSER = plib.toDemoReadFromProp("browser");
	}
	
	String URL = plib.toDemoReadFromProp("url");

	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	sdriver=driver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	
}


@AfterClass
public void tearDown()
{
	driver.quit();
}

}
