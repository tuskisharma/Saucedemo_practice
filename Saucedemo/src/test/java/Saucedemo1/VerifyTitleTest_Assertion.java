package Saucedemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleTest_Assertion {
	public static String browser = "chrome";
	public static WebDriver driver;

	@Test
	public void Titletest() {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		SoftAssert sofa=new SoftAssert();
		String expectedtitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		sofa.assertEquals(actualtitle, expectedtitle);
		String expectedtext="Search";
		String actualtext=driver.findElement(By.id("gh-btn")).getAttribute("value");
		sofa.assertEquals(actualtext, expectedtext);
		System.out.println(actualtext);
		sofa.assertAll();
		driver.close();
	}
}
