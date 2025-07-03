package BaseLayerPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.ThreadLocalDriverFactory;
import UtilityLayer.WebDriverImplements;

public class BaseClass extends ThreadLocalDriverFactory{
	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	public void initialization(String browsername, String urlkey) {
		logger.info("initialization from base class of browser"+browsername);
		WebDriverImplements  wd = new WebDriverImplements();
		wd.setwebDriver(browsername);
		wd.getwebDriver();
		wd.DeleteCookies();
		wd.implicitlyWaits();
		wd.maximize();
		wd.get(urlkey);

	
		
	}
	
	
		
	
	
}
