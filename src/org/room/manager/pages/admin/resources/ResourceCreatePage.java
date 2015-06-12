package org.room.manager.pages.admin.resources;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerEnum;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.modules.admin.HomeAdminEnum;
import org.room.manager.modules.admin.resources.ResourcesEnum;
/**
 * This page is needed to create a new resource. 
 * @author Milenca Ventura
 */

public class ResourceCreatePage {
	private WebDriver driver;
	By btnAdd = ResourcesEnum.BTNADD.value;
    By txtName = ResourcesEnum.TXTNAME.value;
    By txtDisplayName = ResourcesEnum.TXTDISPLAYNAME.value;
    By btnSave = ResourcesEnum.BTNSAVE.value;
    By btnClose = ResourcesEnum.BTNCLOSE.value;
    
	public ResourceCreatePage(WebDriver driver){
		this.driver = driver;
	}
	 
    public  ResourceCreatePage btn_Add(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
    	WebElement element = driver.findElement(btnAdd);
	    element.click();
	    return this;
    }
    public  ResourceCreatePage btn_Close(){
    	WebElement element = driver.findElement(btnClose);
	    element.click();
	    return this;
    }
    public  ResourceCreatePage txt_name(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesEnum.TXTNAME.value));
    	WebElement element =driver.findElement(txtName);
        element.clear();
        element.sendKeys("Resource1");
	    return this;
    }
    
    public ResourceCreatePage txt_displayName(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesEnum.TXTDISPLAYNAME.value));
    	WebElement element = driver.findElement(txtDisplayName);
	    element.clear();
	    element.sendKeys("Calidad");
	    return this;
    }
    
    public ResourceCreatePage btn_Save(){
    	WebElement element = driver.findElement(btnSave);
	    element.click();
	    return this;
    }
 
    public ResourceCreatePage Execute(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Resources")));
		HomeAdminPage.lnk_Resources(driver).click();
		return this;
	}
    public void AssertWithouName(String expectedResult){
    	assertEquals("Name must not be empty", driver.findElement(By.cssSelector("small.inline-error.ng-binding")).getText()); 
	}
    public void AssertCreateResource(String expectedResult){
    	 assertEquals("Resource1", driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div/span")).getText());
    }
}
