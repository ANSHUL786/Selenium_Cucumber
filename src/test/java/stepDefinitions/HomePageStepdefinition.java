package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestSetup;

public class HomePageStepdefinition {

	TestSetup testSetup;
	//dependency Injection
	public HomePageStepdefinition(TestSetup testSetup) {
		this.testSetup=testSetup;	
	}
	
	@Given("User is at Website homepage")
	public void user_is_at_website_homepage() {

		testSetup.baseTest.goToUrl();
		
	}

	@When("User search with partial product name {string}")
	public void user_search_with_partial_product_name(String partialName) {

		testSetup.pom.getHomePage().typeToSearchBox(partialName);
	}

	@Then("{string} should be shown among all results")
	public void tomoto_should_be_shown_in_all_results(String productName) {
		testSetup.pom.getHomePage().validateProductIsPresent(productName);

	}

	

}
