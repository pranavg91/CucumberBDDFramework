package utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public  class CommonUtilis {
	
	public static String generateEmail() {

		String email = "user" + System.currentTimeMillis() + "@example.com";
		return email;

	}

	public static Properties loadPropertiesFile() {
		Properties prop = new Properties();
		FileReader fr = null;
		try {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\ProjectConfig.properties");
			prop.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	

}
