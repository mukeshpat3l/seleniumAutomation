package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestClass extends WebDriverDef {

	
	public void singleInput() throws InterruptedException {
		int step = 1;

		System.out.println("Step: " + step++ + " - Open Browser and open Selenium Easy demo site.");
		launchBrowser();

		String siteTitle = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
		Thread.sleep(2000);

		System.out.println("Verify that URL https://www.seleniumeasy.com/test opened on the browser.");

		if (driver.getTitle().equalsIgnoreCase(siteTitle)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED - URL https://www.seleniumeasy.com/test NOT opened on the browser.");
		}
		Thread.sleep(2000);

		System.out.println("Step: " + step++ + " - Click on the All Examples > Input Forms > Simple Form Demo link.");
		WebElement inputForms = driver
				.findElement(By.xpath(".//li[@class='tree-branch']//a[contains(text(),'Input Forms')]"));

		// WebElement simFormDemo =
		// driver.findElement(By.xpath("//li[@class='tree-branch']//li[1]//ul[1]//li[1]"));

		System.out.println("Clicking on the Input Forms link.");
		inputForms.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement simFormDemo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				".//li[@class='tree-branch']//a[contains(text(),'Input Forms')]/..//a[contains(text(),'Simple Form Demo')]")));

		System.out.println("Clicking on the Simple Form Demo link.");
		simFormDemo.click();

		System.out.println("Verify that Simple Form Demo opened with Single/Double Input Field sections.");

		WebElement singleInput = driver.findElement(By.xpath("//div[contains(text(),'Single Input Field')]"));
		WebElement twoInput = driver.findElement(By.xpath("//div[contains(text(),'Two Input Fields')]"));
		if (singleInput.isDisplayed() && twoInput.isDisplayed()) {
			System.out.println("PASSED");

		} else {
			System.out.println("FAILED - Simple Form Demo is NOT opened with Single/Double Input Field sections.");
		}

		System.out.println("Step: " + step++
				+ " - Enter your message into 'Single Input Field' section and click Show message button.");

		WebElement enterMessage = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));

		String message = "Dharmesh Sir ROCKS";
		enterMessage.clear();

		System.out.println("Entering message into Input field.");
		enterMessage.sendKeys(message);

		WebElement showBtn = driver.findElement(By.xpath("//button[contains(text(),'Show Message')]"));
		System.out.println("Clicking on the 'Show Message' button.");
		showBtn.click();

		System.out.println("Verify that displayed message is same as entered in input field.");

		WebElement disMessage = driver.findElement(By.cssSelector("#display"));
		String displayMessage = disMessage.getText();

		System.out.println("Input Message: " + message + " and Display Message: " + displayMessage);
		Thread.sleep(2000);
		if (message.equalsIgnoreCase(displayMessage)) {
			System.out.println("PASSED");

		} else {
			System.out.println("FAILED - Displayed message is NOT same as entered in input field.");
		}

		closeBrowser();
	}

	
	public void twoInput() throws InterruptedException {
		int step = 1;
		// Launch the Demo Website

		System.out.println("Step: " + step++ + " - Open Browser and open Selenium Easy demo site.");
		launchBrowser();
		System.out.println("Step: " + step++ + " - Click on the All Examples > Input Forms > Simple Form Demo link.");
		WebElement inputForms = driver
				.findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]"));
		// WebElement simFormDemo =
		// driver.findElement(By.xpath("//li[@class='tree-branch']//li[1]//ul[1]//li[1]"));

		inputForms.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement simFormDemo = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='tree-branch']//li[1]//ul[1]//li[1]")));

		simFormDemo.click();

		System.out.println("Verify that Simple Form Demo opened with Single/Double Input Field sections.");

		WebElement singleInput = driver.findElement(By.xpath("//div[contains(text(),'Single Input Field')]"));
		WebElement twoInput = driver.findElement(By.xpath("//div[contains(text(),'Two Input Fields')]"));

		if (singleInput.isDisplayed() && twoInput.isDisplayed()) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED - Simple Form Demo is NOT opened with Single/Double Input Field sections.");
		}

		System.out.println("Step: " + step++ + " - Enter value for a and b then click 'Get Total' button.");

		int valueA = 10;
		int valueB = 15;

		WebElement a = driver.findElement(By.cssSelector("#sum1"));
		WebElement b = driver.findElement(By.cssSelector("#sum2"));

		String aStr = new Integer(valueA).toString();
		String bStr = new Integer(valueB).toString();

		a.clear();
		a.sendKeys(aStr);
		b.clear();
		b.sendKeys(bStr);

		WebElement getTotal = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
		getTotal.click();

		WebElement total = driver.findElement(By.cssSelector("#displayvalue"));
		String totalStr = total.getText();

		System.out.println("Verify that value a + value b = Total is correct.");

		Thread.sleep(2000);
		if (Integer.sum(valueA, valueB) == Integer.parseInt(totalStr)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED - Displayed Total is not as per your values input.");
		}
		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException {

		TestClass objTC = new TestClass();

		objTC.singleInput();
		objTC.twoInput();

	}

}






