package DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import HelperLayer.BrowserManager;

public class ThreadLocalDriverFactory {
	private static final Logger logger = LogManager.getLogger(ThreadLocalDriverFactory.class);
 
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		logger.info("Instance getting from threadlocal");
		return tl.get();
	}
	
	public static void setDriver(String browsername) {
		logger.info("Instance setting from threadlocal");
		BrowserManager driverManager=DriverFactory.getBroswer(browsername);
		tl.set(driverManager.browserinitialization());
		
	}
	public static void quitDriver() {
    if (tl.get() != null) {
        tl.get().quit();   // closes browser
        tl.remove();       // removes thread reference ✅
        logger.info("Driver quit and ThreadLocal cleaned");
    }
}
}
