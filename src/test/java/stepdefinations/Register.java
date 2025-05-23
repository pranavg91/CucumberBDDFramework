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
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	WebDriver driver;
	RegisterPage registerPage;
	HomePage homePage;
	AccountSuccessPage accountSuccessPage;
	MyAccountPage myAccountPage;

	@And("user select Yes option for Newsletter")
	public void user_select_Yes_option_for_Newsletter() {
		registerPage.selectYesForNewsletterOption();
	}

	@Given("User navigate to Register Account Page")
	public void user_navigate_to_register_account_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickToMyAccountDropDownMenu();
		registerPage = homePage.selectRegisterOption();

	}

	@When("User enter below fields")
	public void user_enter_below_fields(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		registerPage.enterFirstNameField(map.get("firstName"));
		registerPage.enterLastNameField(map.get("lastName"));
		registerPage.enterEmailField(generateEmail());
		registerPage.enterTelephoneField(map.get("telephone"));
		registerPage.enterPasswordField(map.get("password"));
		registerPage.enterConfirmPasswordField(map.get("password"));

	}

	@And("user select privacy policy field")
	public void user_select_privacy_policy_field() {
		registerPage.selectPrivacyPolicyfield();

	}

	@And("User clicks on Contiue button")
	public void user_clicks_on_contiue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@SuppressWarnings("deprecation")
	@Then("User should get logged in")
	public void user_should_get_logged_in() {

		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());

	}

	@And("User should be taken to account success page")
	public void user_should_be_taken_to_account_success_page() {

		Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());
	}

	@And("Proper details should be displayed on the Account Success page")
	public void proper_details_should_be_displayed_on_the_account_success_page() {
		// Assert.assertTrue(account);

	}

	@When("User clicks on continue button on Account success page")
	public void user_clicks_on_continue_button_on_account_success_page() {
		myAccountPage = accountSuccessPage.clickOnContinueButton();
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