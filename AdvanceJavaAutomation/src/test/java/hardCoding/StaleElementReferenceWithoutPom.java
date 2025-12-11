package hardCoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaleElementReferenceWithoutPom {

	public static void main(String[] args) {


		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://49.249.28.218:8098/campaigns");
		WebElement un = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("inputPassword"));
		WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		un.sendKeys("rmgyantra");
		pwd.sendKeys("rmgy@9999");
		button.click();
		driver.navigate().refresh();
		un.sendKeys("rmgyantra");
		pwd.sendKeys("rmgy@9999");
		button.click();
		

	}

}
