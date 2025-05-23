package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.tr.Fakat;
import utilis.ElementUtilities;

public class RegisterPage {

	WebDriver driver;
	ElementUtilities elementUtilities;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilities = new ElementUtilities(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(css = "input[name='newsletter'][value='1']")
	private WebElement yesNewsLetterOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement ContinueButton;

	@FindBy(xpath = "//*[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//*[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//*[@name='email']//following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//*[@name='telephone']//following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//*[@name='password']//following-sibling::div")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//input[@type='checkbox'][@value='1']")
	WebElement privacyPolicyField;

//	public String getPasswordWarningMessage() {
//		return elementUtility.getElementText(passwordWarningMessage);
//		//return passwordWarningMessage.getText();
//	}
//
//	public String getTelephoneWarningMessage() {
//		return elementUtility.getElementText(telephoneWarningMessage);
//		//return telephoneWarningMessage.getText();
//	}
//
//	public String getEmailWarningMessage() {
//		return elementUtility.getElementText(emailWarningMessage);
//		//return emailWarningMessage.getText();
//	}
//
//	public String getLastNameWarningMessage() {
//		return elementUtility.getElementText(lastNameWarningMessage);
//		//return lastNameWarningMessage.getText();
//	}
//
//	public String getFirstNameWarning() {
//		return elementUtility.getElementText(firstNameWarningMessage);
//		//return firstNameWarningMessage.getText();
//	}
//
	public AccountSuccessPage clickOnContinueButton() {
		elementUtilities.clickOnElement(ContinueButton);
		return new AccountSuccessPage(driver);
	}

	public void selectPrivacyPolicyfield() {
		elementUtilities.clickOnElement(privacyPolicyField);
		// privacyPolicyField.click();
	}

	public void selectYesForNewsletterOption() {
		elementUtilities.clickOnElement(yesNewsLetterOption);
		// yesNewsLetterOption.click();
	}

	public void enterConfirmPasswordField(String confirmPasswordtext) {
		elementUtilities.enterTextIntoElement(confirmPassword, confirmPasswordtext);
		// confirmPassword.sendKeys(confirmPasswordtext);
	}

	public void enterPasswordField(String passwordtext) {
		elementUtilities.enterTextIntoElement(passwordField, passwordtext);
		// passwordField.sendKeys(passwordtext);
	}

	public void enterTelephoneField(String telephonetext) {
		elementUtilities.enterTextIntoElement(telephoneField, telephonetext);
		// telephoneField.sendKeys(telephonetext);
	}

	public void enterEmailField(String emailText) {
		elementUtilities.enterTextIntoElement(emailField, emailText);
		// emailField.sendKeys(emailText);

	}

	public void enterLastNameField(String lastNameText) {
		elementUtilities.enterTextIntoElement(lastNameField, lastNameText);
		// lastNameField.sendKeys(lastNameText);
	}

	public void enterFirstNameField(String firstNameText) {
		elementUtilities.enterTextIntoElement(firstNameField, firstNameText);
		//firstNameField.sendKeys(firstNameField);
	}

}
