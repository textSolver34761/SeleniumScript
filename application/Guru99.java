package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99 {
	
	ChromeDriver driver;
	
	String url = "https://demo.guru99.com/v4/";
	
	//@BeforeMethod
	@Test(priority = -100)
	public void invokBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\benpr\\Downloads\\chromedriver_win32_\\chromedriver.exe");
			
		driver = new ChromeDriver();
			
		driver.manage().window().maximize();
			
		driver.get(url);
	}
	
	//@AfterMethod
	//public void CloseBrower() {
		//driver.quit();
	//}
	
	@Test
	public void verifiyTitleOfPage() {
		String expected = "Guru99 Bank Home Page";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void verifyLogin() {
		
		WebElement userId = driver.findElement(By.name("uid"));
		
		userId.sendKeys("mngr422406");
		
		WebElement passId = driver.findElement(By.name("password"));
		
		passId.sendKeys("UpuvyvY");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']"))).click();
		
//		WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		
//		button.click();
	}

	
	@Test
	public void addClient() {
		
//		WebElement link = driver.findElement(By.xpath("//a[@href='addcustomerpage.php']"));
		
//		link.click();
		
		WebElement linkWeb = driver.findElement(By.linkText("New Customer"));
		
		linkWeb.click();

		
		driver.findElement(By.xpath("//input[@value='f']")).click();
		
		driver.findElement(By.name("name")).sendKeys("toto est grand");
		
		driver.findElement(By.name("dob")).sendKeys("05/07/1990");
		
		driver.findElement(By.name("addr")).sendKeys("rue des Etoiles");
		
		driver.findElement(By.name("city")).sendKeys("Mars");
		
		driver.findElement(By.name("state")).sendKeys("NA");
		
		driver.findElement(By.name("pinno")).sendKeys("123456");
		
		driver.findElement(By.name("telephoneno")).sendKeys("000000000");
		
		driver.findElement(By.name("emailid")).sendKeys("toto@test.com");
		
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	@Test
	public void GetClientId() {
		String clientid = driver.findElement(By.xpath("//table[@id='customer'/tbody/tr[4]/td[2]")).getText();
		
		System.out.println(clientid);
		
	}
}
