package HelperLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IDropDown {
	
	
	void selectByVisibleText(WebElement wb, String visibleText);
	
	void selectByValue(WebElement wb, String value);
	
	void selectByIndex(WebElement wb, int index);
	
	void withouthSelectClass(List<WebElement> list, String exptValue);

}
