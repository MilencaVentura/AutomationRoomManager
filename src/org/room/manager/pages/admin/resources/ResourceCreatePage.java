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
	public ResourceCreatePage(WebDriver driver){
		this.driver = driver;
	}

	 
    public  ResourceCreatePage btn_Add(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
    	WebElement element = driver.findElement(ResourcesEnum.BTNADD.value);
	    element.click();
	    return this;
    }

    public  ResourceCreatePage txt_name(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesEnum.TXTNAME.value));
    	WebElement element =driver.findElement(ResourcesEnum.TXTNAME.value);
        element.clear();
        element.sendKeys("");
	    return this;
    }
    
    public ResourceCreatePage txt_displayName(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(ResourcesEnum.TXTDISPLAYNAME.value));
    	WebElement element = driver.findElement(ResourcesEnum.TXTDISPLAYNAME.value);
	    element.clear();
	    element.sendKeys("Calidad");
	    return this;
    }
    
    public ResourceCreatePage btn_Save(){
    	WebElement element = driver.findElement(ResourcesEnum.BTNSAVE.value);
	    element.click();
	    return this;
    }
 
    public ResourceCreatePage Execute(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Resources")));
		HomeAdminPage.lnk_Resources(driver).click();
		return this;
		//assertEquals("Resources", driver.findElement(By.linkText("Resources")).getText());
	}
    public void Assert( String expectedResult){
		assertEquals("The Resource is created",expectedResult, 
				EmailServerAddPage.btn_Server(driver).getText());
	}
    public void AssertWithouName(String expectedResult){
    	assertEquals("Name must not be empty", driver.findElement(By.cssSelector("small.inline-error.ng-binding")).getText()); 
	}
}
