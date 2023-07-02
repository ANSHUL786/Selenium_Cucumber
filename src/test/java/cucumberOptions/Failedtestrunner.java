package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="@target/failedCucumbertests.txt",glue="stepDefinitions",
monochrome=true,plugin= {"html:target/cucumberreport2.html"})
public class Failedtestrunner extends AbstractTestNGCucumberTests {

}
