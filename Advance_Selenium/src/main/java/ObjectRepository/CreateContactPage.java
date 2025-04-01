package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactPage 
{
	
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="organizationName")
	WebElement organizationName;
	
	@FindBy(name="title")
	WebElement titleField;
	
	@FindBy(name="contactName")
	WebElement contName;
	
	@FindBy(name="mobile")
	WebElement mobileField;
	
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")
	WebElement selectCampPlusBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	WebElement createContactBtn;
	
	@FindBy(id="search-criteria")
	WebElement selectDD;
	
	@FindBy(id="search-input")
	WebElement searchInp;
	
	@FindBy(xpath="//button[@class='select-btn']") 	

	WebElement selectBtn;
	
	
	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement gettitleField() {
		return titleField;
	}

	public WebElement getContName() {
		return contName;
	}

	public WebElement getMobileField() {
		return mobileField;
	}

	public WebElement getContactSelectCampaignPlusBtn() {
		return selectCampPlusBtn;
	}
	
	public WebElement getCreateContact() {
		return createContactBtn;
	}
	
	public WebElement getSelectDD() {
		return selectDD;
	}

	public WebElement getSearchInp() {
		return searchInp;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public void createContactWithCampaign(String org, String title, String cont, String mob, String childUrl, String parentUrl, String campNam ) {
		organizationName.sendKeys(org);
		titleField.sendKeys(title);
		contName.sendKeys(cont);
		mobileField.sendKeys(mob);
		selectCampPlusBtn.click();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.switchToWindow(driver, childUrl);
		wUtil.select(selectDD, 1);
		searchInp.sendKeys(campNam);
		selectBtn.click();
		wUtil.switchToWindow(driver, parentUrl);
		createContactBtn.click();
		
	}
	
	
	
	
	
}
