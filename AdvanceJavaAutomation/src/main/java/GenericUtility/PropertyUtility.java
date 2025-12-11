package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	public String toReadDataFromProperiesFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("./src\\test\\resources\\cd.properties");
		Properties prop=new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
		
	}

}
