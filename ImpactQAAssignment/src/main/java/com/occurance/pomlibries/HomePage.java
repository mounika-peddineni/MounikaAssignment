package com.occurance.pomlibries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(id="text1")
	private WebElement key;
	@FindBy(id="text2")
	private WebElement sentence;
	@FindBy(tagName ="button")
	private WebElement submit;
	public WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getKey() {
		return key;
	}
	public void setKey(WebElement key) {
		this.key = key;
	}
	public WebElement getSentence() {
		return sentence;
	}
	public void setSentence(WebElement sentence) {
		this.sentence = sentence;
	}
}
