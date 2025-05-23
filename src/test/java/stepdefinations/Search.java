package stepdefinations;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilis.CommonUtilis;

public class Search {

	WebDriver driver;
	Properties prop;

	@Given("User in on the home page")
	public void user_in_on_the_home_page() {
		driver = DriverFactory.getDriver();
		prop = CommonUtilis.loadPropertiesFile();

	}

	@When("User enter exiting product into search box field")
	public void user_enter_exiting_product_into_search_box_field() {
		driver.findElement(By.name("search")).sendKeys(prop.getProperty("existingProduct"));
		

	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();

	}

	@Then("Product Should be displayed")
	public void product_should_be_displayed() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

	}

	@When("User enter no exiting product into search box field")
	public void user_enter_no_exiting_product_into_search_box_field() {
		driver.findElement(By.name("search")).sendKeys(prop.getProperty("nonexistingProduct"));
	}

	@Then("Product message Should be displayed")
	public void product_message_should_be_displayed() {
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(expectedMessage,
				driver.findElement(By.xpath("//*[text()='There is no product that matches the search criteria.']"))
						.getText());

	}

}
