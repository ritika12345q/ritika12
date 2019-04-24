package AppiumTestNG_Framework.ApTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * Hello world!
 *
 */
public class AppiumServerJava 
{
	public static Properties Config =  new Properties();
   private AppiumDriverLocalService service;
	public static FileInputStream fis;

   private AppiumServiceBuilder builder;
   private DesiredCapabilities cap;
   ServerSocket serverSocket;
	WebDriver driver;

   public void startServer() throws MalformedURLException {
	   cap = new DesiredCapabilities();
	   cap.setCapability("noReset", false);
	   //Build the appium service
	   builder = new AppiumServiceBuilder();
	   builder.withIPAddress("127.0.0.1");
	   builder.usingPort(4723);
	   builder.withCapabilities(cap);
	   builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	   builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
	   //start the server with builder
	   service=AppiumDriverLocalService.buildService(builder);
	   service.start();
	   String appiumServiceUrl= service.getUrl().toString();
	   System.out.println("Server is running on Port 4723. Service URL: "+appiumServiceUrl);
	   //Load the config file
	   try {
		fis= new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
		Config.load(fis);
	   } catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
 catch (IOException e) {
		
			e.printStackTrace();
		}
		
	   //Start Android Mobile driver and launch the app
	   DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", Config.getProperty("deviceID"));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", Config.getProperty("appPackage"));
		capabilities.setCapability("appActivity", Config.getProperty("appActivity"));
		
		driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }
   
   public void stopServer() {
	   service.stop();
	   System.out.println("Server is stopped");

   }
   
   public boolean checkIfServerIsRunning(int port) {
	   boolean isServiceRunning=false;
	   try {
		   serverSocket = new ServerSocket(port);
		   serverSocket.close();
		   
	   }
	   catch(Exception e) {
		   isServiceRunning=true;
	   }
	return isServiceRunning;
	   
   }
}
