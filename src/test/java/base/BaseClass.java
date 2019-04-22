package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.fp.listener.ListenerRep;
import com.fp.utilities.ExcelUtils;
import com.fp.utilities.ExtentRepos;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseClass {
	public static WebDriver driver;
	public static Properties Config =  new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static ExcelUtils excel = new ExcelUtils();
	public static WebDriverWait wait;
	//public static ListenerRep rep;
	public ExtentReports rep = ExtentRepos.getIntance();
	public static ExtentTest test;

	
	
	@BeforeSuite
	public void setup() {
		if(driver==null){
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
				Config.load(fis);
				log.info("Config file loaded");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(Config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(Config.getProperty("testUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
