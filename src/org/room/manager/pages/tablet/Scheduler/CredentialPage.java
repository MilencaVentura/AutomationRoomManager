package org.room.manager.pages.tablet.Scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.tablet.Scheduler.CredentialsEnum;

public class CredentialPage {
	WebDriver driver;
	By usernameTextBox = CredentialsEnum.TXTUSERNAME.value;
	By passwordTextBox = CredentialsEnum.TXTPASSWORD.value;
	By okButton = CredentialsEnum.BTNOK.value;
	By cancelButton = CredentialsEnum.BTNCANCEL.value;
	
	public CredentialPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void txtUsername(String username){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void txtPassword(String password){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public SchedulerPage btnOk(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(okButton));
		driver.findElement(okButton).click();
		return new SchedulerPage(driver);
	}
}
