package week2.day2.assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main
* 1	Launch the browser
* 2	Enter the username
* 3	Enter the password
* 4	Click Login
* 5	Click crm/sfa link
* 6	Click Leads link
* 7	Click Find leads
* 8	Enter first name
* 9	Click Find leads button
* 10 Click on first resulting lead
* 11 Verify title of the page
* 12 Click Edit
* 13 Change the company name
* 14 Click Update
* 15 Confirm the changed name appears
* 16 Close the browser (Do not log out)*/

public class EditLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("DemoCSR");
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.className("crmsfa")).click();	
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=10241'])")).click();
		Thread.sleep(2000);
		System.out.println("The page title is  "+driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("MSV Foundations");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])")).click();
		driver.close();

		
	}

}
