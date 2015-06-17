package org.room.manager.pages.admin.resources;

import static org.junit.Assert.assertEquals;
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
    
    public ResourcePage(WebDriver driver){
		this.driver = driver;
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
	public void AssertWithouName(String expectedResult){
		assertEquals("Name must not be empty", driver.findElement(By.cssSelector("small.inline-error.ng-binding")).getText()); 
	}
	public void AssertCreateResource(String expectedResult){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[3]/div[3]/div[2]/div/span")));
		assertEquals("Resource1", driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[3]/div[3]/div[2]/div/span")).getText());
	 }
	public void AssertUpdateResource(String expectedResult){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[3]/div[4]/div[2]/div/span")));
		 assertEquals("Calidad", driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[3]/div[4]/div[2]/div/span")).getText());
	   	 //assertEquals("tv", driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[3]/div[4]/div[2]/div/span")).getText());
	}
}
