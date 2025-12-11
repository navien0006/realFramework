package Config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import Pom.HomePage;
import Pom.LoginPage;

public class BaseClass {
	public JavaUtility jlib = new JavaUtility();// reading data from java utility
	public PropertyUtility plib = new PropertyUtility(); // reading data from property utility
	public ExcelUtility elib = new ExcelUtility(); // reading data from excel utility
	public WebDriverUtility wlib = new WebDriverUtility();// reading data from webdriver utility
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void beforesuite() {
		Reporter.log("DB conection", true);
	}

	@AfterSuite
	public void aftersuite() {
		Reporter.log("closing DB conection", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("used for parllel execution", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("used for parllel execution", true);
	}

	@BeforeClass
	// @Parameters("BROWSER") parallel cross browsing
	public void beforeClass() throws IOException {

		// BROWSER=browser; parallel cross browsing
		//String BROWSER = plib.toReadDataFromProperiesFile("browser");
		Object BROWSER = System.getProperty("browser");//reading browser from command prompt
		
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		}
		sdriver=driver;
		wlib.toMaximize(driver);
		wlib.toImplicitWait(driver);

	}

	@AfterClass
	public void afterClass() {

		driver.close();

	}

	@BeforeMethod
	public void beforeMethods() throws IOException {

		String URL = plib.toReadDataFromProperiesFile("url");
		String USERNAME = plib.toReadDataFromProperiesFile("username");
		String PASSWORD = plib.toReadDataFromProperiesFile("password");

		driver.get(URL);

		// create login
		LoginPage lp = new LoginPage(driver);
		lp.getUn().sendKeys(USERNAME);
		lp.getPw().sendKeys(PASSWORD);
		lp.getButton().click();

	}

	@AfterMethod
	public void afterMethods() {
		HomePage hp = new HomePage(driver);
		WebElement mouseover = hp.getUsericon();
		wlib.clickOnElement(driver, mouseover);
		hp.getLogout().click();
		;

	}

}
