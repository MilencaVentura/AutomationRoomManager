package org.room.manager.modules.admin;

import org.openqa.selenium.By;

public enum LoginEnum {
	BTNLOGIN (By.xpath("//button"));
	
    public final By value;  
    
    private LoginEnum(By value){
    	this.value = value;
    }
}
