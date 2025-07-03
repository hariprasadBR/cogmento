package BrowserManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import HelperLayer.BrowserManager;

public class EdgeManager implements BrowserManager {
	private static final Logger logger = LogManager.getLogger(EdgeManager.class);

	@Override
	public WebDriver browserinitialization() {
		logger.info("Browser initialization of edge driver from edge manager");


		return new EdgeDriver();
	}

}
