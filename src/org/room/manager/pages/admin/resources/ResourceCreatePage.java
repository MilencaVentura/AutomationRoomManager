package org.room.manager.pages.admin.resources;

import org.apache.log4j.Logger;
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
    Logger logger=Logger.getLogger("test Resource");
    
	public ResourceCreatePage(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method does click on close button
	 * @return ResourcePage
	 */
    public  ResourcePage btn_Close(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(btnClose));
    	WebElement element = driver.findElement(btnClose);
	    element.click();
	    logger.info("Resource: Click on close button");
	    return new ResourcePage(driver);
    }
    /**
	 * This method set a name of the resource
	 * @return ResourceCreatePage
	 */
    public  ResourceCreatePage txt_name(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesAddEnum.TXTNAME.value));
    	WebElement element =driver.findElement(txtName);
        element.clear();
        element.sendKeys("Resource1");
        logger.info("Resource: Set a name of resource");
	    return this;
    }
    /**
	 * This method set a display name of the resource
	 * @return ResourceCreatePage
	 */
    public ResourceCreatePage txt_displayName(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesAddEnum.TXTDISPLAYNAME.value));
    	WebElement element = driver.findElement(txtDisplayName);
	    element.clear();
	    element.sendKeys("Calidad");
	    logger.info("Resource: Set a display name of resource");
	    return this;
    }
    /**
	 * This method do click on save button.
	 * @return ResourcePage
	 */
  public ResourcePage clickSaveButton(){
    	(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(btnSave));
    	WebElement element = driver.findElement(btnSave);
    	element.click();
	    logger.info("Resource: Click on save button");	    
	    return new ResourcePage(driver);
    }
    public ResourcePage btn_Save(){
    	(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(btnSave));
    	WebElement element = driver.findElement(btnSave);
    	element.click();
	    logger.info("Resource: Click on save button");
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.invisibilityOfElementLocated(btnSave));
	    return new ResourcePage(driver);
    }
}
