package com.occurance.testOccurance;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.occurance.dataUtils.Constants;
import com.occurance.excelutils.ExcelUtility;
import com.occurance.frameworkutils.SwitchToAlert;
import com.occurance.genericlibs.BaseClass;
import com.occurance.pomlibries.HomePage;

public class OccuranceTest extends BaseClass{
	@Test
	public void testCharacter() throws EncryptedDocumentException, FileNotFoundException, IOException {
		ExcelUtility excl = new ExcelUtility();
		String key = excl.readXLData(EXCELPATH, "Sheet1", 1, 0);
		String word = excl.readXLData(EXCELPATH, "Sheet1", 1, 1);
		String expectedResult = excl.readXLData(EXCELPATH, "Sheet1", 1, 2);
		HomePage hp = new HomePage(driver);
		hp.getSentence().sendKeys(word);
		hp.getKey().sendKeys(key);
		hp.getSubmit().click();
		String result = new SwitchToAlert().getAlertValue(driver);
		Reporter.log( "result -------------> "+result,true);
		//develop assert library
		
	} 
	
}
