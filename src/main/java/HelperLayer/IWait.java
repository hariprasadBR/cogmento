package HelperLayer;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public interface IWait {
	
	WebElement visibilityOf(WebElement wb);
	
	WebElement elementToBeClickable(WebElement wb);
	
	List<WebElement> visibilityOfAllElements(List<WebElement> lists);
	
	Alert alertIsPresent();

}
