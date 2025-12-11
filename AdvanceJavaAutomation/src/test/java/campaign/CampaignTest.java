package campaign;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Config.BaseClass;
import Pom.CreateCompaignPage;
import Pom.HomePage;

@Listeners(Listener.ListenerImplementation.class)

public class CampaignTest extends BaseClass{
	

	@Test
	public void createCampaignwithMandataryDetailsTest() throws EncryptedDocumentException, IOException {
					
		String campaignname = elib.toReadDataFromExcelFile("Sheet3", 1, 0);
		String targetsize = elib.toReadDataFromExcelFile("Sheet3", 1, 1);
	String campaign=campaignname+jlib.RandomAlphbet();
		//home Page
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//create campaign page
		CreateCompaignPage ccp=new CreateCompaignPage(driver);
		ccp.getCompName().sendKeys(campaign);
						
		WebElement clear = ccp.getTargetSize();
		clear.clear();
		clear.sendKeys(targetsize);
		ccp.getSubmitButton().click();
		WebElement msg = hp.getAlertmsg();
		wlib.toExplicitwait(driver, msg);
		String visibletext=msg.getText();
		
		System.out.println(visibletext);
		Assert.assertEquals(visibletext, "Campaign "+ campaign +" Successfully Added");
		
		}

	@Test
	public void createCampaignwithStatusTest() throws EncryptedDocumentException, IOException {
		
		String campaignname = elib.toReadDataFromExcelFile("Sheet3", 1, 0);
		String targetsize = elib.toReadDataFromExcelFile("Sheet3", 1, 1);
		String status = elib.toReadDataFromExcelFile("Sheet3", 1, 2);
		String campaign=campaignname+jlib.RandomAlphbet();
		
		//home page
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//create campaign page
		CreateCompaignPage ccp=new CreateCompaignPage(driver);
		ccp.getCompName().sendKeys(campaign);
		ccp.getStatus().sendKeys(status);
		
		WebElement clear = ccp.getTargetSize();
		clear.clear();
		clear.sendKeys(targetsize);
		ccp.getSubmitButton().click();
		WebElement msg = hp.getAlertmsg();
		wlib.toExplicitwait(driver, msg);
		String visibletext=msg.getText();
		System.out.println(visibletext);
		Assert.assertEquals(visibletext,"Campaign "+campaign+" Successfully Added");
		
		
	}

	@Test
	public void createCampaignwithExpectedDateTest() throws EncryptedDocumentException, IOException {

		String campaignname = elib.toReadDataFromExcelFile("Sheet3", 1, 0);
		String targetsize = elib.toReadDataFromExcelFile("Sheet3", 1, 1);
		String status = elib.toReadDataFromExcelFile("Sheet3", 1, 2);
		String campaign=campaignname+jlib.RandomAlphbet();
		
		//business login method
		//lp.loginpage(URL, USERNAME, PASSWORD);
		
		//home page
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();		
		//create campaign Page
		CreateCompaignPage ccp=new CreateCompaignPage(driver);
		ccp.getCompName().sendKeys(campaign);
		ccp.getStatus().sendKeys(status);
				
		WebElement clear = ccp.getTargetSize();
		clear.clear();
		clear.sendKeys(targetsize);
		ccp.getExpectDate().sendKeys(jlib.expectedDate());
		ccp.getSubmitButton().click();;
		WebElement msg = hp.getAlertmsg();
		wlib.toExplicitwait(driver, msg);
		String visibletext=msg.getText();
		System.out.println(visibletext);
		Assert.assertEquals(visibletext,"Campaign "+campaign+" Successfully Added");
	
		}


}
