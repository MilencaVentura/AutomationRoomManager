package org.room.manager.modules.tablet.Scheduler;
import org.openqa.selenium.By;

public enum SchedulerEnum {
	TXTORGANIZER(By.id("txtOrganizer")),
	TXTSUBJECT(By.id("txtSubject")),
	TXTATTENDEES(By.xpath("//rm-tag-input/div/input")),
	BTNCREATE(By.xpath("//button[4]")),
	BTNBACK(By.xpath("//button"));
	
	public final By value;	
	private SchedulerEnum(By value){
		this.value = value;
	}
}
