package com.fp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fp.utilities.ExcelUtils;

public class TC_Data {
	
	@Test(dataProvider="getData")
	public void login(String us, String ps) {
		System.out.println(us+" "+ps);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		ExcelUtils ec = new ExcelUtils();
		ec.setPath(this.getClass().getSimpleName().toString());
		for(int i=1; i<3; i++) {
			for(int j=0; j<2; j++) {
				data[i][j]=ec.getCellData(i,j);
				
			}
			
		}
		
		return data;
	}
}
