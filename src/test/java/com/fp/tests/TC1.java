package com.fp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC1 {
	SoftAssert sf = new SoftAssert();

	@Test(groups = {"animal","regression"})
	public void getCatSound() {
		System.out.println("Meow!!");
		System.out.println(Thread.currentThread().getId());

		sf.assertEquals(true, false);
	}
	
	@Test(groups = {"animal","smoke"})
	public void getDogSound() {
		System.out.println("Bhow!!");
		sf.assertEquals(true, false);
		System.out.println(Thread.currentThread().getId());

	}
	
	@Test(priority=1, groups = {"animal","smoke"})
	public void getCowSound() {
		System.out.println("Maa!!");
		System.out.println(Thread.currentThread().getId());

	}
	
	@Test(groups = "bird")
	public void getCuckooSound() {
		System.out.println("koo!!");
	}
	
}
