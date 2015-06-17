package org.room.manager.modules.admin.resources;

import org.openqa.selenium.By;

public enum ResourcesEnum {
	BTNADD (By.xpath("//div/div/button")),
	BTNRESOURCE(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div")),
	TXTASSERT (By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div/span"));
	
    public final By value;  
    
    private ResourcesEnum(By value){
    	this.value = value;
    }
}
