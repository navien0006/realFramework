package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCompaignPage {

	public CreateCompaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='campaignName']")
	private WebElement compName;
	
	@FindBy(xpath="//input[@name='targetSize']")
	private WebElement targetSize;
	
	@FindBy(xpath="//input[@type='date']")
	private WebElement expectDate;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton;
	
	public WebElement getStatus() {
		return status;
	}


	@FindBy(xpath="//input[@name='campaignStatus']")
	private WebElement status;
	
	public WebElement getCompName() {
		return compName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getExpectDate() {
		return expectDate;
	}

	
}
