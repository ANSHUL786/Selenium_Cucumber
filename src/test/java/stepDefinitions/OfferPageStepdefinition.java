package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestSetup;

public class OfferPageStepdefinition {

	TestSetup testSetup;
	//dependency Injection
	public OfferPageStepdefinition(TestSetup testSetup) {
		this.testSetup=testSetup;	
	}
	
	@Given("User is at Offer Page")
	public void user_is_at_offer_page() {
		testSetup.baseTest.goToUrl();
		testSetup.pom.getOfferPage().clickOfferLink();
		testSetup.pom.getOfferPage().switchTochildWindow();
	}

	@When("^User search with partial product name (.+) on offer page$")
	public void user_search_with_partial_product_name_on_offer_page(String partialName) {
		testSetup.pom.getOfferPage().typeToSearchBox(partialName);		
	}

	@Then("^(.+) should be shown in offer list$")
	public void should_be_shown_in_offer_list(String productName) {
		testSetup.pom.getOfferPage().validateProductIsPresent(productName);
	}
}
