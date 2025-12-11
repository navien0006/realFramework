package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productName;
	
	@FindBy(xpath="//select[@name='productCategory']")
	private WebElement category;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//input[@name='price']")
	private WebElement price;
	
	@FindBy(xpath="//select[@name='vendorId']")
	private WebElement vendorID;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorID() {
		return vendorID;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
