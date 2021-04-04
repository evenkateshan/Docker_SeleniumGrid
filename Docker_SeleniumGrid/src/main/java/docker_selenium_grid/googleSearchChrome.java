package docker_selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class googleSearchChrome {
static RemoteWebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		System.out.println("Running Test in Docker container <<Chrome>>");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.LINUX);
		cap.setVersion("");
		driver=new RemoteWebDriver(new URL("http://192.168.121.145:4444/wd/hub"),cap);
		driver.manage().window().maximize();
	}
	
	@Test(description="Google search in Chrome")
	public void googleSearch() throws InterruptedException
	{
		driver.navigate().to("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("amazon");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void teardown()
	{
		if(driver!=null)
		{
			System.out.println("Google Search is completed in Chrome");
			driver.quit();
		}
	}
}
