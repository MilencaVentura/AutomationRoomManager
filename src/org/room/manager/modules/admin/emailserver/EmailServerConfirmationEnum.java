package org.room.manager.modules.admin.emailserver;

import org.openqa.selenium.By;

public enum EmailServerConfirmationEnum {
	BTNOK (By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary")),
	BTNSERVER (By.xpath("//div/div/a")),
	BTNREMOVE (By.xpath("//button[2]")),
	BTNDELETE (By.xpath("//div[3]/div/button"));
	
	public final By value;  
  
    private EmailServerConfirmationEnum(By value){
    	this.value = value;
    	
    }
	
}
