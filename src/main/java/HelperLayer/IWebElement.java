package HelperLayer;

import org.openqa.selenium.WebElement;

public interface IWebElement {
	
	void click(WebElement wb);
	
	void submit(WebElement wb);
	
	String getText(WebElement wb);
	
	void sendKeys(WebElement wb, String value);
	
	void clear(WebElement wb);
	
	String getAttribute(WebElement wb, String key);
	
	String getCssValue(WebElement wb, String key);
	
	boolean isDisplayed(WebElement wb);
	
	boolean isSelected(WebElement wb);
	
	boolean isEnabled(WebElement wb);
	
	

}
