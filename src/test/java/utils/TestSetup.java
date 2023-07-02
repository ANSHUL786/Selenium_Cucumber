package utils;

import java.io.IOException;
import PageObjects.PageObjectManager;

public class TestSetup {
	public BaseTestConfiguration baseTest;
	public PageObjectManager pom;
	
	public TestSetup() throws IOException {
		baseTest=new BaseTestConfiguration();
		pom = new PageObjectManager(baseTest.getDriver());
		
		
	}
	
}
