package org.room.manager.modules.admin;

import org.openqa.selenium.By;

public enum HomeAdminEnum {
	LINKEMAILSERVER (By.linkText("Email Servers")),
	LINKRESOURCES (By.linkText("Resources"));
	
    public final By value;  
    
    private HomeAdminEnum(By value){
    	this.value = value;
    }
}
