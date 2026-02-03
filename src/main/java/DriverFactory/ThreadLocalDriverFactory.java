package DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import HelperLayer.BrowserManager;

public class ThreadLocalDriverFactory {

    private static final Logger logger =
            LogManager.getLogger(ThreadLocalDriverFactory.class);

    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static WebDriver getDriver() {
        logger.info("Getting driver from ThreadLocal");
        return tl.get();
    }

    public static void setDriver(String browserName) {
        logger.info("Setting driver in ThreadLocal");
        BrowserManager manager = DriverFactory.getBrowser(browserName);
        tl.set(manager.initializeBrowser(browserName));
    }

    public static void quitDriver() {
        if (tl.get() != null) {
            tl.get().quit();
            tl.remove();
            logger.info("Driver quit & ThreadLocal cleaned");
        }
    }
}
