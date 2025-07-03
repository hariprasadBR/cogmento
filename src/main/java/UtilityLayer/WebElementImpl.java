package UtilityLayer;

import org.openqa.selenium.WebElement;

import BaseLayerPackage.BaseClass;
import HelperLayer.IWebElement;

public class WebElementImpl extends BaseClass implements IWebElement{
	
	private WaitImpl wait = new WaitImpl();

	@Override
	public void click(WebElement wb) {
		
		wait.elementToBeClickable(wb).click();
	}

	@Override
	public void submit(WebElement wb) {
		wait.elementToBeClickable(wb).submit();
		
	}

	@Override
	public String getText(WebElement wb) {
		
		return wait.visibilityOf(wb).getText();
	}

	@Override
	public void sendKeys(WebElement wb, String value) {
		wait.visibilityOf(wb).sendKeys(value);
		
	}

	@Override
	public void clear(WebElement wb) {
		wait.visibilityOf(wb).clear();
		
	}

	@Override
	public String getAttribute(WebElement wb, String key) {
		
		return wait.visibilityOf(wb).getAttribute(key);
	}

	@Override
	public String getCssValue(WebElement wb, String key) {
		
		return wait.visibilityOf(wb).getCssValue(key);
	}

	@Override
	public boolean isDisplayed(WebElement wb) {
		
		return wait.visibilityOf(wb).isDisplayed();
	}

	@Override
	public boolean isSelected(WebElement wb) {
		
		return wait.visibilityOf(wb).isSelected();
	}

	@Override
	public boolean isEnabled(WebElement wb) {
		
		return wait.visibilityOf(wb).isEnabled();
	}

}
