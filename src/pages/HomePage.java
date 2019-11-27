package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Write an article']")
	WebElement writeArticleLink;

	@FindBy(xpath = "//button[@data-control-name='nav.settings']")
	WebElement Settings;

	@FindBy(xpath = "//a[@data-control-name='nav.settings_signout']")
	WebElement SignOut;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WriteArticlePage clickWriteArticle() {

		writeArticleLink.click();
		Set<String> handles = driver.getWindowHandles();
		for (String win : handles) {
			driver.switchTo().window(win);
		}
		return new WriteArticlePage(driver);
	}

	public void logout() throws InterruptedException {
		Settings.click();
		SignOut.click();

	}
}
