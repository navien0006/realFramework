package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityProgram {
	
	@Test(priority=-1)
	public void createAccount() {
		Reporter.log("CreateAccount",true);
	}
	@Test(priority=0)
	public void updateAccount() {
		Reporter.log("updateAccount",true);
	}
	@Test(priority=1)
	public void deleteAccount() {
		Reporter.log("deleteAccount",true);
	}
	

}
