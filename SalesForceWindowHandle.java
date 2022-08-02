package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Launch URL
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		//Login With UserID and Password
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password$123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		//Click on Mobile Learn Button

		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		// Use set and List to navigate to second window
		Set<String> windowhandle1 = driver.getWindowHandles();
		System.out.println(windowhandle1.size());
		List<String> windowhandle2= new ArrayList<String>(windowhandle1);
		String getsecondwindow= windowhandle2.get(1);
		// Move Control to 2nd Window
		driver.switchTo().window(getsecondwindow);
		// Click Confirm Button
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String text = driver.getTitle();
		System.out.println(text);
		driver.close();
		
		//Switch to Parent Window
		driver.switchTo().window(windowhandle2.get(0));
		String text2 = driver.getTitle();
		System.out.println(text2);
		driver.close();// Close Browser

	}

}
