package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void toImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void toExplicitwait(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void selecByVisibleText(WebElement ele, String text) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement ele, int index) {
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement ele, String value) {
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void mouseOver(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void clickOnElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
	}
	
	public void contextclick(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	
	}
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	
	}
	
	
	public void movetoframeByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	public void movetoFrameByValue(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}
	public void moveToFrameByElement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertanddismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandsendkeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public String switchToAlertandGetText(WebDriver driver) {
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	
}
