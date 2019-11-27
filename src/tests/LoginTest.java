package tests;

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

		import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.WriteArticlePage;
		public class LoginTest {

			WebDriver driver;
			LoginPage loginPage;
			HomePage homePage;
			WriteArticlePage writeArticlePage;

			@BeforeSuite
			public void launchapplication() {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cphanindra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.linkedin.com/login?");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			}

			@BeforeTest
			public void loginApplication() throws InterruptedException {
				loginPage = new LoginPage(driver);
				homePage = loginPage.login("phanisworld1@gmail.com", "Password@123");
			}

			@Test
			public void publishArticle() throws InterruptedException {
				writeArticlePage = new WriteArticlePage(driver);
				homePage.clickWriteArticle();
				writeArticlePage.writeHeader("Test Header2");
				Thread.sleep(2000);
				writeArticlePage.writePara("Test Para2");
				Thread.sleep(2000);
				writeArticlePage.publishArticle();
				Thread.sleep(2000);
			}

			@AfterTest
			public void logout() throws InterruptedException {
				//homePage.logout();
			}

			
			//homePage.logout();
			@AfterSuite
			//homePage.logout();
			public void quit(){
			driver.quit();
			}

	}
		
		
