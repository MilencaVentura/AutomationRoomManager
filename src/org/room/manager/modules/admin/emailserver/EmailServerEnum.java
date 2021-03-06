package org.room.manager.modules.admin.emailserver;

import org.openqa.selenium.By;

public enum EmailServerEnum {
	BTNREMOVE (By.xpath("//button[2]")),
	BTNADD (By.xpath("//div[2]/button")),
	TXTHOSTNAME (By.id("add-mailserver-hostname")),
	TXTUSERNAME (By.id("add-mailserver-username")),
	TXTPASSWORD (By.id("add-mailserver-password")),
	BTNOK (By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary")),
	BTNSERVER (By.xpath("//div/div/a")),
	BTNDELETE (By.xpath("//div[3]/div/button"));
	
    public final By value;  
    
    private EmailServerEnum(By value){
    	this.value = value;
    	
    }
}
