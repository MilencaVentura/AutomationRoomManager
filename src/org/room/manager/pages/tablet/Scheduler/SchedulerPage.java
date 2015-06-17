package org.room.manager.pages.tablet.Scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.tablet.Scheduler.SchedulerEnum;
public class SchedulerPage {
	WebDriver driver;
	By txtOrganizer = SchedulerEnum.TXTORGANIZER.value;
	By txtSubject = SchedulerEnum.TXTSUBJECT.value;
	By txtAttendees = SchedulerEnum.TXTATTENDEES.value;
	By btnCreate = SchedulerEnum.BTNCREATE.value;
	
	public SchedulerPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void txtOrganizer(String organizer){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtOrganizer));
		driver.findElement(txtOrganizer).clear();
		driver.findElement(txtOrganizer).sendKeys(organizer);
	}
	
	public void txtSubject(String subject){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtSubject));
		driver.findElement(txtSubject).clear();
		driver.findElement(txtSubject).sendKeys(subject);
	}
	
	public void txtAttendees(String attendee){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtAttendees));
		driver.findElement(txtAttendees).clear();
		driver.findElement(txtAttendees).sendKeys(attendee + ";");
	}
	
	public CredentialPage btnCreate(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnCreate));
		driver.findElement(btnCreate).click();
		return new CredentialPage(driver);
	}
}
