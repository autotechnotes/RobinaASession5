package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousLocatorsAndElements {

	@Test
	public void VariousLocatorsAndElements() throws InterruptedException {
		// Set Chrome as default browser
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Thread.sleep(2000);
		// Open Chrome Browser
		WebDriver Driver = new ChromeDriver();
		Thread.sleep(2000);
		// Go to TechFios Website
		Driver.get("http://objectspy.space/");
		Thread.sleep(2000);

		// clear the search field
		Driver.findElement(By.className("search")).clear();

		// Type techfios on search
		// Driver.findElement(by)

	}
}