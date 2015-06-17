package org.room.manager.modules.admin.resources;

import org.openqa.selenium.By;

public enum ResourcesRemoveEnum {
	BTNOKREMOVE (By.cssSelector("button.info")); 
	
    public final By value;  
    
    private ResourcesRemoveEnum(By value){
    	this.value = value;
    }
}
