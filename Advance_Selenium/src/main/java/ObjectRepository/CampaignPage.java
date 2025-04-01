package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{

	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//select[@class='form-control']")
	private WebElement dropdownCampaign;
	
	@FindBy (xpath="//input[@class='form-control']")
	private WebElement serachCampaign;
	
	@FindBy (xpath="//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy (xpath="//div[@role='alert']")
	private WebElement getConfmsg;
	

	public WebElement getDropdownCampaign() {
		return dropdownCampaign;
	}

	public WebElement getSerachCampaign() {
		return serachCampaign;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}


	public WebElement getGetConfmsg() {
		
		return getConfmsg;
	}
	
	
	
}

	