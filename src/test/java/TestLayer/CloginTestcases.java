package TestLayer;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayerPackage.BaseClass;
import PageLayer.CloginPage;
import PageLayer.CreateNewContactPage;
import Reader.ExelReader;

@Listeners(ListenersLayer.Reports.class)
public class CloginTestcases extends BaseClass {
	@Parameters("browser")
	@BeforeTest
	public void setup(String broswername) {
		initialization(broswername,"url1");
	}
	
	@Test
	public void validateLoginFuncationality() {
		CloginPage login= new CloginPage();
		login.loginFuncationality("hariprasadnomula7@gmail.com", "Br@9892448818");
		
//		prafulp1010@gmail.com
//		Pr@ful0812
	}
	
	@Test(dataProvider="cogmentoData",dependsOnMethods = {"validateLoginFuncationality"} )
	public void validateCreateNewContactFuncationality(String firstName, String lastName, String emailId, String exptValue) throws InterruptedException {
		
		CreateNewContactPage create = new CreateNewContactPage();
		create.createNewContactFuncationality(firstName, lastName, emailId, exptValue);
	}
	
	@DataProvider(name="cogmentoData")
	public Object[][] dataReader() {
		Object[][] data = null;

	    try {
	        ExelReader reader = new ExelReader("cogmentoTest.xlsx", 0);
	        data = reader.getAllData();
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Optionally return empty data to prevent TestNG from crashing
	        return new Object[0][0];
	    }

	    return data;
		
	}
	


}
