package coursera.selenium.script;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	
	ChromeDriver driver;
	
	String url = "http://demo.guru99.com/v4"; 
	
	public void invokBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\benpr\\Downloads\\chromedriver_win32_\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
	}
	
	public void getTitle() {
		
		String titlePage = driver.getTitle();
		
		System.out.println(titlePage);
		
	}
	
	public void CloseBrower() {
		
		//driver.close();
		
		driver.quit();
		
	}
	
	public static void main(String[] args) {
		Chrome chrome = new Chrome();
		
		chrome.invokBrowser();
		chrome.getTitle();
		//chrome.CloseBrower();
	}
}
