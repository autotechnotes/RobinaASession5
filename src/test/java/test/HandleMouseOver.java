package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleMouseOver {

	@Test
	public void handleMouseHover() {
		// set Chrome as defualt
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// Open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Go to https://www.dell.com/en-us?~ck=mn
		driver.get("https://www.dell.com/en-us?~ck=mn");
		// Hover over Products
		// Use Actions class to hover over something
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Products"))).build().perform();
		// Click on the Workstations
		// Use Explicit wait on the following Element
		waitForElement(driver, 15, By.linkText("Workstations"));
		driver.findElement(By.linkText("Workstations")).click();

	}

	    // Explicit wait encapsulated in a method
	    private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocater) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocater));

	}

}
