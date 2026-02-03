package HelperLayer;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utils.ConfigReader;

public class BrowserManager {

    WebDriver driver;

    public WebDriver initializeBrowser(String browser) {

        String runMode = ConfigReader.get("run.mode");

        if (runMode.equalsIgnoreCase("grid")) {
            driver = getRemoteDriver(browser);
        } else {
            driver = getLocalDriver(browser);
        }
        return driver;
    }

    // ---------------- LOCAL ----------------
    private WebDriver getLocalDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        throw new RuntimeException("Browser not supported: " + browser);
    }

    // ---------------- GRID ----------------
    private WebDriver getRemoteDriver(String browser) {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(browser);

            String platform = ConfigReader.get("platform");
            cap.setPlatform(Platform.fromString(platform.toUpperCase()));

            return new RemoteWebDriver(
                    new URL(ConfigReader.get("grid.url")),
                    cap
            );
        } catch (Exception e) {
            throw new RuntimeException("Grid execution failed", e);
        }
    }
}
