package _7_ScreenShotCaptureNJavaScriptUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1_ScreenshotCapture {

	WebDriver driver;
	WebDriverWait wait;
	String URL = "https://www.google.co.in";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		wait = new WebDriverWait(driver, 15);
	}
	
	@Test
	public void tc_01()
	{

		//System.out.println(System.getProperty("user.dir"));

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium");

		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();

		wait.until(ExpectedConditions.titleContains("Selenium"));

		WebElement javatpointLink = driver.findElement(By.xpath("//h3[contains(text(),'Selenium Tutorial - javatpoint')]"));

		wait.until(ExpectedConditions.elementToBeClickable(javatpointLink));
		screenshotCapture(driver, "SeleniumKeywordResult");

	}

	@Test
	public void tc_02()
	{

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Appium Tool");

		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();

		//javatpointLink.click();
		wait.until(ExpectedConditions.titleContains("Appium Tool"));

		screenshotCapture(driver, "SeleniumKeywordResult");

		screenshotCapture(driver, "Appium Tool");

	}

	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void screenshotCapture(WebDriver driver, String fileNameToBe)
	{
		// 1. Take Screenshot & store into a File
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// 2. Copy the captured screenshot into the desired destination path
		try {
			
			// 3. Transferring the screenshot by hard coded path (Must not be used) 
			//Fileutils.copyfile(file, new File("C:\\Users\\Dhanashree\\eclipse-workspace\\Batch17SeleniumWebdriver\\src\\test\\java\\_7_ScreenShotCaptureNJavaScriptUtils\\" + fileNameToBe + ".jpg"));
			
			// 3. Transferring the screenshot without hard coding (advisable to be used like this)
			FileUtils.copyFile(file, new File( System.getProperty("user.dir") 
					+ "/src/test/java/_7_ScreenShotCaptureNJavaScriptUtils/_1_ScreenshotCapture/screenshots/" + fileNameToBe + System.currentTimeMillis()+".jpg"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
