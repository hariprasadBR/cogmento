package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayerPackage.BaseClass;

public class CloginPage extends BaseClass{
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginButton;
	
	
     public CloginPage() {
    	 PageFactory.initElements(getDriver(), this);
     }
     
     public void loginFuncationality(String uname, String pword) {
    	 username.sendKeys(uname);
    	 password.sendKeys(pword);
    	 loginButton.click();
     }
	

}
