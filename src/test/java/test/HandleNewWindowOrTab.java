package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNewWindowOrTab {

	@Test
	public void handleNewWindowOrTab() throws InterruptedException {

		// Set Chrome as defualt
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Go to Yahoo site
		driver.get("https://www.yahoo.com/");
		// Type xpath in search-box
		driver.findElement(By.id("uh-search-box")).sendKeys("xpath");
		// Click on the search button
		driver.findElement(By.id("uh-search-button")).click();
		// use Thread sleep because the driver very quick moving to the new site.
		Thread.sleep(2000);
		// Click the link "XPath Tutorial - w3schools.com"
		driver.findElement(By.linkText("XPath Tutorial - w3schools.com")).click();

		// This will print all the window handles(which are unique numbers)
		System.out.println(driver.getWindowHandles());

		// To loop around and end in the last window
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}

		Thread.sleep(2000);
		driver.findElement(By.linkText("SQL")).click();

	}

}

