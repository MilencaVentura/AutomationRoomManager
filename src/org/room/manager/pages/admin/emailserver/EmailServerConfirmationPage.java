package org.room.manager.pages.admin.emailserver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerAddEnum;
import org.room.manager.modules.admin.emailserver.EmailServerConfirmationEnum;

public class EmailServerConfirmationPage {

	private WebDriver driver;
	By btnServer = EmailServerConfirmationEnum.BTNSERVER.value;
	By btnDelete = EmailServerConfirmationEnum.BTNDELETE.value;
	By btnOk = EmailServerAddEnum.BTNOK.value;
	
	public EmailServerConfirmationPage (WebDriver driver){
		this.driver = driver;
	}
    
	
	public EmailServerConfirmationPage btn_Delete(){
	    (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnDelete));
	    WebElement element = driver.findElement(btnDelete);
	    element.click();
	    return this;
	}
	public EmailServerPage btn_Save(){
		WebElement element = driver.findElement(btnOk);
	    element.click();
	    return new EmailServerPage(driver);
	}


}
