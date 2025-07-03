package BrowserManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import HelperLayer.BrowserManager;

public class FireFoxDriverManager implements BrowserManager{
	private static final Logger logger = LogManager.getLogger(FireFoxDriverManager.class);

	@Override
	public WebDriver browserinitialization() {
		logger.info("Browser initialization of fire fox driver from fire fox manager");
		return new FirefoxDriver();
	}

}
