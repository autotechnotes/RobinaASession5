package assignments;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	//Build the following automation:		Steps:
		//1. Go to http://objectspy.space
		//2. Type First Name, Last Name, & Password,
		//3. Click on the Open Window button.
	 @Test
	 public void validUserShouldAbleToAccessTheSite() {
		 System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		 
		 //open chrome browser
		 WebDriver Driver = new ChromeDriver();
		 //go to the objectspy.space page
		 Driver.get("http://objectspy.space/");
		 //Type First Name
		 Driver.findElement(By.name("firstname")). sendKeys("Robina");
		 //Type Last Name
		 Driver.findElement(By.name("lastname")).sendKeys("Afreen");
	    //	Type Password
		 Driver.findElement(By.name("Password")).sendKeys("abc");
		 // Click on open window button
		 Driver.findElement(By.id("submit")).click();
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 } 
	
	
	
	
	
	
	
	
	

}
