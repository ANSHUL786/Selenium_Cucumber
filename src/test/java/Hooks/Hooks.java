package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestSetup;

public class Hooks {

	TestSetup testSetup;
	public Hooks(TestSetup testSetup) {
		this.testSetup=testSetup;
	}
	
	
	@AfterStep
	public void screenShots(Scenario scenario) throws  IOException {
		WebDriver driver=testSetup.baseTest.getDriver();
		//Extra properties
		//ExtentCucumberAdapter.addTestStepLog("Heelo");	
		//ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "fghjk");
		//ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("My Label", ExtentColor.PINK));

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileSrc=FileUtils.readFileToByteArray(src);
		scenario.attach(fileSrc, "image/png","image");
		
	}
	
	
	
	
	@After
	public void tearDown() throws IOException {
		testSetup.baseTest.getDriver().quit();
	}
	
}
