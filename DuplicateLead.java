package week2.day2.assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Email
9	Enter Email
10	Click find leads button
11	Capture name of First Resulting lead
12	Click First Resulting lead
13	Click Duplicate Lead
14	Verify the title as 'Duplicate Lead'
15	Click Create Lead
16	Confirm the duplicated lead name is same as captured name
17	Close the browser (Do not log out)*/

public class DuplicateLead {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement elementUserName = driver.findElement(By.name("USERNAME"));
		elementUserName.sendKeys("Demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.partialLinkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("hari@testleaf.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//div[@class ='x-grid3-cell-inner x-grid3-col-firstName']")).click();
		WebElement firstLead = driver.findElement(By.xpath("//div[@class ='x-grid3-cell-inner x-grid3-col-firstName']"));
		String lead = firstLead.getText();
		System.out.println("First Lead:\n\t"+ lead);
		driver.findElement(By.xpath("//div[@class ='x-grid3-cell-inner x-grid3-col-firstName']")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.xpath("(//input[@class ='smallSubmit'])")).click();
		WebElement capturedLead = driver.findElement(By.xpath("//span[@id ='viewLead_firstName_sp']"));
		String lead1 = capturedLead.getText();
		System.out.println("Captured Lead:\n\t"+ lead1);
		
	}

}
