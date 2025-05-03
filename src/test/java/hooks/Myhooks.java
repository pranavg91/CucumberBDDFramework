package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Myhooks {

	WebDriver driver;

	@Before
	public void setup() {

		driver =DriverFactory.openBrowserAndApplicationURL();
	}
	@After
	public void teardown() {
		driver.quit();
	}

}
