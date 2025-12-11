package TestNG;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void zepto() {
		Reporter.log("hello zepto",true);;
	}
	@Test
	public void blinkit() {
		Reporter.log("hello blinkit",true);
	}
	@Test
	public void jiomart() {
		Reporter.log("hello jiomart",true);
	}
	@Test
	public void instamart() {
		Reporter.log("hello instamart",true);
	}

}
