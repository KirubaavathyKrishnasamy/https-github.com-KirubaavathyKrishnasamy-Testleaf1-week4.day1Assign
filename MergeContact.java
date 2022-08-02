package week4.day1;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
			driver.findElement(By.xpath("//table[@baseclass='dijitComboBoxNoArrow']/following::img")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println(windowHandles.size());
			List<String> windowhandles2 = new ArrayList<String>(windowHandles);
			String secondwindowHandle = windowhandles2.get(1);
			System.out.println(secondwindowHandle);
			driver.switchTo().window(secondwindowHandle);
			driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
			driver.switchTo().window(windowHandle);
			driver.findElement(By.xpath("//table[@baseclass='dijitComboBoxNoArrow']/following::img")).click();
			Set<String> windowHandles1 = driver.getWindowHandles();
			System.out.println(windowHandles1.size());
			List<String> windowhandles3 = new ArrayList<String>(windowHandles1);
			String secondwindowHandle1 = windowhandles3.get(1);
			System.out.println(secondwindowHandle1);
			driver.switchTo().window(secondwindowHandle1);
			driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
			driver.switchTo().window(windowHandle);
		   	
		
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			Alert alt = driver.switchTo().alert();
			alt.accept();
			System.out.println(driver.getTitle());
	}

}

