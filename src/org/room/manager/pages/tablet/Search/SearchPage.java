package org.room.manager.pages.tablet.Search;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.resources.ResourcesEnum;
import org.room.manager.modules.tablet.search.SearchEnum;

public class SearchPage {

	WebDriver driver;
	By btnAdvanced = SearchEnum.BTNADVANCED.value;
	By txtRoomName = SearchEnum.TXTROOMNAME.value;
	By txtMiniumCapacity = SearchEnum.TXTCAPACITY.value;
	By allRoom = SearchEnum.ALLROOMS.value;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}
	public void setTxtRoomName(String roomName){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtRoomName));
		driver.findElement(txtRoomName).clear();
		driver.findElement(txtRoomName).sendKeys(roomName);
	}
	
	public void setTxtCapacity(String roomName){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(txtMiniumCapacity));
		driver.findElement(txtMiniumCapacity).clear();
		driver.findElement(txtMiniumCapacity).sendKeys(roomName);
	}	
	public SearchPage clickBtnAdvanced(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnAdvanced));
		driver.findElement(btnAdvanced).click();
		return this;
	}
	 private int getRoom(){
			WebElement room = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(allRoom));
			return room.findElements(By.xpath("div")).size();
		}
		
	public boolean getAllrooms(){
		if(getRoom() == 0)
		{
			System.out.print("Not exist a room with this value");
		}
			return true;
		}
	
	public void AssertSearchByName(String expectedResult){
	    	(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(By.id("556ef8fab49dd60c08ec594e")));
	    	assertEquals("RoomSM-01", driver.findElement(By.id("556ef8fab49dd60c08ec594e")).getText());
	    	/*(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(By.id("556ef8fab49dd60c08ec5957")));
	        assertEquals(expectedResult, driver.findElement(By.id("556ef8fab49dd60c08ec5957")).getText());*/
	        }
	public void AssertSearchByCapacity(String expectedResult){
    	(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(By.id("556ef8fab49dd60c08ec594e")));
    	assertEquals("RoomSM-01", driver.findElement(By.id("556ef8fab49dd60c08ec594e")).getText());
    	  }
	
}
