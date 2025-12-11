package Testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeScreenShot {
	@Test
	public void sample() throws IOException {
		Date d=new Date();
		String dateformat = d.toString().replace(" ", "_").replace(":", "_");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		TakesScreenshot ss=(TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		File perm=new File("C:\\Users\\navee\\eclipse-workspace\\AdvanceJavaAutomation\\ScreenShot/flipkart"+dateformat+".jpg");
	
		FileHandler.copy(file, perm);
		driver.close();
		
		
	}

}
