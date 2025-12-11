package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test(enabled = false)
	public void hello() {
		Reporter.log("hello",true);
	}
	@Test
	public void goodmorning() {
		Reporter.log("goodmorning",true);
	}
	@Test
	public void goodafternoon() {
		Reporter.log("goodafternoon",true);
	}
	@Test
	public void goodevening() {
		Reporter.log("goodevening",true);
	}

}
