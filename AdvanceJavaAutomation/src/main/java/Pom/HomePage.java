package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Campaigns")
	private WebElement Compaign;
	
	@FindBy(linkText="Products")
	private WebElement Product;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement Createcampaign;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProducts;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement alertmsg;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement usericon;
	
	public WebElement getUsericon() {
		return usericon;
	}

	
	public WebElement getAddProducts() {
		return addProducts;
	}

	public WebElement getLogout() {
		return logout;
	}
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement logout;

	
	public WebElement getCompaign() {
		return Compaign;
	}

	public WebElement getProduct() {
		return Product;
	}

	
	public WebElement getAlertmsg() {
		return alertmsg;
	}


	public WebElement getCreatecampaign() {
		return Createcampaign;
	}

	
	
	

}
