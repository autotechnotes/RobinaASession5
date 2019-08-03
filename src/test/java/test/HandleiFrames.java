package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleiFrames {

	@Test
	public void userShouldAbleToAcessSerializableLink() {

		// set chrome as defualt
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// open browser
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Go to the Oracle site
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		// Switch by index
		// driver.switchTo().frame(0);
		// Switch by name
		driver.switchTo().frame("packageListFrame");
		// Click on the java.awt.color link
		driver.findElement(By.linkText("java.awt.color")).click();
		// Move the driver to the default location
		driver.switchTo().defaultContent();
		// Switch the driver to the frame(2) with index
		driver.switchTo().frame(1);
		// Click on the ColorSpace link
		// Before click put explicit wait on the following element
		waitForElement(driver, 40, By.linkText("ColorSpace"));
		driver.findElement(By.linkText("ColorSpace")).click();
		// Move to the defualt location
		driver.switchTo().defaultContent();
		// Switch the driver to the frame(3)
		driver.switchTo().frame(2);
		// Click on the Serializable link
		driver.findElement(By.linkText("Serializable")).click();
		// Validate "Interface Serializable" showed
		// To validate use explicit wait on the following Element
		By interfaceSerializableLocator = By.xpath("//h2[contains(text(),'Interface Serializable')]");
		waitForElement(driver, 30, interfaceSerializableLocator);

	}

	// Explicit wait encapsulated in a method
	private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));

	}

}
