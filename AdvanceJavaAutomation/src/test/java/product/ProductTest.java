package product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Config.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import Pom.CreateProductPage;
import Pom.HomePage;
import Pom.LoginPage;
@Listeners(Listener.ListenerImplementation.class)
public class ProductTest extends BaseClass {
	@Test(groups = "smoke")
	public void createProductwithMandataryDetails() throws EncryptedDocumentException, IOException {
		

		String productName = elib.toReadDataFromExcelFile("Sheet4", 1, 0);
		String quantity = elib.toReadDataFromExcelFile("Sheet4", 1, 1);
		String priceperunit = elib.toReadDataFromExcelFile("Sheet4", 1, 2);
		String vendor = elib.toReadDataFromExcelFile("Sheet4", 1, 3);
		String category = elib.toReadDataFromExcelFile("Sheet4", 1, 4);
		String mobile=productName + jlib.randomNumber();
		//home page
		HomePage hp=new HomePage(driver);
		hp.getProduct().click();
		hp.getAddProducts().click();
		
		//create product page
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.getProductName().sendKeys(mobile);
		
		WebElement dropdown = cpp.getCategory();
		wlib.selecByVisibleText(dropdown, category);
		WebElement quant = cpp.getQuantity();
		quant.clear();
		quant.sendKeys(quantity);
		WebElement price = cpp.getPrice();
		price.clear();
		price.sendKeys(priceperunit);
		WebElement vendor1 = cpp.getVendorID();
		Select sel1=new Select(vendor1);
		sel1.selectByVisibleText(vendor);
		cpp.getSubmitButton().click();
		WebElement msg = hp.getAlertmsg();
		wlib.toExplicitwait(driver, msg);
		String succuss = msg.getText();
		System.out.println(succuss);
		Assert.assertEquals(succuss, "Product "+mobile+" Successfully Added");
		}

}
