package com.fp.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentRepos {

	public static ExtentReports extent;
	
	public static ExtentReports getIntance() {
		if(extent==null)
			extent = new ExtentReports(System.getProperty("user.dir")+"results", false, DisplayOrder.NEWEST_FIRST);
		extent.loadConfig(new File(System.getProperty("user.dir")+"Configuration\\ReportsConfig.xml"));
		return extent;
	}
	
}
