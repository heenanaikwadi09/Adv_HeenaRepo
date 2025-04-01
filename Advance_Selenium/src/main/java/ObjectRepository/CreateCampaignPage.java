package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{

	WebDriver driver;
	public CreateCampaignPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (name="campaignName")
	private WebElement campaignName;
	
	@FindBy (name="targetSize")
	private WebElement targetSize;
	
	@FindBy (name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy (xpath="//button[text()='Create Campaign']")
	private WebElement createCampaignbtn;
	
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaignbtn() {
		return createCampaignbtn;
	}
	
	public void createCampaignWithMandatFields(String campName, String target) {
	  
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		createCampaignbtn.click();
		
	}
	
	public void createCampaignWithDate(String campName, String target, String date) {
	    campaignName.sendKeys(campName);
	    targetSize.clear();
	    targetSize.sendKeys(target);
	    expectedCloseDate.sendKeys(date);  
	    createCampaignbtn.click();
	}
	
	
}
