package Saucedemo1;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWait {
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
		driver.get("https://www.ebay.com/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement element=driver.findElement(By.linkText("Electronics"));
	    Actions act=new Actions(driver);
	    act.moveToElement(element).perform();
	    WebDriverWait wait=new WebDriverWait(driver, 5);
	    //WebElement element2=driver.findElement(By.linkText("Apple"));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple"))).click();
	    
	    
}
}
