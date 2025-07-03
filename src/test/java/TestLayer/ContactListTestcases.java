package TestLayer;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseLayerPackage.BaseClass;
import PageLayer.ContactListPage;

@Listeners(ListenersLayer.Reports.class)
public class ContactListTestcases extends BaseClass{
	
	@Test
	public void contactListinterface() throws InterruptedException {
	
		ContactListPage  cLP = new ContactListPage();
		
		cLP.loginlistfunctionality();
	}

}
