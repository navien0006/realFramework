package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest {
	@Test(invocationCount=5)
	public void sampleTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		String title = driver.getTitle();
		Reporter.log(title,true);
		
	}

}
