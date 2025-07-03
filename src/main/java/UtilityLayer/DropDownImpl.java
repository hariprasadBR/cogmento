package UtilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseLayerPackage.BaseClass;
import HelperLayer.IDropDown;

public class DropDownImpl extends BaseClass implements IDropDown {

	private WaitImpl wait = new WaitImpl();
	private WebElementImpl webElement = new WebElementImpl();

	@Override
	public void selectByVisibleText(WebElement wb, String visibleText) {
		new Select(wait.visibilityOf(wb)).selectByVisibleText(visibleText);

	}

	@Override
	public void selectByValue(WebElement wb, String value) {
		new Select(wait.visibilityOf(wb)).selectByValue(value);

	}

	@Override
	public void selectByIndex(WebElement wb, int index) {
		new Select(wait.visibilityOf(wb)).selectByIndex(index);

	}

	@Override
	public void withouthSelectClass(List<WebElement> list, String exptValue) {
		for (WebElement li : list) {
			String actualText = webElement.getText(li);
			if (actualText.equals(exptValue)) {
				webElement.click(li);
				break;
			}

		}

	}

}
