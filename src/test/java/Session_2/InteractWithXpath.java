package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithXpath {
	
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
	WebDriver driver = new ChromeDriver() ;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");
		System.out.println("Landing page title is-" +driver.getTitle());
		
		
		WebElement UserFirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));	
		
		UserFirstName.sendKeys("Tom");
		

	WebElement UserLastName = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));	
		
	UserLastName.sendKeys("jerry");
	
	WebElement UserAdress = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));	
	
	UserAdress.sendKeys("256, bakers street, america");
	
 //WebElement EmailAdress = driver.findElement(By.xpath("form-control ng-pristine ng-valid-email ng-invalid ng-invalid-required ng-touched"));	
	
	//EmailAdress.sendKeys("xyz@gmail.com");
	
   WebElement maleRadio = driver.findElement(By.xpath("//input[@value='Male']"));
	
maleRadio.click();

  WebElement moviesCheckBox = driver.findElement(By.id("checkbox2"));
       
  moviesCheckBox.click();
  



Thread.sleep(3000);

driver.quit();
}
}
