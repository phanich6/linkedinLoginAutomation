package pages;

	
	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class WriteArticlePage {

	
		WebDriver driver;

		@FindBy(xpath = "//textarea[@placeholder='Headline']")
		WebElement Headline;

		@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
		WebElement writingSpace;

		@FindBy(xpath = "//span[text()='Publish']")
		WebElement Publish;

		@FindBy(xpath = "//button[@data-control-name='share.post']//span[text()='Publish']")
		WebElement Publish_Share;

		public WriteArticlePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void writeHeader(String header) {
			Headline.sendKeys(header);
		}

		public void writePara(String para) {
			writingSpace.sendKeys(para);

		}
		public void publishArticle() {
			Publish.click();
			Publish_Share.click();
			driver.findElement(
					By.xpath("//div[@aria-labelledby='post-publish-modal__header']//li-icon[@type='cancel-icon']")).click();
		}
	}



