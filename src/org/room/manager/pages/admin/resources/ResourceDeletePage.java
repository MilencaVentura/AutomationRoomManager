package org.room.manager.pages.admin.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesRemoveEnum;;

public class ResourceDeletePage {
	
	private WebDriver driver;
	By btnOkRemove = ResourcesRemoveEnum.BTNOKREMOVE.value;
    
    public ResourceDeletePage(WebDriver driver){
		this.driver = driver;
	}
    
    public ResourcePage btnOkRemoveResource(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(btnOkRemove));
    	WebElement element = driver.findElement(btnOkRemove);
	    element.click();
    	  	return new ResourcePage(driver);
        }
}
