package week2.day2.assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Pseudo Code
 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
 * 2. Enter UserName and Password Using Id Locator
 * 3. Click on Login Button using Class Locator
 * 4. Click on CRM/SFA Link
 * 5. Click on contacts Button
 * 6. Click on Create Contact
 * 7. Enter FirstName Field Using id Locator
 * 8. Enter LastName Field Using id Locator
 * 9. Enter FirstName(Local) Field Using id Locator
 * 10. Enter LastName(Local) Field Using id Locator
 * 11. Enter Department Field Using any Locator of Your Choice
 * 12. Enter Description Field Using any Locator of your choice 
 * 13. Enter your email in the E-mail address Field using the locator of your choice
 * 14. Select State/Province as NewYork Using Visible Text
 * 15. Click on Create Contact
 * 16. Click on edit button 
 * 17. Clear the Description Field using .clear
 * 18. Fill ImportantNote Field with Any text
 * 19. Click on update button using Xpath locator
 * 20. Get the Title of Resulting Page.*/

public class CreateContact {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.name("USERNAME")).sendKeys("Demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Baalaajee");
		driver.findElement(By.id("lastNameField")).sendKeys("Balakrushnan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Durai");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Venkgades");
		driver.findElement(By.name("departmentName")).sendKeys("MECH");
		driver.findElement(By.name("description")).sendKeys("Mechanical Engineering");
		driver.findElement(By.name("primaryEmail")).sendKeys("baalaajee98682@gmail.com");
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select state1 = new Select(state);
		state1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.partialLinkText("Edit")).click();
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Personal");
		driver.findElement(By.xpath("//input[@name ='submitButton']")).click();
		System.out.println("Page title is : \n\t" + driver.getTitle());
	    driver.close();
		
	}

}
