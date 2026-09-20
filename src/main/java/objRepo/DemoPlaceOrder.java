package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPlaceOrder {

	WebDriver driver;
	public DemoPlaceOrder(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="name")
	private WebElement Name;
	
	@FindBy(id="country")
	private WebElement Country;
	
	@FindBy(id="city")
	private WebElement City;
	
	@FindBy(id="card")
	private WebElement Card;
	
	@FindBy(id="month")
	private WebElement Month;
	
	@FindBy(id="year")
	private WebElement Year;
	
	@FindBy(xpath="//button[.='Purchase']")
	private WebElement purchasebtn;
	
	public WebElement getName() {
		return Name;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getCard() {
		return Card;
	}

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getYear() {
		return Year;
	}

	public WebElement getPurchasebtn() {
		return purchasebtn;
	}

	public void toPlaceOrder(String name,String country,String city,String card,String month,String year)
	{
	Name.sendKeys(name);
	Country.sendKeys(country);
	City.sendKeys(city);
	Card.sendKeys(card);
	Month.sendKeys(month);
	Year.sendKeys(year);
	purchasebtn.click();
	
	}
	

}
