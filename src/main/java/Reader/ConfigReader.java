package Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	private static final Logger logger = LogManager.getLogger(ConfigReader.class);
	private  Properties prop;
	public ConfigReader() {
		logger.info("Loading the properties file");
		prop = new Properties();
		try{
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
	        prop.load(fis);
			}catch(IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to load a properties");
			}
	}
	
	public String getUrl(String urlkey) {
		logger.info("Fetching the url from properties file");
		return prop.getProperty(urlkey);
		
	}
	
	public String getString(String name) {
		logger.info("Fetching the "+name+" from properties file");
		return prop.getProperty(name);	
		}
}