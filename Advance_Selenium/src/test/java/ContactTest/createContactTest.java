package ContactTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;

public class createContactTest extends BaseClass
{
	
	@Test
	public void createContactWithCampaignTest() throws IOException, InterruptedException {
		
		
		JavaUtility jUtil=new JavaUtility();
		int randomNum = jUtil.getRandomNum(2000);
		
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		String organization = exUtil.readingDataFromExcel("Contact", 1, 2)+randomNum;
		String title = exUtil.readingDataFromExcel("Contact", 1, 3);
		String contactName = exUtil.readingDataFromExcel("Contact", 1, 4)+randomNum;
		String mobile = exUtil.readingDataFromExcel("Contact", 1, 5);
        

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		Thread.sleep(2000);
		
		//campaign link
		DashboardPage dp = new DashboardPage(driver);
		dp.getCampaignsLink().click();
		
		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaignWithMandatFields(Campaign, targetSize);
		Thread.sleep(5000);
		
		CreateContactPage cct = new CreateContactPage(driver);
		
		dp.getContacts().click();
		
		ContactPage ct = new ContactPage(driver);
		
		ct.getCreateContactBtn().click();
		
		cct.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign" ,"create-contact", Campaign);
		Thread.sleep(3000);
		
       String ConfirmationMsg = ct.getGetConfmsg().getText();
       boolean status = ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true, "Validation Failed");
		//Assert.assertTrue(status, "Contact not added");   (Optional validation type)
		Reporter.log("Contact " + contactName + " added successfully");
       
       Thread.sleep(5000);
       
       
	}

}