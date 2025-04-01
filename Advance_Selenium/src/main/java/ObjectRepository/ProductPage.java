package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement productDropdown;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement productSearch;
	
	@FindBy(xpath="//span[text()='Add Product']")
	WebElement createProductBtn;
	
	@FindBy (xpath="//div[@role='alert']")
	private WebElement getConfmsg;
	
	public WebElement getProductDropdown() {
		return productDropdown;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}
	
	public WebElement getGetConfmsg() {
		return getConfmsg;
	}
	
	
	
}
