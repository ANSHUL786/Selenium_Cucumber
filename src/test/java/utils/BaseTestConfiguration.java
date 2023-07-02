package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTestConfiguration {

	WebDriver driver;
	String url;
	

	public WebDriver getDriver() throws IOException {

		if (driver == null) {
			Properties prop = new Properties();
			String path = System.getProperty("user.dir") + "/src/test/resources/globalvariable.properties";
			FileInputStream fis = new FileInputStream(path);

			prop.load(fis);

			String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
					: prop.getProperty("browser");
			System.out.println(browserName);

			url=prop.getProperty("baseurl");
			if (browserName.contains("chrome")) {
				ChromeOptions op = new ChromeOptions();
				if (browserName.contains("headless")) {
					op.addArguments("headless");

				}
				driver = new ChromeDriver(op);
				driver.manage().window().setSize(new Dimension(1440, 900));
			} else if (browserName.contains("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.contains("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}

		return driver;
	}

	public void goToUrl() {
		driver.get(url);
	}
	
}
