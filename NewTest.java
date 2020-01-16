package Trip;

import org.testng.annotations.Test;

import pages.Testdata_value;
import pages.Tripadvisor_Review_page;
import pages.Tripadvisor_search_pages;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
	static String driverpath="C:\\\\Users\\\\user\\\\Downloads\\\\Driver\\\\don't delete\\\\chromedriver79\\\\chromedriver.exe";

  @Test
  public void f() throws InterruptedException {
	
	  driver.findElement(Tripadvisor_search_pages.searchbox).click();
	  driver.findElement(Tripadvisor_search_pages.mainsearch).sendKeys(Testdata_value.mainsearch1);
	  driver.findElement(Tripadvisor_search_pages.search).click();
	  
	  Thread.sleep(2000);
	  driver.findElement(Tripadvisor_search_pages.firstlink).click();
	  
		
	   String mainparent = driver.getWindowHandle();
	   
	    for(String child: driver.getWindowHandles())
	    {
	    	driver.switchTo().window(child);
	    }
	    
	  driver.findElement(Tripadvisor_search_pages.Review).click();
	  
	  Set<String>  child= driver.getWindowHandles();
		
		for(String subchild: driver.getWindowHandles())
		{
			driver.switchTo().window(subchild);
		}
		
		
		Thread.sleep(3000);
		Actions action= new Actions(driver);
		WebElement ec1= driver.findElement(Tripadvisor_Review_page.hover);
		action.moveToElement(ec1).build().perform();
	  
	   driver.findElement(Tripadvisor_Review_page.hover).click();
	   
	   Thread.sleep(3000);
	   driver.findElement(Tripadvisor_Review_page.titlereview).sendKeys(Testdata_value.titlereview1);
	   
	   Thread.sleep(3000);
	   driver.findElement(Tripadvisor_Review_page.reviewtext).sendKeys(Testdata_value.reviewtext1);
	   

		Thread.sleep(3000);
		Actions action1= new Actions(driver);
		WebElement ec2= driver.findElement(Tripadvisor_Review_page .service);
		action.moveToElement(ec2).build().perform();
	   
	   driver.findElement(Tripadvisor_Review_page .service);
	   
      // click on the check box for submit review
	   
	   driver.findElement(Tripadvisor_Review_page .checkbox);
	  
	 
	
}
@BeforeTest
  public void setup() {
	System.setProperty("webdriver.chrome.driver",driverpath);
	driver= new ChromeDriver();  
	driver.get(Testdata_value.url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	  
  }
  }


