package org.room.manager.modules.tablet.search;

import org.openqa.selenium.By;

public enum SearchEnum {
	BTNADVANCED(By.xpath("//button[@type='button']")),
	TXTROOMNAME(By.id("txtRoomName")),
	TXTCAPACITY(By.id("txtMinimumCapacity"));
	
	public final By value;	
	private SearchEnum(By value){
		this.value = value;
	}
}
