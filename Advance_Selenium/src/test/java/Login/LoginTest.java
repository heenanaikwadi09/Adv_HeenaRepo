package Login;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericBaseClassUtility.BaseClass;

public class LoginTest extends BaseClass 
{

	@Test(retryAnalyzer = genericListenerUtility.RetryListenerImp.class)
	public void loginTest() throws InterruptedException, IOException 
	{
		{

			String expectedURL = "http://49.249.28.218:8098/dashboar";

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			Thread.sleep(2000);

			// verification of dashboard
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL, "Validation Failed");
			Reporter.log("Validation is successful");

		}

	}

}
