package Saucedemo1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles1 {
	public static String url = "https://www.saucedemo.com/";
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/in/");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div/a")).click();
		Set<String> window=driver.getWindowHandles();
		System.out.println(window);
		
		Iterator<String> iterator=window.iterator();
		String wind1=iterator.next();
		String wind2=iterator.next();
		driver.switchTo().window(wind2);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("tushar");
		driver.findElement(By.name("UserLastName")).sendKeys("messi");
		driver.switchTo().window(wind1);
}
}
