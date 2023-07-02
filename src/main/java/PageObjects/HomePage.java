package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectUtils.GeneralUtilities;

public class HomePage extends GeneralUtilities {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	By searchBox=By.cssSelector("input[type='search']");
	By productNames=By.xpath("//div[@class=\"product\"]/h4[@class=\"product-name\"]");
	
	
	
	public void typeToSearchBox(String name) {
		driver.findElement(searchBox).sendKeys(name);
	}
	
	public void validateProductIsPresent(String name) {
		waitUntilElementVisible(productNames,driver);
		List<WebElement> allSearchedProducts=driver.findElements(productNames);
		boolean result=allSearchedProducts.stream().anyMatch(s->s.getText().contains(name));
		Assert.assertTrue(result);
	}
}
