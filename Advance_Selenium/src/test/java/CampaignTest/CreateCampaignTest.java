package CampaignTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;

public class CreateCampaignTest extends BaseClass
{

	
	@Test     
	public void createCampaignTest()  throws IOException, InterruptedException  
	{
	      
		JavaUtility jUtil = new JavaUtility();
	    int randomNum = jUtil.getRandomNum(5000);
	      
               //utility
	       ExcelFileUtility exlUtil = new ExcelFileUtility();
	       String Campaign = exlUtil.readingDataFromExcel("DDT",1, 2) + randomNum ;
	       String targetSize = exlUtil.readingDataFromExcel("DDT", 1, 3);
				
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
				
				//verify messege
				String confMsg = cp.getGetConfmsg().getText();
				boolean status = confMsg.contains(Campaign);
				Assert.assertEquals(status, true, "Validation Failed");
				
				//Assert.assertTrue(status, "Campaign not added");   (Optional validation type)
				Reporter.log("Campaign " + Campaign + " added successfully");
				Thread.sleep(5000);
				

	}
	
	
	@Test 
	public void createCampaignWithDateTest() throws IOException, InterruptedException {
	      
	     JavaUtility jUtil = new JavaUtility();
	     int randomNum = jUtil.getRandomNum(2000);
	      
	      //utility
	       ExcelFileUtility exlUtil = new ExcelFileUtility();
	       String Campaign = exlUtil.readingDataFromExcel("DDT",1, 2) + randomNum ;
	       String targetSize = exlUtil.readingDataFromExcel("DDT", 1, 3);
	      
	        String closeDate = jUtil.generateReqDate(30);
	
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				Thread.sleep(2000);
				
				//campaign link
				DashboardPage dp = new DashboardPage(driver);
				dp.getCampaignsLink().click();
				
				CampaignPage cp = new CampaignPage(driver);
				cp.getCreateCampaignBtn().click();
				
				CreateCampaignPage ccp = new CreateCampaignPage(driver);
				ccp.createCampaignWithDate(Campaign, targetSize, closeDate);
				Thread.sleep(5000);
				
				//verify messege
				String confMsg = cp.getGetConfmsg().getText();
				boolean status = confMsg.contains(Campaign);
				Assert.assertEquals(status, true, "Validation Failed");
				//Assert.assertTrue(status, "Campaign not added"); (Optional validation type)
				Reporter.log("Campaign " + Campaign + " added successfully");
				
				Thread.sleep(5000);
				
	}

}
