package tests;

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
				homePage = loginPage.login("XXXX@gmail.com", "XXXX");
			}

			@Test
			public void publishArticle() throws InterruptedException {
				writeArticlePage = new WriteArticlePage(driver);
				homePage.clickWriteArticle();
				writeArticlePage.writeHeader("Test Header2");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				writeArticlePage.writePara("Test Para2");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				writeArticlePage.publishArticle();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}

			@AfterTest
			public void logout() throws InterruptedException {
			}

			@AfterSuite
			public void quit() throws InterruptedException{
			homePage.logout();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.quit();
			}

	}
		
		

		
