package base;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import AppiumTestNG_Framework.ApTest.AppiumServerJava;

public class AppiumBaseClass {
	AppiumServerJava appiumServer = new AppiumServerJava();
	int port = 4723;
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
	
	if(!appiumServer.checkIfServerIsRunning(port)) {
		appiumServer.startServer();
		
	}
	else {
		System.out.println("Appium Server already running on Port "+port);
	}
	
		}
	
	@AfterSuite
	public void tearDown() {
		if(appiumServer.checkIfServerIsRunning(port)) {
			appiumServer.stopServer();
			
		}
	}	
}
