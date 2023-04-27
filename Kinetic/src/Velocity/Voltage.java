package Velocity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Voltage {


	WebDriver driver;
	String homePage="https://www.techlistic.com/p/demo-selenium-practice.html";
	@FindBy(how = How.ID,using = "//table[@id='customers']//tr")
	List<WebElement> row;
	
	@FindBy(how = How.ID,using = "//table[@id='customers']//tr//td")
	List<WebElement> col;
	
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
	
	@Test
	public void businessLogic() {
		
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int rowSize=row.size();
		int colSize=col.size();
		System.out.println(rowSize+"ZOMATO"+colSize);
		
		
		for(int i=1;i<=rowSize;i++) {
			
		for(int j=1;j<=colSize;j++) {
			
		String s =	driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]")).getText();
			System.out.println(s);
			
		}	
			
			
		}
		
	}
	
	
	@AfterMethod
	public void tearDownBrowser() {
		
		driver.quit();
		
	}	
	
}
