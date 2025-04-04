package ProductTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;

public class createProductTest extends BaseClass {

	@Test
	public void addProductTest() throws IOException, InterruptedException {

		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(5000);

		ExcelFileUtility exUtil = new ExcelFileUtility();
		String product = exUtil.readingDataFromExcel("Product", 1, 2) + randomNum;
		String category = exUtil.readingDataFromExcel("Product", 1, 3);
		String quantity = exUtil.readingDataFromExcel("Product", 1, 4);
		String pricePerUnit = exUtil.readingDataFromExcel("Product", 1, 5);
		String vendor = exUtil.readingDataFromExcel("Product", 1, 6);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(2000);

		DashboardPage dp = new DashboardPage(driver);

		dp.getProductsLink().click();

		ProductPage pp = new ProductPage(driver);

		pp.getCreateProductBtn().click();

		CreateProductPage cpp = new CreateProductPage(driver);

		cpp.createProduct(product, category, quantity, pricePerUnit, vendor);
		Thread.sleep(2000);

		// verify messege
		String ConfMsg = pp.getGetConfmsg().getText();

		boolean status = ConfMsg.contains(product);
		Assert.assertEquals(status, true, "Validation Failed");

		// Assert.assertTrue(status, "Product not added"); (Optional validation type)
		Reporter.log("Product " + product + " added successfully");

		Thread.sleep(5000);

	}

}
