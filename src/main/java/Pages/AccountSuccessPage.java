package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.ElementUtilities;

public class AccountSuccessPage {

	WebDriver driver;
	ElementUtilities elementUtilies;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilies = new ElementUtilities(driver);

	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logoutOption;

	@FindBy(xpath = "//*[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountsuccessBreadCrumb;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueButton;

	@FindBy(id = "content")
	private WebElement accountSuccessPageContent;

	public String getAccountSuccessPageContent() {
		return elementUtilies.getStringText(accountSuccessPageContent);
	}

	public MyAccountPage clickOnContinueButton() {
		elementUtilies.clickOnElement(continueButton);
		return new MyAccountPage(driver);
	}

	public boolean didWeNavigateToAccountSuccessPage() {
		return elementUtilies.isElementDisplayed(accountsuccessBreadCrumb);
		// return accountsuccessBreadCrumb.isDisplayed();
	}

	public boolean isUserLoggedIn() {
		return elementUtilies.isElementDisplayed(logoutOption);
		// return logoutOption.isDisplayed();
	}
}
