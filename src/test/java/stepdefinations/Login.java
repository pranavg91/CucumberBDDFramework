package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login {

	WebDriver driver;

	@Given("User navigate to login page")

	public void user_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")).click();
	}

	@When("User enter valid email id and valid password into the fields")
	public void user_enter_valid_email_id_and_valid_password_into_the_fields() {
		driver.findElement(By.id("input-email")).sendKeys("amotooricap3@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should navigate to Account success page")
	public void user_should_navigate_to_account_success_page() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
		driver.quit();
	}

	@When("User enter Invalid email id and Invalid password into the fields")
	public void user_enter_invalid_email_id_and_invalid_password_into_the_fields() {
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-password")).sendKeys("12345");

	}

	@Then("User should not logged In")
	public void user_should_not_logged_in() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
		
		String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarningMessage, driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
	}

	public static String generateEmail() {

		String email = "user" + System.currentTimeMillis() + "@example.com";
		return email;

	}

}