package Testing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	public void sample() {
		String actualvalue="Insta";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		String expectedvalue=driver.getTitle();
		Assert.assertEquals(actualvalue, expectedvalue);
		System.out.println("test1");
		driver.close();
		}

		

}
