package TestLayer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayerPackage.BaseClass;
import DriverFactory.ThreadLocalDriverFactory;
import ListenersLayer.Reports;
import PageLayer.LoginPage;
import Reader.ExelReader;

public class LoginTestCases_old extends BaseClass {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browsername) {
		Reports report = new Reports();
		initialization(browsername,"url");
		this.driver=ThreadLocalDriverFactory.getDriver();

	}

	@Test(dataProvider="logindata")
	public void login(String username,String password) throws InterruptedException {
		Thread.sleep(3000);
		LoginPage page = new LoginPage();
//		ConfigReader reader = new ConfigReader();
//		String name=reader.getString("username");
//		String pass=reader.getString("password");

		
		page.loginPageFunctionality(username,password);
		
//		WebElement username=this.driver.findElement(By.id("email"));
		
//		username.sendKeys(name);
//		WebElement password = this.driver.findElement(By.id("pass"));
//		
//		password.sendKeys(pass);
	}
	@DataProvider(name="logindata")
	public Object[][] getDataFromExcel() throws IOException {
		ExelReader reader = new ExelReader("logintestdata.xlsx",0);
		Object[][] data=reader.getAllData();
		return data;
		}
}