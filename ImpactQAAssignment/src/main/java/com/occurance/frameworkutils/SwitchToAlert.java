package com.occurance.frameworkutils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class SwitchToAlert {
	Alert a;
	public String getAlertValue(WebDriver driver) {
		a=driver.switchTo().alert();
		String data = a.getText();
		a.accept();
		return data;
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dissmissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void sendKeyToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
}
