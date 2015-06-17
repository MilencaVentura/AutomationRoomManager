package org.room.manager.pages.admin.resources;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesEnum;
import org.room.manager.pages.admin.HomeAdminPage;

public class ResourcePage {
	private WebDriver driver;
	By btnAdd = ResourcesEnum.BTNADD.value;
    By btnResource = ResourcesEnum.BTNRESOURCE.value;
    By txtSearch = ResourcesEnum.TXTSEARCH.value;
    By firstResource = ResourcesEnum.FIRSTRESOURCE.value;
    By checkResource = ResourcesEnum.SELECTRESOURCE.value;
    By btnRemove = ResourcesEnum.BTNREMOVE.value;
    By allResources = ResourcesEnum.ALLRESOURCES.value;
    public ResourcePage(WebDriver driver){
		this.driver = driver;
	}
    
    public ResourcePage btnRemoveResource(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(btnRemove));
    	WebElement element = driver.findElement(btnRemove);
	    element.click();
    	  	return this;
        }
    
    public ResourcePage btnResource(){
	Actions act = new Actions(driver);
	(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(btnResource));
		act.moveToElement(driver.findElement(btnResource));
		WebElement element = driver.findElement(btnResource);
	  	act.doubleClick();
	  	act.perform();
	  	return this;
    }
    public ResourcePage selectResourceByName(){
    	Actions act = new Actions(driver);
		(new WebDriverWait(driver, 160)).until(ExpectedConditions.presenceOfElementLocated(firstResource));
		act.moveToElement(driver.findElement(firstResource));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement element = driver.findElement(firstResource);
		act.doubleClick();
	  	act.perform();
		return this;
	}
    public ResourcePage checkResource(){
		WebElement checkboxResource = (new WebDriverWait(driver, 160))
			.until(ExpectedConditions.presenceOfElementLocated(checkResource));
		checkboxResource.click();
		return this;
	}
    public ResourcePage txtSearch(String name){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtSearch));
    	driver.findElement(txtSearch).clear();
        driver.findElement(txtSearch).sendKeys(name);
        return this;
    }
    
	public  ResourcePage btn_Add(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
		WebElement element = driver.findElement(btnAdd);
	    element.click();
	    return this;
	}
	public ResourcePage Execute(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(By.linkText("Resources")));
		HomeAdminPage.lnk_Resources(driver).click();
		return this;
	}

    /*
     * get first resource by name and display name
     * */
    public String getFirstName(){
		WebElement firstResourceTableElement = (new WebDriverWait(driver, 60))
			.until(ExpectedConditions.presenceOfElementLocated(firstResource));
				return firstResourceTableElement.getText();
	}
    public String getFirstByDisplayName(){
		(new WebDriverWait(driver, 160))
			.until(ExpectedConditions.presenceOfElementLocated(firstResource));
		WebElement ResourceFirst = driver.findElements(firstResource).get(1);
		return ResourceFirst.getText();
	}
    private int getResource(){
		WebElement resource = (new WebDriverWait(driver, 60))
			.until(ExpectedConditions.presenceOfElementLocated(allResources));
		return resource.findElements(By.xpath("div")).size();
	}
	
	public boolean getAllresource(){
		return getResource() == 0;
	}
	/*
	 * Methods for verify the values
	 * */
	public void AssertWithouName(String expectedResult){
		assertEquals("Name must not be empty", driver.findElement(By.cssSelector("small.inline-error.ng-binding")).getText()); 
	}
}
