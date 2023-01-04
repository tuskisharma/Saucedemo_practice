package Saucedemo1;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {
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
		driver.get("https://extendsclass.com/text-compare.html");
		WebElement sourcetext=driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.keyDown(sourcetext, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement desttext=driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]"));
		Thread.sleep(2000);
		act.keyDown(desttext, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
}
}
