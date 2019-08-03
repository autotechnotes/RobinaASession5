package assignments;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmScenario {
	     
	     // Automate the following test case:
		// Scenario: CRM -> Add Contact - Add contact and validate contact added in List Contacts

	@Test
	public void ValidateContactAdded() throws InterruptedException {
		//Set Chrome as default
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		//Open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		// 1. Go to site http://techfios.com/test/billing/?ng=admin/
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// 2. Enter username: techfiosdemo@gmail.com
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(2000);
		// 3. Enter password: abc123
		driver.findElement(By.name("password")).sendKeys("abc123");
		Thread.sleep(2000);
		// 4. Click login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// 5. Click on CRM in the Side Navigation
		// Use Explicit wait on CRM before click
		waitForElement(driver, 40, By.linkText("CRM"));
		driver.findElement(By.linkText("CRM")).click();
		// 6. Click on Add Contact
		driver.findElement(By.xpath("//a[contains(text(),'Add Contact')]")).click();
		// 7. Fill in the Add Contact Form,
		driver.findElement(By.id("account")).sendKeys("David Joe");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='company']")).sendKeys("Sprint");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("DavidJ@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("phone")).sendKeys("9723366600");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("5501 Dublin St");
		Thread.sleep(2000);
		driver.findElement(By.id("city")).sendKeys("Irving");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text'and@name='state']")).sendKeys("Texas");
		Thread.sleep(2000);
		driver.findElement(By.name("zip")).sendKeys("76099"); // do we use select class to select other state????
		// 8. Click submit,
		driver.findElement(By.cssSelector("button[id='submit']")).click();
		// 9. Go to CRM -> List Contact Page
		driver.findElement(By.xpath("//a[contains(text(),'List Contact')]")).click();
		Thread.sleep(2000);
		// 10. Search for the new contact in the search field,
		driver.findElement(By.name("name")).sendKeys("Mary");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		// 11. Validate contact created
		// waitForElement(driver,40,By.xpath("//span[contains(text(),'David Joe')]"));

	}

	private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));
	}

}
