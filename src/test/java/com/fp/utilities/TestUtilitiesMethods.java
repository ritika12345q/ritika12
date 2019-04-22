package com.fp.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class TestUtilitiesMethods  extends BaseClass {
	static Date d = new Date();
	public static String screenshotName = d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".jpg";
		
	public static void takeScreenShot() {
	//Capture the ScreenShot
	TakesScreenshot a = (TakesScreenshot)driver;
	File src = a.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\test-output\\Reports\\"+screenshotName));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
