package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _3_EdgeInvocation {
	
public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"/msedgedriver.exe");
	
	WebDriver driver = new EdgeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/");
	
	
	driver.navigate().refresh();
	
	String title = driver.getTitle();
	String titleExpected = "Facebook – log in or sign up";
	
	System.out.println("web page title is ->" + title);

	//validation
	if(title.equals(titleExpected))
	{
		System.out.println("Title matched");
	}
	else
	{
		System.out.println("Title doesn't match");
	}
	driver.navigate().to("https://www.amazon.in/");
	//System.out.println("title for amazon is -"  +driver.getTitle());

     driver.navigate().back();
	System.out.println("Title after navigating back is - " + driver.getTitle()) ;
	driver.navigate().forward();
	System.out.println("Title after navigating forward is - " + driver.getTitle()) ;
	
	
	driver.close();
	}

private static String extracted(WebDriver driver) {
	String title = driver.getTitle();
	return title;
}
	
	
}
	
	

