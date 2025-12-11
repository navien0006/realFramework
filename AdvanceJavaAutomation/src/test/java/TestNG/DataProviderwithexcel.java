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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderwithexcel {
	
		@DataProvider
		public Object[][] logindetails() throws EncryptedDocumentException, IOException{
			FileInputStream fis=new FileInputStream("./src\\test\\resources\\e35.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("data provider");
			int rownum = sh.getLastRowNum();
			Object[][] objarr=new Object[4][2];
			for(int i=0;i<rownum;i++)
			{
				objarr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
				objarr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
				
				
			}
			
			
			return objarr;
			
			}
		
		@Test(dataProvider = "logindetails")
		public void login(String un, String pw) throws InterruptedException {
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			driver.get("http://49.249.28.218:8098/campaigns");
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.id("inputPassword")).sendKeys(pw);
			Thread.sleep(1000);
			driver.close();
		}

}
