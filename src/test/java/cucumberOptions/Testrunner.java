package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/java/featureFiles",glue={"stepDefinitions","Hooks"},
monochrome=true,dryRun=false,
plugin= {"html:target/cucumberreport.html","rerun:target/failedCucumbertests.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Testrunner extends AbstractTestNGCucumberTests {

}
