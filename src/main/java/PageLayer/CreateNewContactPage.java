package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayerPackage.BaseClass;
import UtilityLayer.DropDownImpl;

public class CreateNewContactPage extends BaseClass {
	private DropDownImpl dropdown = new DropDownImpl();
	
	@FindBy(xpath = "//i[@class='users icon']")
	private WebElement contactIcon;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement crateButton;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='value']")
	private WebElement emailId;

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div/child::i[@class='dropdown icon']")
	private WebElement status;

	@FindBys(@FindBy(xpath = "//div[@name='status']/child::span"))
	private List<WebElement> statusList;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	
	

	public CreateNewContactPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void createNewContactFuncationality(String firstName, String lastName, String emailId, String exptValue)
			throws InterruptedException {
		Thread.sleep(4000);
		contactIcon.click();
		crateButton.click();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.emailId.sendKeys(emailId);
		this.status.click();

		Thread.sleep(4000);

//		for (Iterator<WebElement> iterator = statusList.iterator(); iterator.hasNext();) {
//			WebElement webelement = (WebElement) iterator.next();
//			String actualText = ((WebElement) iterator.next()).getText();
//
//			if (actualText.equals(exptValue)) {
//				webelement.click();
//				break;
//			}
//
//		}
		
		dropdown.withouthSelectClass(statusList, exptValue);

		Thread.sleep(4000);
		saveButton.click();

		
	}

}
