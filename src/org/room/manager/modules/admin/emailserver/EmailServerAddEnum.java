package org.room.manager.modules.admin.emailserver;

import org.openqa.selenium.By;

public enum EmailServerAddEnum {
	TXTHOSTNAME (By.id("add-mailserver-hostname")),
	TXTUSERNAME (By.id("add-mailserver-username")),
	TXTPASSWORD (By.id("add-mailserver-password")),
	BTNOK (By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary")),
	BTNSERVER (By.xpath("//div/div/a")),
	BTNDELETE (By.xpath("//div[3]/div/button"));
	
	public final By value;  
    
    private EmailServerAddEnum(By value){
    	this.value = value;
    	
    }
}
