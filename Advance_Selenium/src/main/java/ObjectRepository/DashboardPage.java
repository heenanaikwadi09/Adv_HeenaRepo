package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getContacts() {
		return Contacts;
	}

	public WebElement getProfileIcon() {
		return profileIcon ;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts;
	
	@FindBy(xpath="//*[name()='svg' and @role='img']")
	private WebElement profileIcon;
	
	@FindBy(xpath="//div[text()='Logout ')")
	private WebElement logoutBtn;
	
	public void logout()
	{
		profileIcon.click();
		Actions action = new Actions(driver);
		action.moveToElement(logoutBtn).click();
	}
	
	
}
