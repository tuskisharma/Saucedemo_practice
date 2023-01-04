package Saucedemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTests_JSExecutor {
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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String script="return document.title;";
		String title=(String) jse.executeScript(script);
		System.out.println(title);
		
		driver.switchTo().frame("iframeResult");
		jse.executeScript("myFunction()");
		//Thread.sleep(2000);		
		driver.switchTo().alert().accept();
		
		WebElement    button=driver.findElement(By.xpath("/html/body/button"));
		Thread.sleep(2000);
		jse.executeScript("arguments[0].style.border='7px solid red'", button);
		
		driver.navigate().to("https://www.w3schools.com/");
		WebElement certified=driver.findElement(By.linkText("CSS Reference"));
		Thread.sleep(2000);
		jse.executeScript("arguments[0].scrollIntoView(true);", certified);
}
}
