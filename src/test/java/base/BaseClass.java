package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public int iBrowserType = 1;
	public String sURL = "https://uibank.uipath.com/";
	
	@BeforeClass
	public void invokeBrowser() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User Option is "+iBrowserType+", So invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		
		case 2:
			System.out.println("User Option is "+iBrowserType+", So invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case 3:
			System.out.println("User Option is "+iBrowserType+", So invoking Edge Browser");
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("User Option is wrong "+iBrowserType+", So invoking the default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
