package DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BrowserManager.ChromeManager;
import BrowserManager.EdgeManager;
import BrowserManager.FireFoxDriverManager;
import HelperLayer.BrowserManager;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	
	public static BrowserManager getDriver(String browsername) {
		logger.info("Creating the browsre instance"+browsername);
		
		switch(browsername.toLowerCase()){
			case "chrome":
			  return new ChromeManager();
			case "edge":
			   return new EdgeManager();
			case "firefox":
				return new FireFoxDriverManager();
			default:
				throw new IllegalArgumentException("Invalid browsername");
				
		}
		
		
	}

}
