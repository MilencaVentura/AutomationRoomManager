package org.room.manager.pages.admin.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesAddEnum;

/**
 * This page is needed to create a new resource. 
 * @author Milenca Ventura
 */

public class ResourceCreatePage {
	
	private WebDriver driver;

    By txtName = ResourcesAddEnum.TXTNAME.value;
    By txtDisplayName = ResourcesAddEnum.TXTDISPLAYNAME.value;
    By btnSave = ResourcesAddEnum.BTNSAVE.value;
    By btnClose = ResourcesAddEnum.BTNCLOSE.value;
   
    
	public ResourceCreatePage(WebDriver driver){
		this.driver = driver;
	}
	
    public  ResourcePage btn_Close(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(btnClose));
    	WebElement element = driver.findElement(btnClose);
	    element.click();
	    return new ResourcePage(driver);
    }
    public  ResourceCreatePage txt_name(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesAddEnum.TXTNAME.value));
    	WebElement element =driver.findElement(txtName);
        element.clear();
        element.sendKeys("Resource1");
	    return this;
    }
    
    public ResourceCreatePage txt_displayName(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesAddEnum.TXTDISPLAYNAME.value));
    	WebElement element = driver.findElement(txtDisplayName);
	    element.clear();
	    element.sendKeys("Calidad");
	    return this;
    }
    public ResourceCreatePage txt_displayNameUpdate(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesAddEnum.TXTDISPLAYNAME.value));
    	WebElement element = driver.findElement(txtDisplayName);
	    element.clear();
	    element.sendKeys("CalidadUpdate");
	    return this;
    }
    
    public ResourcePage btn_Save(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(btnSave));
    	WebElement element = driver.findElement(btnSave);
	    element.click();
	    return new ResourcePage(driver);
    }
}
