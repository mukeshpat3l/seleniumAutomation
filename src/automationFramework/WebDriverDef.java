package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDef {

	WebDriver driver;
	String appUrl = "https://www.seleniumeasy.com/test/";

	public void launchBrowser() {

		String exePath = "E:\\learning\\Java\\chromedriver.exe"; // E:\\learning\\Java\\geckodriver.exe
		// Set System Property
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();// WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appUrl);
	}

	public void closeBrowser() {
		driver.quit();
	}
}
