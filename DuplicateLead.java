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
	
	public static void main(String[] args) throws InterruptedException {
		
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
		driver.findElement(By.name("emailAddress")).sendKeys("sharath@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		WebElement firstLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a"));
		String capturedLead = firstLead.getText();
		System.out.println("First Lead is Captured: \t "+capturedLead);
		firstLead.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Title: \t Duplicate Lead");
		}else {
			System.out.println("Title: \t Not Duplicate Lead");
		}
		driver.findElement(By.xpath("(//input[@class ='smallSubmit'])")).click();
		WebElement duplicateLead = driver.findElement(By.xpath("//span[@id ='viewLead_firstName_sp']"));
		String lead = duplicateLead.getText();
		System.out.println("Captured Duplicate Lead: \t "+ lead);
		if(capturedLead.equals(lead)) {
	    	System.out.println("Duplicated lead name = Captured name");
	    }else {
	    	System.out.println("Duplicated lead name != Captured name");
	    }
		driver.close();		
	}

}
