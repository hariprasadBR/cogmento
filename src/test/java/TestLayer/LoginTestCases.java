package TestLayer;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayerPackage.BaseClass;
import PageLayer.LoginPage;
import Reader.ExelReader;

@Listeners(ListenersLayer.Reports.class)
public class LoginTestCases extends BaseClass {

    @Parameters("browser")
    @BeforeTest
    public void setup(String browsername) {
        initialization(browsername,"url1"); // From BaseClass
    }

    @Test(dataProvider = "logindata")
    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(2000); // Try to replace with explicit wait if possible
        LoginPage page = new LoginPage();
        page.loginPageFunctionality(username, password);
    }

    @DataProvider(name = "logindata")
    public Object[][] getDataFromExcel() throws IOException {
        ExelReader reader = new ExelReader("logintestdata.xlsx", 0);
        return reader.getAllData();
    }
}
