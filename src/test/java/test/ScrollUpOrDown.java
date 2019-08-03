package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpOrDown {

	@Test
	public void scrollUpOrDown() throws InterruptedException {

		// Set Chrome as defualt
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// Open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Go to "https://www.yahoo.com/"
		driver.get("https://www.yahoo.com/");
		scrollDown(driver);
		Thread.sleep(2000);
		scrollUp(driver);
	}

	private void scrollDown(WebDriver a) {
		((JavascriptExecutor) a).executeScript("scroll(0,2000)");
	}

	private void scrollUp(WebDriver a) {
		JavascriptExecutor js = (JavascriptExecutor) a;
		js.executeScript("scroll,(2000,0)"); // its not scrolling fully up????
	}

}

//Actions action = new Actions(driver);
//driver.get("https://www.yahoo.com/");
//scrollDown(driver);
//Thread.sleep(2000);
//scrollUp(driver);
//}

//private void scrollDown(WebDriver a) {
//((JavascriptExecutor)a).executeScript("scroll(0,2000)");
//}
//private void scrollUp(WebDriver a) {
//JavascriptExecutor js = (JavascriptExecutor)a;
//js.executeScript("scroll(2000,0)");
//}