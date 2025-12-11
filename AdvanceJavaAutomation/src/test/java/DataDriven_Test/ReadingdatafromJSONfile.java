package DataDriven_Test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingdatafromJSONfile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparse=new JSONParser();
		FileReader fr=new FileReader("./src\\test\\resources\\commandata.json");
		Object javaobject = jsonparse.parse(fr);
		JSONObject obj=(JSONObject)javaobject;
		String value = obj.get("browser").toString();
			System.out.println(value);
			
		}
		
	}


