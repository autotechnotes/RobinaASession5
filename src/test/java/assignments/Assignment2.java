package assignments;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	     // Automate the following test case:
		// Scenario: Users will be able to add deposit
	
	@Test
	public void userShouldBeAbleToAddDeposit() {
		
	// Set Chrome as a default browser
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe ");	
	//  Open Browser
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	// 1.go to site http://techfios.com/test/billing/?ng=admin/
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
	//  Element library
		WebElement usernameField = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		WebElement passwordField = driver.findElement(By.xpath("//input[contains(@type,'pass')]"));  //pass-partial text
		WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class,'success block')and @type='submit']"));
	//	WebElement addDepositButtonLocator = driver.findElement(By.linkText("Add Deposit")); 
		By addDepositButtonLocator = By.linkText("Add Deposit");
		By addDepositPanelHeaderLocator = By.xpath("//h5[contains(text(), 'Add Deposit')]");
	//	WebElement accountDropDown = driver.findElement(By.id("account"));  //id is from select element
	 
	//	2. Enter username: techfiosdemo@gmail.com
		usernameField.sendKeys("techfiosdemo@gmail.com");  		
	//  3. Enter password: abc123
		passwordField.sendKeys("abc123");
	//  4. Click login button
		signInButton.click();
	//  5. Click on Add Deposit button on Dashboard Page- need explicit wait for NoSuchWindowException on this Element
	//    Method to use Explicit wait on addDepositButton
		waitForElement(driver,10,addDepositButtonLocator);
	//   then Click	on addDepositButtonLocator
		driver.findElement(addDepositButtonLocator).click();
	//	Explicitly wait for the panel Header on the Add Deposit page
		waitForElement(driver,10,addDepositPanelHeaderLocator);		
	// 6. Click on Open An Account drop down to expand it,
		
	//	 Selecting using select class from DropDown
	//	Select select = new Select(accountDropDown);
	//	select.selectByValue("Syed");
	//	or 
	//	select.selectByIndex(2);
	// or	
	// 7. Click on any account name,
		driver.findElement(By.xpath("//select[@name='account']/option[@value='Syed']"));
	//	
	// 8. Type any description,
	// 9. Type any amount,
	// 10. Click on submit button,
	// Visually check to make sure the deposit posted

		
	 
	}
	
	public void waitForElement(WebDriver driver,int i,By by) {
		WebDriverWait wait = new WebDriverWait(driver,i); 
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		
		
	} 
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public void userShouldBeAbleToAddDeposit() throws InterruptedException {
//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//WebDriver driver = new ChromeDriver();
// driver.manage().window().maximize();
//driver.manage().deleteAllCookies();
//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//driver.get("http://techfios.com/test/billing/?ng=admin/");
// driver.get("https://www.facebook.com/");

// Element Library
//WebElement usernameField = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
//WebElement passwordField = driver.findElement(By.xpath("//input[contains(@type, 'pass')]"));
//WebElement signInButton = driver
////.findElement(By.xpath("//*[contains(@class, 'success block') and @type='submit']"));
// WebElement addDepositButton = driver.findElement(By.linkText("Add Deposit"));
// addDepositeButtonLocator = By.linkText("Add Deposit");
//By addDepositPanelHeaderLocator = By.xpath("//h5[contains(text(), 'Add Deposit')]");

//String expectedTitle = "Login - TechFios Test Application - Billing";
// actualTitle = driver.getTitle();

//if (expectedTitle.toLowerCase().contains(actualTitle.toLowerCase())) {
//System.out.println("Test Pass" + " Actual Title: " + actualTitle + " and Expected Title: " + expectedTitle
//+ " - Matched!!!");
//} else {
//System.out.println("Test Failed" + " Actual Title: " + actualTitle + " and Expected Title: " + expectedTitle
//+ " - Didn't Match!!!");
//throw new RuntimeException("Test Failed.");
//}

//usernameField.sendKeys("techfiosdemo@gmail.com");
//passwordField.sendKeys("abc123");
//signInButton.click();

// Explicit Wait
// WebDriverWait wait = new WebDriverWait(driver, 5);
// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addDepositeButtonLocator));

// Method to use Explicit wait
//waitForElement(driver, 10, addDepositeButtonLocator);

// click on add deposit button
//driver.findElement(addDepositeButtonLocator).click();

// Expilictly wait for Panel Header of the Add Deposit Page
//waitForElement(driver, 10, addDepositPanelHeaderLocator);

//boolean status = false;
//try {
//status = driver.findElement(addDepositPanelHeaderLocator).isDisplayed();
//} catch (NoSuchElementException e) {
//status = false;
//}

// Assertion to validate whether the Panel Header Displayed
//Assert.assertTrue("Add Deposit Page didn't Display", status);

//WebElement accountDropDown = driver.findElement(By.id("account"));

// Selecting using Select Class from DropDown
//Select select = new Select(accountDropDown);
// select.selectByValue("Rutu");
//select.selectByIndex(5);

// Generate Random number
//Random rnd = new Random();
//int randomNumber = rnd.nextInt(9999);
//String description = "Lunch" + randomNumber;
//String amount = String.valueOf(randomNumber * 3);

//driver.findElement(By.name("description")).sendKeys(description);
//driver.findElement(By.name("amount")).sendKeys(amount);
//driver.findElement(By.id("submit")).click();

//By firstTableDataLocator = By.xpath("//a[contains(text(), '" + description + "')]");
//waitForElement(driver, 20, firstTableDataLocator);

//System.out.println(description);
//System.out.println(driver.findElement(firstTableDataLocator).getText());

//assertEquals("Did not deposit!", description, driver.findElement(firstTableDataLocator).getText());

// driver.close();
// driver.quit();
//}

//private void waitForElement(WebDriver driver, int i, By by) {
//WebDriverWait wait = new WebDriverWait(driver, i);
//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//} /*


