
package hardCoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCamaignWithMandatoryFeilds {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://49.249.28.218:8098/campaigns");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Create Campaign\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"campaignName\"]")).sendKeys("NinzaPrjct");
		WebElement size = driver.findElement(By.xpath("//input[@name=\"targetSize\"]"));
		size.clear();
		size.sendKeys("5");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@role=\"alert\"]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(msg));
		String srng = msg.getText();
		if(srng.contains("NinzaPrjct")) {
			System.out.println("the campaign created successfully");
		}
		else {
			System.err.println("the campaign not created successfully");
			
		}
		
		WebElement mouseover =driver.findElement(By.xpath("//div[@class=\"user-icon\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).click().perform();
		driver.findElement(By.xpath("//div[text()=\"Logout \"]")).click();
		driver.close(); 

	}

}
