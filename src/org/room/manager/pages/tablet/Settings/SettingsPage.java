package org.room.manager.pages.tablet.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.tablet.Settings.SettingsEnum;
import org.room.manager.pages.tablet.Home.HomePage;

public class SettingsPage {
WebDriver driver;
	
	By conferenceRoom = SettingsEnum.CONFERENCEROOM.value;
	By btnAccept = SettingsEnum.BTNACCEPT.value;
	By btnCancel = SettingsEnum.BTNCANCEL.value;
	By txtSearchText = SettingsEnum.TXTSEARCH.value;
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void txtSearch(String conferenceRoom){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtSearchText));
		driver.findElement(txtSearchText).clear();
		driver.findElement(txtSearchText).sendKeys(conferenceRoom);
	}
	
	public void selectConferenceRoom(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(conferenceRoom));
		driver.findElement(conferenceRoom).click();
	}
	
	public HomePage btnAccept(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnAccept));
		driver.findElement(btnAccept).click();
		return new HomePage(driver);
	}
}
