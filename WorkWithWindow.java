package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class WorkWithWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//driver setup
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("https://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		// Click on Home Button
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		// Get Number of Windows opened				
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowhandle1 = driver.getWindowHandles(); // Use Set and List to store the window ID
		System.out.println(windowhandle1.size());
		List<String> list= new ArrayList<String>(windowhandle1);
		String parent = list.get(0);// Store Parent WindowID
		
		// Click Do not close button
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowhandle3= driver.getWindowHandles();
		
		List<String> windowhandle4 = new ArrayList<String>(windowhandle3);
		for(int i=1; i<=list.size();i++)// Use for loop to close all window except parent. Iteration starts with 1 (i=1) so that it will check starts with 2nd window while iterating so that parent window will exist
			
		{
			driver.switchTo().window(windowhandle4.get(i));
			driver.close();
		}
		// Switch to Parent
		driver.switchTo().window(parent);
		
		// Use Explicit wait
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("done");
	}
	
	
}


