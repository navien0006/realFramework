package hardCoding;

import java.time.Duration;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignandConactsWithMandatoryFeilds {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://49.249.28.218:8098/campaigns");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Create Campaign\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"campaignName\"]")).sendKeys("IphonePrjct");
		WebElement size = driver.findElement(By.xpath("//input[@name=\"targetSize\"]"));
		size.clear();
		size.sendKeys("5");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@role=\"alert\"]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(msg));
		String srng = msg.getText();
		if(srng.contains("IphonePrjct")) {
			System.out.println("the campaign created successfully");
		}
		else {
			System.err.println("the campaign not created successfully");
			
		}
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()=\"Create Contact\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"organizationName\"]")).sendKeys("QSpider");
		driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys("Iphonezon");
		driver.findElement(By.xpath("//input[@name=\"contactName\"]")).sendKeys("Naveen");
		driver.findElement(By.xpath("//input[@name=\"mobile\"]")).sendKeys("9785875465  ");
		driver.findElement(By.xpath("//input[@type=\"text\"]/..//button[@type=\"button\"]")).click();
		
		Set<String> allwind = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		allwind.remove(parent);
		
		for (String handle : allwind) {
			driver.switchTo().window(handle);
				WebElement sel = driver.findElement(By.xpath("//select[@id=\"search-criteria\"]"));
				Thread.sleep(2000);
				Select sele=new Select(sel);
				sele.selectByVisibleText("Campaign Name");
				driver.findElement(By.xpath("//td[text()=\"CAM00001\"]/..//button[@class=\"select-btn\"]")).click();
				
			 
		//for (String handle : allwind) {
	        if (!handle.equals(parent)) {
	            driver.switchTo().window(parent);
	        }}
		driver.findElement(By.xpath("//button[text()=\"Create Contact\"]")).click();
		WebElement msg1 = driver.findElement(By.xpath("//div[@role=\"alert\"]"));
		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(msg1));
		String newmsg = msg1.getText();
		if(newmsg.contains("Naveen")) {
			System.out.println("the contact created succussfully");
		}
		else {
			System.out.println("contact not created");
		}
		
	WebElement mouseover =driver.findElement(By.xpath("//div[@class=\"user-icon\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).click().perform();
		driver.findElement(By.xpath("//div[text()=\"Logout \"]")).click();
	    driver.close(); 
	   
		
	}
	}

	

