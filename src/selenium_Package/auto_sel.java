package selenium_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class auto_sel {
	
	public WebDriver driver ;	
		
@BeforeTest
public void initialize()
{
	
	 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	  
	 capabilities.setCapability(InternetExplorerDriver.
	   INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	

	System.out.println("Initializing the Browser");
	System.setProperty("webdriver.ie.driver","E:\\Automation\\location_Jars\\IEDriverServer.exe");
    driver = new InternetExplorerDriver();
    driver.manage().window().maximize();

}
		
	
@Test
public void launch()
{
	driver.get("http://www.google.com");
	String printname= driver.getTitle();
	System.out.println("Title of the page is:" +printname);
	Assert.assertTrue(printname.equalsIgnoreCase("Google"), "page title doesnot match");
	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 WebElement search =driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
  search.click();
  search.isSelected();
  search.clear();
  System.out.println("test passed");
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  search.sendKeys("abdul kalam");
  driver.findElement(By.xpath("//input[@value='Google Search']")).click();
  System.out.println("searched successfully");
  
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement count = driver.findElement(By.xpath("//*[@id='resultStats']"));

System.out.println("count is:" +count.getText());	
}

@AfterTest
public void close()
{
	
System.out.println("closing the browser");

driver.quit();
System.out.println("closed successfully");
}
	
}
