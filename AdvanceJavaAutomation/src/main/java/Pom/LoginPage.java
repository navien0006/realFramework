package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement un;
	
	@FindBy(id="inputPassword")
	private WebElement pw;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPw() {
		return pw;
	}

	public WebElement getButton() {
		return button;
	}
	
	
	public void loginpage(String url,String username, String password) {
		driver.get(url);
		un.sendKeys(username);
		pw.sendKeys(password);
		button.click();
			
	}
	
}
