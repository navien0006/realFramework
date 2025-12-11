package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	
	@Test
	public void a1() {
		Reporter.log("a1 is executed", true);
	}
	@Test
	public void A1() {
		Reporter.log("A1 is executed", true);

}
	@Test
	public void B1() {
		Reporter.log("B1 is executed", true);
	}
	@Test
	public void AA1() {
		Reporter.log("AA1 is executed", true);
	}
	@Test
	public void b1() {
		Reporter.log("b1 is executed", true);
	}
}
	
