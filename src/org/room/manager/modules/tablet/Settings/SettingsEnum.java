package org.room.manager.modules.tablet.Settings;

import org.openqa.selenium.By;

public enum SettingsEnum {
	CONFERENCEROOM(By.xpath("//div[3]/div/div/div")),
	TXTSEARCH(By.id("txtSearch")),
	BTNACCEPT(By.xpath("//button")),
	BTNCANCEL(By.xpath("//button[2]"));
	
	public final By value;	
	private SettingsEnum(By value){
		this.value = value;
	}	
}
