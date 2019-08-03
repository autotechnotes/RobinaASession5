package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	@Test
	public void validUsersShouldBeAbleToLogIn() throws InterruptedException {
		// Set Chrome as default browser
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Thread.sleep(2000);
		// Open Chrome Browser
		WebDriver Driver = new ChromeDriver();
		Thread.sleep(2000);
		// Go to TechFios Website
		Driver.get("http://techfios.com/test/billing/?ng=admin/");
		Thread.sleep(2000);
		// Type username in the username field
		Driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(2000);
		// Type password in the password field
		Driver.findElement(By.name("password")).sendKeys("abc123");
		Thread.sleep(2000);
		// Click on Sign In button
		Driver.findElement(By.name("login")).click();
		// Dashboard page should display

	}

	@Test
	public void invalidUsersShouldBeAbleToLogIn() {
		// Set Chrome as default browser
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// Open Chrome Browser
		WebDriver driver = new ChromeDriver();
		// Go to TechFios Website
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// Type username in the username field
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		// Type password in the password field
		driver.findElement(By.name("password")).sendKeys("abc123");
		// Click on Sign In button
		driver.findElement(By.name("login")).click();

	}

}
