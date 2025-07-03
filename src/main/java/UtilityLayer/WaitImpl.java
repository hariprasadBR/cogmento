package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayerPackage.BaseClass;
import HelperLayer.IWait;

public class WaitImpl extends BaseClass implements IWait{

	@Override
	public WebElement visibilityOf(WebElement wb) {
		
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	}

	@Override
	public WebElement elementToBeClickable(WebElement wb) {
		// TODO Auto-generated method stub
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb));
	}

	@Override
	public List<WebElement> visibilityOfAllElements(List<WebElement> lists) {
		
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(lists));
	}

	@Override
	public Alert alertIsPresent() {
		
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
	}

}
