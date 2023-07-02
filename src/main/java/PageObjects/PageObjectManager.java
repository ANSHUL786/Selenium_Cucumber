package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	HomePage homePage;
	OfferPage offerPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		homePage=new HomePage(driver);
		return homePage;
	}
	public OfferPage getOfferPage() {
		offerPage=new OfferPage(driver);
		return offerPage;
	}
}
