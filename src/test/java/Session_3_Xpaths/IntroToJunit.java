package Session_3_Xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToJunit {

	WebDriver driver;
	String url = "https://www.snapdeal.com/";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	 @Test
	public void titleValidation()
	{
		String expTitle = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
		String actTitle = driver.getTitle();
		
		//expected vs actual
		Assert.assertEquals("title is not matching",expTitle, actTitle);
		
	@Test
	
	public void searchprod() 
	{
		WebElement searchboxEle = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		
		searchboxEle.sendKeys();
		
		WebElement searchBtn = driver.findElement (By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[2]/button"));
		searchBtn.click();
		
		Thread.sleep(3000);
	}
	
		
	
	//input[@id='inputValEnter']
	///html/body/div[2]/div[4]/div[2]/div/div[2]/button
//		if(expTitle.equals(actTitle))
//		{
//			System.out.println("Title matched");
//		}
//		else
//			System.out.println("Title fail");
	}
	@After
	public void teardown()
	{
		driver.quit();
	}
	
}
