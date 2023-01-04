package Saucedemo1;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
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
		driver.get("https://jqueryui.com/slider/");
		WebElement frames=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frames);
		WebElement  slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
	    Actions act=new Actions(driver);
	    Thread.sleep(2000);
	    act.dragAndDropBy(slider, 156, 12).perform();
	    driver.switchTo().parentFrame();
	    WebElement colorpicker=driver.findElement(By.linkText("Colorpicker"));
	    act.contextClick(colorpicker).perform();
}
}
