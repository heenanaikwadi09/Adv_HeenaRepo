package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductPage 
{

	WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productName")
	WebElement productName;
	
	@FindBy(name="productCategory")
	WebElement productCategory;
	
	@FindBy(name="quantity")
	WebElement productQuantity;
	
	@FindBy(name="price")
	WebElement productPricePerUnit;
	
	@FindBy(xpath="//select[@name='vendorId']")
	WebElement productVendor;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement productAddBtn;
	
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getProductQuantity() {
		return productQuantity;
	}

	public WebElement getProductPricePerUnit() {
		return productPricePerUnit;
	}

	public WebElement getProductVendor() {
		return productVendor;
	}

	public WebElement getProductAddBtn() {
		return productAddBtn;
	}
	
	
	public void createProduct(String prodNam, String categ, String quantity, String price, String vend ) {
		
		productName.sendKeys(prodNam);
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(productCategory, categ);
		productQuantity.clear();
		productQuantity.sendKeys(quantity);
		productPricePerUnit.clear();
		productPricePerUnit.sendKeys(price);
		wUtil.select(productVendor, vend);
		productAddBtn.click();
		
	}
	
	
}
