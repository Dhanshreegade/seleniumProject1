package Session_3_Xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_AbsoluteXpath {

	private static final String Assert = null;

	WebDriver driver;
	
	String pageTitle = "Amazon.in: Online Shopping India - Buy mobiles, laptops, cameras, books, watches, apparel, shoes and e-Gift Cards. Free Shipping & Cash on Delivery Available.";
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void validateTitleTest() 
	{
		Assert.assertEquals("Title is not matching", pageTitle ,driver.getTitle());
		System.out.println("Test case is pass");
		
	}
	
@Test
public void SearchboxItem() throws InterruptedException
{
	WebElement SearchBox = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
	SearchBox.sendKeys("iphone13");
	
	Thread.sleep(3000);
	
	WebElement SearchButton = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));
	SearchButton.click();
	
	Thread.sleep(3000);
	
}

@After
public void teardown()
{
	driver.quit();
}













}
