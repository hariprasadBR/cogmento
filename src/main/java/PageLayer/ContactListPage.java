package PageLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayerPackage.BaseClass;

public class ContactListPage extends BaseClass {

	@FindBy(xpath = "//span[@class='item-text' and text()='Contacts']")
	private WebElement contactlistIcon;

	@FindBys(@FindBy(xpath = "//tr[@class]"))
	private List<WebElement> rows;

	@FindBys(@FindBy(xpath = "//tr[@class]/child::td[2]//a"))
	private List<WebElement> names;
	
	@FindBys(@FindBy(xpath ="//tbody//tr[@class]/descendant::div"))
	private List<WebElement> checkboxes;
	
	@FindBy(xpath = "//button[@class='ui linkedin icon button']")
	private WebElement refreshbutton;
	
	public ContactListPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void loginlistfunctionality() throws InterruptedException {
		Thread.sleep(4000);
		contactlistIcon.click();
		Thread.sleep(4000);
		refreshbutton.click();
		Thread.sleep(4000);
		for (int i = 1; i <names.size(); i++) {
			
			String name = names.get(i).getText();
			System.out.println("===================="+name);
			if(name.contains("Hariprasad")) {
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(i))).click();
				
			}
			
				;
		}

	}

}
