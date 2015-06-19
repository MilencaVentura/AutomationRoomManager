package org.room.manager.pages.admin.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesRemoveEnum;;

/**
 * This page is needed to delete a resource. 
 * @author Milenca Ventura
 */

public class ResourceDeletePage {
	
	private WebDriver driver;
	By btnOkRemove = ResourcesRemoveEnum.BTNOKREMOVE.value;
	Logger logger=Logger.getLogger("test Resource");
	
    public ResourceDeletePage(WebDriver driver){
		this.driver = driver;
	}
    /**
	 * This method do click on OK remove  button.
	 * @return ResourcePage
	 */
    public ResourcePage btnOkRemoveResource(){
    	(new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(btnOkRemove));
    	WebElement element = driver.findElement(btnOkRemove);
	    element.click();
	    logger.info("Resource: Click on ok button for remove a resource.");
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.invisibilityOfElementLocated(btnOkRemove));
    	  	return new ResourcePage(driver);
        }
}
