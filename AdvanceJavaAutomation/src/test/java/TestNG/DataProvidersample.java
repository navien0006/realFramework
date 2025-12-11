package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersample {
	@DataProvider
	public Object[][] logindetails(){
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="Naveen";
		objarr[0][1]="Naveen@123";
		
		objarr[1][0]="vars";
		objarr[1][1]="vars@123";
		
		objarr[2][0]="maven";
		objarr[2][1]="maven@123";
				
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
