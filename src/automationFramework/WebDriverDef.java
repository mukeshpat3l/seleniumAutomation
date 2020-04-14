package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class WebDriverDef {

	WebDriver driver;
	String appUrl = "https://www.seleniumeasy.com/test/";

	@BeforeMethod
	public void launchBrowser() {

		String exePath = "E:\\learning\\Java\\chromedriver.exe"; // E:\\learning\\Java\\geckodriver.exe
		// Set System Property
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();// WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
