package PageLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayerPackage.BaseClass;
import Reader.ExelReader;

public class LoginPage extends BaseClass {
	
@FindBy(id="email")
private WebElement usernametextbox;

@FindBy(id="pass")
private WebElement passwordtextbox;

public LoginPage(){
	PageFactory.initElements(getDriver(), this);
}
public void loginPageFunctionality(String username,String password) {
	usernametextbox.sendKeys(username);
	passwordtextbox.sendKeys(password);
}

}
