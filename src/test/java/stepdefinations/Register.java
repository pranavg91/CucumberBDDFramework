package stepdefinations;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	WebDriver driver;     

	@And("user select Yes option for Newsletter")
	public void user_select_Yes_option_for_Newsletter() {
		

		driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();
	}

	@Given("User navigate to Register Account Page")
	public void user_navigate_to_register_account_page() {
		driver= DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

	}

	@When("User enter below fields")
	public void user_enter_below_fields(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(map.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));

	}

	@And("user select privacy policy field")
	public void user_select_privacy_policy_field() {

		driver.findElement(By.xpath("//input[@type='checkbox'][@value='1']")).click();

	}

	@And("User clicks on Contiue button")
	public void user_clicks_on_contiue_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@SuppressWarnings("deprecation")
	@Then("User should get logged in")
	public void user_should_get_logged_in() {

		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());

	}

	@And("User should be taken to account success page")
	public void user_should_be_taken_to_account_success_page() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}

	@And("Proper details should be displayed on the Account Success page")
	public void proper_details_should_be_displayed_on_the_account_success_page() {
		//

	}

	@When("User clicks on continue button on Account success page")
	public void user_clicks_on_continue_button_on_account_success_page() {
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}

	@Then("USer should be navigate to My Account Page")
	public void u_ser_should_be_navigate_to_my_account_page() {
		Assert.assertEquals("My Account", driver.getTitle());

	}

	public static String generateEmail() {

		String email = "user" + System.currentTimeMillis() + "@example.com";
		return email;

	}

}
