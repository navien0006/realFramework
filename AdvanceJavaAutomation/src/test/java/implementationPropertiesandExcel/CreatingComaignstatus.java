package implementationPropertiesandExcel;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import Pom.CreateCompaignPage;
import Pom.HomePage;
import Pom.LoginPage;

public class CreatingComaignstatus {

	public static void main(String[] args) throws IOException {
		
		
		PropertyUtility plib=new PropertyUtility();//reading data from property utility
		ExcelUtility elib=new ExcelUtility();//reading data from excel utility
		WebDriverUtility wlib=new WebDriverUtility();//reading data from webdriver utility
		JavaUtility jlib=new JavaUtility(); // reading data from java utility
		
		String BROWSER = plib.toReadDataFromProperiesFile("browser");
		String URL = plib.toReadDataFromProperiesFile("url");
		String USERNAME = plib.toReadDataFromProperiesFile("username");
		String PASSWORD = plib.toReadDataFromProperiesFile("password");
		
		
		String campaignname = elib.toReadDataFromExcelFile("Sheet3", 1, 0);
		String targetsize = elib.toReadDataFromExcelFile("Sheet3", 1, 1);
		String status = elib.toReadDataFromExcelFile("Sheet3", 1, 2);
		
				
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();}
			else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
							
			}
		
		wlib.toMaximize(driver);
		wlib.toImplicitWait(driver);
		driver.get(URL);
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.getUn().sendKeys(USERNAME);
		lp.getPw().sendKeys(PASSWORD);
		lp.getButton().click();
		
		//home page
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//create campaign page
		CreateCompaignPage ccp=new CreateCompaignPage(driver);
		ccp.getCompName().sendKeys(campaignname+jlib.RandomAlphbet());
		ccp.getStatus().sendKeys(status);
		
		WebElement clear = ccp.getTargetSize();
		clear.clear();
		clear.sendKeys(targetsize);
		ccp.getSubmitButton().click();
		WebElement msg = hp.getAlertmsg();
		wlib.toExplicitwait(driver, msg);
		String visibletext=msg.getText();
		if(visibletext.contains(campaignname)) {
			 System.out.println("the new compaign created successfully");
		 } else {
			 System.out.println("error in creation");
			 
		 }
		WebElement mouseover=hp.getUsericon();
		wlib.clickOnElement(driver, mouseover);
		hp.getLogout().click();
		driver.close();		
		}
		
		}

