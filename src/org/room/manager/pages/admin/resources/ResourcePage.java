package org.room.manager.pages.admin.resources;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesEnum;
import org.room.manager.modules.admin.resources.ResourcesAddEnum;

/**
 * This page is needed to create a new resource. 
 * @author Milenca Ventura
 */

public class ResourcePage {
	private WebDriver driver;
	By btnAdd = ResourcesEnum.BTNADD.value;
    By btnResource = ResourcesEnum.BTNRESOURCE.value;
    By txtSearch = ResourcesEnum.TXTSEARCH.value;
    By firstResource = ResourcesEnum.FIRSTRESOURCE.value;
    By checkResource = ResourcesEnum.SELECTRESOURCE.value;
    By btnRemove = ResourcesEnum.BTNREMOVE.value;
    By allResources = ResourcesEnum.ALLRESOURCES.value;
    By elementDiv = ResourcesEnum.DIVELEMENT.value;
    By textElement = ResourcesEnum.RESOURCESTEXT.value;
    By resourceElement = ResourcesEnum.RESOURCECUSTOMNAME.value;
    By errorMessage = ResourcesAddEnum.ERRORMESSAGE.value;
    Logger logger=Logger.getLogger("test Resource");
    
    public ResourcePage(WebDriver driver){
		this.driver = driver;
	}
    
    public ResourcePage btnRemoveResource(){  	
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(btnRemove));
    	WebElement element = driver.findElement(btnRemove);
	    element.click();

	    logger.info("Resource: Click on remove button");
    	  	return this;
        }
    /**
	 * This method do click on add button 
	 * @return ResourcePage
	 */
	public  ResourcePage btn_Add(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(btnAdd));
		WebElement element = driver.findElement(btnAdd);
	    element.click();
	    logger.info("Resource: Click on save button");
	    return this;
	}

	/**
	 * This method is for list of resources, and search a specific resource 
	 * @param name
	 * @return WebElement
	 */
    private WebElement getResource(String name){
		WebElement resource = (new WebDriverWait(driver, 160))
			.until(ExpectedConditions.presenceOfElementLocated(allResources));
		List<WebElement> ResourcesElement = resource.findElements(elementDiv);
		 for (WebElement webElement : ResourcesElement) {
				String resourceName = webElement.findElement(textElement).getText();
			if (name.equals(resourceName)) {
				return webElement;
			}
		}
		 return null;
	}
    /**
	 * This method is for list of resources, and search a specific resource by display name
	 * @param customName
	 * @return WebElement
	 */
    private WebElement getCustomNameResource(String customName){
		WebElement resource = (new WebDriverWait(driver, 160))
			.until(ExpectedConditions.presenceOfElementLocated(allResources));
		List<WebElement> ResourcesElement = resource.findElements(elementDiv);
		 for (WebElement webElement : ResourcesElement) {
				String resourceCustomName = webElement.findElement(resourceElement).getText();
			if (customName.equals(resourceCustomName)) {
				return webElement;
			}
		}
		 return null;
	}
    /**
	 * This method is for select a resource
	 * @param name
	 * @return ResourcePage
	 */
    public ResourcePage   clickSelectResource(String name){
    	Actions act = new Actions(driver);
    	WebElement resource = getResource(name);
    	act.doubleClick(resource);
    	act.perform();
    	return this;
    }
    /**
	 * This method is for check a resource
	 * @param name
	 * @return ResourcePage
	 */
    public ResourcePage checkResource(String name){
    	WebElement resource = getResource(name);
    	resource.click();
		logger.info("Resource: check in resource");
		return this;
	}
    /**
	 * This method is boolean for verify if the resource exist.
	 * @param name
	 * @return resource
	 */
	public boolean getAllresource(String name){
		return getResource(name) == null;
	}
	/**
	 * This method is for get a resource by name
	 * @param name
	 * @return text of the element
	 */
	public String getResourceName(String name){
		WebElement resource = getResource(name);
		return resource.findElement(textElement).getText();
	}
	/**
	 * This method is for get a resource by  custom name
	 * @param customName
	 * @return text of the element
	 */
	public String getResourceCustomName(String customName){
		WebElement resource = getCustomNameResource(customName);
		return resource.findElement(resourceElement).getText();
	}
	/**
	 * This method is for verify the message.
	 * @param customName
	 * @return text of the element
	 */
	public 	String verificationResourceWithoutName(String expectedResult){
			String message = driver.findElement(errorMessage).getText();
			logger.info("Resource: verification values");
			return message;
	}
}
