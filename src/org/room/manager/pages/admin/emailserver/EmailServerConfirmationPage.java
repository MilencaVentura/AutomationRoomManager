package org.room.manager.pages.admin.emailserver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerAddEnum;
import org.room.manager.modules.admin.emailserver.EmailServerConfirmationEnum;

public class EmailServerConfirmationPage {
	
	Logger logger=Logger.getLogger("test EmailServer");
	
	private WebDriver driver;
	By btnServer = EmailServerConfirmationEnum.BTNSERVER.value;
	By btnDelete = EmailServerConfirmationEnum.BTNDELETE.value;
	By btnOk = EmailServerAddEnum.BTNOK.value;
	
	public EmailServerConfirmationPage (WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method does click on delete button of email server
	 * @return EmailServerConfirmationPage
	 */	
	public EmailServerConfirmationPage btn_Delete(){
	    (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnDelete));
	    WebElement element = driver.findElement(btnDelete);
	    element.click();
	    logger.info("Email Server: Click on delete button");
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.invisibilityOfElementLocated(btnDelete));

	    return this;
	}
	/**
	 * This method does click on save button of email server
	 * @return EmailServerPage
	 */	
	public EmailServerPage btn_Save(){
		WebElement element = driver.findElement(btnOk);
	    element.click();
	    logger.info("Email Server: click on confirmation button");
	    return new EmailServerPage(driver);
	}
}
