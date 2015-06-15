package org.room.manager.modules.admin.resources;

import org.openqa.selenium.By;

public enum ResourcesEnum {
	/*    driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[48]/div[3]/div[2]/div/span")).click();*/
	BTNADD (By.xpath("//div/div/button")),
	TXTNAME (By.xpath("(//input[@type='text'])[3]")),
	TXTDISPLAYNAME (By.xpath("(//input[@type='text'])[4]")),
	BTNSAVE (By.cssSelector("button.info")),
	BTNRESOURCE(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div")),
	TXTASSERT (By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div/span")),
	BTNCLOSE (By.cssSelector("i.fa.fa-times"));
	
    public final By value;  
    
    private ResourcesEnum(By value){
    	this.value = value;
    }
}
