package hardCoding;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductwithMandatoryFields {

	public static void main(String[] args) {
		Random rand=new Random();
		int number = rand.nextInt(1000);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()=\"Add Product\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"productName\"]")).sendKeys("Laptop"+ number);
		WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"productCategory\"]"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Electricals");
		WebElement quant = driver.findElement(By.xpath("//input[@name=\"quantity\"]"));
		quant.clear();
		quant.sendKeys("1");
		WebElement price = driver.findElement(By.xpath("//input[@name=\"price\"]"));
		price.clear();
		price.sendKeys("50000");
		WebElement vendor = driver.findElement(By.xpath("//select[@name=\"vendorId\"]"));
		Select sel1=new Select(vendor);
		sel1.selectByVisibleText("Vendor_93571 - (Electronics)");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(msg));
		String succuss = msg.getText();
		if(succuss.contains("Laptop")) {
			System.out.println("the product created succussfully");
		}
		else {
			System.out.println("the product not created succussfully");
		}
		WebElement mouseover = driver.findElement(By.xpath("//div[@class=\"user-icon\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).click().perform();
		driver.findElement(By.xpath("//div[text()=\"Logout \"]")).click();
		//driver.close();
		
		
	}

}
