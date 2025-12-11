package TestNG;



import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigurationProgram {
	@Test
	public void testcase() {
		Reporter.log("testcase executed",true);
	}
	@Test
	public void testcase1() {
		Reporter.log("testcase1 executed",true);
	}
	@BeforeSuite
	public void beforesuite() {
		Reporter.log("DB conection",true);;
	}
	@AfterSuite
	public void aftersuite() {
		Reporter.log("closing DB conection",true);
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("used for parllel execution",true);
	}
	@AfterTest
	public void afterTest() {
		Reporter.log("used for parllel execution",true);
	}
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Launching browser",true);
	}
	@AfterClass
	public void afterClass() {
		Reporter.log("closing browser",true);
	}
	@BeforeMethod
	public void beforeMethods() {
		Reporter.log("Login",true);
	}
	@AfterMethod
	public void afterMethods() {
		Reporter.log("Logout",true);
	}

}
