package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUpTest {
	@Test
	public void handlePopUp() throws InterruptedException {
		// Set Chrome as defualt
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// Open the browser
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Go to the Rediff Site
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		// Click on the go button
		driver.findElement(By.xpath("//input[@name='FormName']/following-sibling::div/descendant::input[@value='Go']"))
				.click();
		Thread.sleep(3000);
		// Close the popUp
		driver.switchTo().alert().accept();

	}

}
