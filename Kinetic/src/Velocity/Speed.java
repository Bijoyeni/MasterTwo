package Velocity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Speed {

	WebDriver driver;
	String homePage="https://www.redbus.in/";
	@BeforeMethod
	public void openURL() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\ChDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
         driver =new ChromeDriver(options);
        driver.navigate().to(homePage);
        driver.manage().window().maximize();
		
	}
	@Test(priority = 2)
	public void logicTest() {
		WebElement sk=driver.findElement(By.xpath("//div[@id='advantage']"));
		sk.isDisplayed();
		
		System.out.println("Car Running----"+ sk.isDisplayed() );
		String title=driver.getTitle();
		System.out.println(title );
		if(sk.isDisplayed()) {
			Assert.assertEquals(title, "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
		}
		
	}
	@Test(priority = 1)
	public void businessTest() throws InterruptedException {
		
		WebElement sourcePlace=driver.findElement(By.xpath("//input[@id='src']"));
		
		WebElement destPlace=driver.findElement(By.xpath("//input[@id='dest']"));
		
		WebElement clickCal=driver.findElement(By.xpath("//input[@id='onward_cal']"));
		
		WebElement chooseCal=driver.findElement(By.xpath("//td[@class='current day']"));
		
		WebElement searchBus=driver.findElement(By.xpath("//button[@id='search_btn']"));
		
		List<WebElement> dateList =driver.findElements(By.xpath("//td[@class='wd day']"));
		
		sourcePlace.sendKeys("Kolkata");
		destPlace.sendKeys("Siliguri");
		clickCal.click();
		clickCal.sendKeys("24-Apr-2023");
		Thread.sleep(10000);
		
	//	System.out.println("date pick--"+ chooseCal.isDisplayed());
	//	chooseCal.click();
	//	dateList.get(1).click();
		searchBus.click();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(driver.getCurrentUrl()==homePage) {
			
			System.out.println("return to homepage!!!!!!");
			
		}
		
		
	}
	
	
	
	@AfterMethod
	public void tearDownBrowser() {
		
		driver.quit();
		
	}
	
	
}
