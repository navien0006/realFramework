package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignmentPrg {
	@DataProvider
	public Object[][] dataprovider() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\e35.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("assignment");
		int rownum = sh.getLastRowNum();
		Object[][] objarry=new Object[2][2];
		
		for(int i=0;i<rownum;i++)
		{
			objarry[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objarry[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
			
			}
				
		return objarry;
		
	}
	@Test(dataProvider = "dataprovider")
	public void logintoflipkart(String phone, String version ) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http:flipkart.com");
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys(phone);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		WebElement iphone= driver.findElement(By.xpath("//div[text()='"+ version + "']/../..//div[@class=\"QiMO5r\"]"));
		String value = iphone.getText();
		
		Reporter.log(version+"- price is -"+value,true);
		driver.close();		
	}

}
