package com.fp.tests;

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
	searchBox.sendKeys("software testing help");
	searchBox.sendKeys(Keys.ENTER);
	 String a = Keys.chord(Keys.CONTROL,Keys.RETURN);
	 driver.findElement(By.partialLinkText("Software Testing Help - A Must Visit Software Testing Portal")).click();
	
		//Assert.assertEquals(true, false);
		
	}

}
