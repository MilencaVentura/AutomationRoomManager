package org.room.manager.modules.admin.resources;

import org.openqa.selenium.By;

public enum ResourcesEnum {
	BTNADD (By.xpath("//div/div/button")),
	BTNRESOURCE(By.cssSelector("div.ng-scope > span.ng-binding")),
	TXTASSERT (By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div/span")),
	TXTSEARCH (By.xpath("//input[@type='text']")),
	FIRSTRESOURCE(By.cssSelector("div.ng-scope > span.ng-binding")),
	BTNREMOVE (By.id("btnRemove")),
	SELECTRESOURCE (By.cssSelector("input.ngSelectionCheckbox")),
	ALLRESOURCES(By.xpath("//div[@id='resourcesGrid']/div[2]/div")),
	RESOURCECUSTOMNAME(By.xpath("div[4]/div[2]/div/span")),
	RESOURCESTEXT    (By.xpath("div[3]/div[2]/div/span")),
	DIVELEMENT (By.xpath("div"));
	
    public final By value;  
    
    private ResourcesEnum(By value){
    	this.value = value;
    }
}
