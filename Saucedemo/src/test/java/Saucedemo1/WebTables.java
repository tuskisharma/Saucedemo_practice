package Saucedemo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
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
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> row= driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
		System.out.println(row.size());
		int rowsize=row.size();
		
		List<WebElement> col1=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
		int col=col1.size();
		System.out.println(col);
		List<WebElement> column=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td"));
		System.out.println(column.size());
		int colsize=column.size();
		
		for(int i=1;i<=rowsize;i++) {
			for(int u=1;u<=col;u++) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/th["+u+"]")).getText());
			}
//			for(int j=1;j<=colsize;j++) {
//			System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+ i + "]/td["+j+"]")).getText());
//			}
		}
		System.out.println();
}
}
