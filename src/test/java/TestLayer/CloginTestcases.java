package TestLayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayerPackage.BaseClass;
import PageLayer.CloginPage;

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

}
