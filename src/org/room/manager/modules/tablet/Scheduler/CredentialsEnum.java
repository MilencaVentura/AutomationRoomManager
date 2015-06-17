package org.room.manager.modules.tablet.Scheduler;
import org.openqa.selenium.By;

public enum CredentialsEnum {
	TXTUSERNAME(By.xpath("//input[@type='text']")),
	TXTPASSWORD(By.xpath("//input[@type='password']")),
	BTNOK(By.xpath("//button[2]")),
	BTNCANCEL(By.xpath("//button"));
	
	public final By value;	
	private CredentialsEnum(By value){
		this.value = value;
	}
}
