package pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

		WebDriver driver;

		@FindBy(xpath = "//input[@id='username']")
		WebElement userName;

		@FindBy(xpath = "//input[@id='password']")
		WebElement password;

		@FindBy(xpath = "//button[@type='submit' and text()='Sign in']")
		WebElement signInButton;

		public LoginPage(WebDriver driver) {

			this.driver = driver;
			PageFactory.initElements(driver, this);

		}

		public HomePage login(String UserName, String Password) {

			userName.sendKeys(UserName);
			password.sendKeys(Password);
			signInButton.click();

			return new HomePage(driver);

		}
	
}
