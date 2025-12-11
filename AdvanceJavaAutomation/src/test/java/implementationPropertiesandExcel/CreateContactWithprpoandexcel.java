package implementationPropertiesandExcel;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import GenericUtility.ExcelUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;

public class CreateContactWithprpoandexcel {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		PropertyUtility plib=new PropertyUtility();//reading data from property utility
		ExcelUtility elib=new ExcelUtility(); // reading data from excel utility
		WebDriverUtility wlib=new WebDriverUtility();//reading data from webdriver utility
				
		String BROWSER = plib.toReadDataFromProperiesFile("browser");
		String URL = plib.toReadDataFromProperiesFile("url");
		String USERNAME = plib.toReadDataFromProperiesFile("username");
		String PASSWORD = plib.toReadDataFromProperiesFile("password");
		
		
		String organization = elib.toReadDataFromExcelFile("Sheet5", 1, 0);
		String title = elib.toReadDataFromExcelFile("Sheet5", 1, 1);
		String contactname = elib.toReadDataFromExcelFile("Sheet5", 1, 2);
		String mobile = elib.toReadDataFromExcelFile("Sheet5", 1, 3);
		String compaignname = elib.toReadDataFromExcelFile("Sheet5", 1, 4);
		
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();}
			else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
							
			}
		wlib.toMaximize(driver);
		wlib.toImplicitWait(driver);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()=\"Create Contact\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"organizationName\"]")).sendKeys(organization);
		driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys(title);
		driver.findElement(By.xpath("//input[@name=\"contactName\"]")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@name=\"mobile\"]")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@type=\"text\"]/..//button[@type=\"button\"]")).click();
		
		Set<String> allwind = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		allwind.remove(parent);
		
		for (String handle : allwind) {
			driver.switchTo().window(handle);
				WebElement sel = driver.findElement(By.xpath("//select[@id=\"search-criteria\"]"));
				Thread.sleep(2000);
				Select sele=new Select(sel);
				sele.selectByVisibleText(compaignname);
				driver.findElement(By.xpath("//td[text()=\"CAM00001\"]/..//button[@class=\"select-btn\"]")).click();
				
			 
		        if (!handle.equals(parent)) {
	            driver.switchTo().window(parent);
	        }}
		driver.findElement(By.xpath("//button[text()=\"Create Contact\"]")).click();
		WebElement msg1 = driver.findElement(By.xpath("//div[@role=\"alert\"]"));
		wlib.toExplicitwait(driver, msg1);
		String newmsg = msg1.getText();
		if(newmsg.contains(contactname)) {
			System.out.println("the contact created succussfully");
		}
		else {
			System.out.println("contact not created");
		}
		
	WebElement mouseover =driver.findElement(By.xpath("//div[@class=\"user-icon\"]"));
		wlib.clickOnElement(driver, mouseover);
		driver.findElement(By.xpath("//div[text()=\"Logout \"]")).click();
	    driver.close(); 
	   
		
	}
	}

	


