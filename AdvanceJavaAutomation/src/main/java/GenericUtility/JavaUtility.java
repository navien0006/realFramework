package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int randomNumber() {
		Random rand=new Random();
		int number = rand.nextInt(1000);
		return number;
		}
	
	public String currentDate() {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = sim.format(d);
		return currentDate;
		
		}
	
	public String expectedDate() {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,15);
		String expecteddate = sim.format(cal.getTime());
		return expecteddate;
	}
	
	public char RandomAlphbet() {
		Random rand=new Random();
		char letter;
		if(rand.nextBoolean()) {
			letter=(char)('A'+rand.nextInt(26));}
		else {
			letter=(char)('a'+rand.nextInt(26));}
		return letter;
		
	}
	

}
