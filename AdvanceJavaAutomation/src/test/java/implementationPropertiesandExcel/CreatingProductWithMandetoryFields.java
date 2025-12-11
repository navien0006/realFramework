package implementationPropertiesandExcel;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import Pom.CreateProductPage;
import Pom.HomePage;
import Pom.LoginPage;

public class CreatingProductWithMandetoryFields {

	public static void main(String[] args) throws IOException {
		
		
		
		JavaUtility jlib=new JavaUtility();//reading data from java utility
		PropertyUtility plib=new PropertyUtility();//reading data from property utility
		ExcelUtility elib=new ExcelUtility();//reading data from excel utility
		WebDriverUtility wlib=new WebDriverUtility();//reading data from webdriver utility
		
		
		String BROWSER = plib.toReadDataFromProperiesFile("browser");
		String URL = plib.toReadDataFromProperiesFile("url");
		String USERNAME = plib.toReadDataFromProperiesFile("username");
		String PASSWORD = plib.toReadDataFromProperiesFile("password");
		
		
		String productName = elib.toReadDataFromExcelFile("Sheet4", 1, 0);
		String quantity = elib.toReadDataFromExcelFile("Sheet4", 1, 1);
		String priceperunit = elib.toReadDataFromExcelFile("Sheet4", 1, 2);
		String vendor = elib.toReadDataFromExcelFile("Sheet4", 1, 3);
		String category = elib.toReadDataFromExcelFile("Sheet4", 1, 4);
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();}
			else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
							
			}
		
		wlib.toMaximize(driver);
		wlib.toImplicitWait(driver);
		driver.get(URL);
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.getUn().sendKeys(USERNAME);
		lp.getPw().sendKeys(PASSWORD);
		lp.getButton().click();
		
		//home page
		HomePage hp=new HomePage(driver);
		hp.getProduct().click();
		hp.getAddProducts().click();
		
		//create product page
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.getProductName().sendKeys(productName + jlib.randomNumber());
		
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
		if(succuss.contains(productName)) {
			System.out.println("the product created succussfully");
		}
		else {
			System.out.println("the product not created succussfully");
		}
		WebElement mouseover = hp.getUsericon();
		wlib.clickOnElement(driver, mouseover);
		hp.getLogout().click();
		driver.close();
		}
		
		}

	


