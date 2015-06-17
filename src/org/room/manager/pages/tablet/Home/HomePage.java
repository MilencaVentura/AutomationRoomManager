package org.room.manager.pages.tablet.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.tablet.Home.HomeEnum;
import org.room.manager.pages.tablet.Scheduler.SchedulerPage;
import org.room.manager.pages.tablet.Search.SearchPage;

public class HomePage {
	WebDriver driver;
	By btnSchedule = HomeEnum.BTNSCHEDULE.value;
	By lblConferenceRoom = HomeEnum.LBLCONFERENCEROOM.value;
	By btnSearch = HomeEnum.BTNSEARCH.value;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public SchedulerPage clickBtnSchedule(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(lblConferenceRoom));
		driver.findElement(btnSchedule).click();
		return new SchedulerPage(driver);
	}
	
	public SearchPage clickBtnSearch(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnSearch));
		driver.findElement(btnSearch).click();
		return new SearchPage(driver);		
	}
}
