package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectUtils.GeneralUtilities;

public class OfferPage extends GeneralUtilities {

	WebDriver driver;

	public OfferPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By offerLink = By.linkText("Top Deals");
	By searchBox = By.cssSelector("input[type='search']");
	By productNames = By.xpath("//tbody/tr/td[1]");

	public void typeToSearchBox(String name) {
		driver.findElement(searchBox).sendKeys(name);
	}
	
	public void clickOfferLink() {
		driver.findElement(offerLink).click();
	}
	public void validateProductIsPresent(String name) {
		waitUntilElementVisible(productNames,driver);
		List<WebElement> allSearchedProducts=driver.findElements(productNames);
		boolean result=allSearchedProducts.stream().anyMatch(s->s.getText().contains(name));
		Assert.assertTrue(result);
	}
}
