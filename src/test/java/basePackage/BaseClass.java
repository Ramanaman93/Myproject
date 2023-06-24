package basePackage;


import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;




public class BaseClass {
	public static Properties prop=new Properties();
	public static WebDriver driver;
	{
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
	prop.load(file);
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(IOException a) {
			a.printStackTrace();}
			
	}
		
		public static void initation() throws InterruptedException {
			
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
		}
			else if(browsername.equals("Firefox")) {
				System.setProperty("WebDriver.Firefox.driver","Firefox.exe");
				driver= new FirefoxDriver();
			}
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		}
		public static void screenshots(String Filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(file, new File("C:\\Users\\User\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\screenshots" +Filename+".jpg"));
		}
			catch(IOException e) {
				e.printStackTrace();
			}
		
			
			
		
	
		
		
		}
}
		
	
	


