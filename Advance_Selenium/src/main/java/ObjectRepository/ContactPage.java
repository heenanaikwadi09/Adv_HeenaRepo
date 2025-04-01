package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage
{

	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[text()='Create Contact']")
	WebElement createContactBtn;
	
	@FindBy (xpath="//div[@role='alert']")
	private WebElement getConfmsg;
	

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getGetConfmsg() {
		return getConfmsg;
	}
	
	
	
}
