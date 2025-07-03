package UtilityLayer;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.ThreadLocalDriverFactory;
import HelperLayer.IWebDriver;
import Reader.ConfigReader;

public class WebDriverImplements implements IWebDriver{
	private static final Logger logger = LogManager.getLogger(WebDriverImplements.class);

	private WebDriver driver;
	
	public void setwebDriver(String browsername) {
		logger.info("setting the webdriver"+browsername);
		ThreadLocalDriverFactory.setDriver(browsername);
		
		
	}
	public void getwebDriver() {
		logger.info("Getting the webdriver instance");
		 this.driver = ThreadLocalDriverFactory.getDriver();
	}
	@Override
	public void maximize() {
		logger.info("Maximizing the window");
		// TODO Auto-generated method stub
		this.driver.manage().window().maximize();
	}

	@Override
	public void implicitlyWaits() {
		logger.info("Adding the Synchronyzation");
		// TODO Auto-generated method stub
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@Override
	public void DeleteCookies() {
		logger.info("Clearing all the cookies");
		// TODO Auto-generated method stub
		this.driver.manage().deleteAllCookies();
	}

	@Override
	public void get(String urlkey) {
		logger.info("Launching the url");
		ConfigReader reader=new ConfigReader();
		String url=reader.getUrl(urlkey);
		this.driver.get(url);
	}

}