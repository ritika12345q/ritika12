package com.fp.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import base.BaseClass;

public class TC_Google extends BaseClass{
	
	
	
	@Test
	public void login() {
	WebElement searchBox = driver.findElement(By.name("q"));
	searchBox.sendKeys("way2automation");
	searchBox.sendKeys(Keys.ENTER);
	 driver.findElement(By.partialLinkText("Way2Automation")).click();
	 List<WebElement> tags =  driver.findElements(By.tagName("a"));
	 Iterator<WebElement> itr = tags.iterator();
	
	 while(itr.hasNext()) {
		 System.out.println(itr.next().getText().trim());
	 }
	 
	
		//Assert.assertEquals(true, false);
		
	}

}
