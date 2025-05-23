package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.ElementUtilities;

public class HomePage {

	WebDriver driver;
	ElementUtilities elementUtilities;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilities =  new ElementUtilities(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	private WebElement loginOption;
	
	public void selectLoginOption() {
		loginOption.click();
	}
	
	public RegisterPage selectRegisterOption(){
		elementUtilities.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}

	public void clickToMyAccountDropDownMenu() {
		elementUtilities.clickOnElement(myAccountDropMenu);
	
	}
	
	
}
