package org.room.manager.modules.admin.resources;

import org.openqa.selenium.By;

public enum ResourcesAddEnum {
	TXTNAME (By.xpath("(//input[@type='text'])[3]")),
	TXTDISPLAYNAME (By.xpath("(//input[@type='text'])[4]")),
	BTNSAVE (By.cssSelector("button.info")),
	BTNCLOSE (By.cssSelector("i.fa.fa-times")),
	ERRORMESSAGE (By.cssSelector("small.inline-error.ng-binding"));
	
    public final By value;  
    
    private ResourcesAddEnum(By value){
    	this.value = value;
    }
}
