package org.room.manager.modules.tablet.Home;
import org.openqa.selenium.By;

public enum HomeEnum {
	LBLCONFERENCEROOM(By.xpath("//span[2]")),
	BTNSCHEDULE(By.xpath("//div[2]/div/span")),
	BTNSEARCH(By.xpath("//div[3]/div/span"));
	
	public final By value;	
	private HomeEnum(By value){
		this.value = value;
	}
}
