package PageObjectUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	WebDriver driver;
	WebDriverWait wait;
	String parentId;
	public GeneralUtilities(WebDriver driver) {
		this.driver=driver;
	}

	public void waitUntilElementVisible(By ele,WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
		
	}

	public void switchTochildWindow() {
		Set<String> handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		 parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
	}
	
	public void SwitchToParent() {
		driver.switchTo().window(parentId);
	}
}
