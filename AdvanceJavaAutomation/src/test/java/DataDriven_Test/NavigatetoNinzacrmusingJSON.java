package DataDriven_Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NavigatetoNinzacrmusingJSON {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jsonparser=new JSONParser();
		FileReader fr=new FileReader("./\\src\\test\\resources\\Ninzacommondata.json");
	
		Object javaobj = jsonparser.parse(fr);
		JSONObject obj=(JSONObject)javaobj;
		String ninzurl = obj.get("url").toString();
		String ninzbrowser = obj.get("browser").toString();
		String ninzun = obj.get("username").toString();
		String ninzpw = obj.get("password").toString();
		
		WebDriver driver=null;
		if(ninzbrowser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(ninzbrowser.equals("edge")){
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ninzurl);
		driver.findElement(By.id("username")).sendKeys(ninzun);
		driver.findElement(By.id("inputPassword")).sendKeys(ninzpw);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.close();		

	}

}
