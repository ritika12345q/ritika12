package com.fp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC2 {
	
	SoftAssert sf = new SoftAssert();

	
	@Test(priority=2, groups = "bird")
	public void getBuffaloSound() {
		System.out.println("LALA!");
		sf.assertEquals(true, false);
	}
	
	@Test(dependsOnMethods="getCrowSound",groups = {"bird","regression"})
	public void getPigeonSound() {
		System.out.println("GuterGoo!!");
		Assert.assertEquals(true, false);
	}
	
	@Test(alwaysRun=true, groups = {"animal","smoke"})
	public void getDonkeySound() {
		System.out.println("bhaa!!");
		System.out.println(Thread.currentThread().getId());

	}
	
	@Test(groups = {"bird","regression"})
	public void getCrowSound() {
		System.out.println("crow!!");
	}

}
