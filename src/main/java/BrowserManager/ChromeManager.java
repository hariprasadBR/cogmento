package BrowserManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HelperLayer.BrowserManager;

public class ChromeManager implements BrowserManager {
private static final Logger logger = LogManager.getLogger(ChromeManager.class);

	@Override
	public WebDriver browserinitialization() {
		logger.info("Browser initialization of chrome driver from chromemanager");

		return new ChromeDriver();
	}

}
