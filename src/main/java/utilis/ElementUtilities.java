package utilis;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtilities {

	WebDriver driver;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}

	}

	public void enterTextIntoElement(WebElement element, String text) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(text);
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch (Exception e) {
			b = false;
		}
		return b;

	}

	public String getStringText(WebElement element) {
		String text = "";
		if(element.isDisplayed()) {
		text = element.getText();
		}
		return text;

	}

}