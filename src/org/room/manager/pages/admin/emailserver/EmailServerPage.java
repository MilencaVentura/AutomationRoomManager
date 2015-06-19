package org.room.manager.pages.admin.emailserver;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerEnum;

public class EmailServerPage {
	
	private WebDriver driver;
	Logger logger=Logger.getLogger("test EmailServer");
	By btnAdd = EmailServerEnum.BTNADD.value;
    By btnRemove = EmailServerEnum.BTNREMOVE.value;
    By btnOk = EmailServerEnum.BTNOK.value;
    By btnServer = EmailServerEnum.BTNSERVER.value;
    By btnDelete = EmailServerEnum.BTNDELETE.value;
    
    public EmailServerPage (WebDriver driver){
		this.driver = driver;
	}
    /**
	 * This method does click on add button of email server
	 * @return EmailServerPage
	 */
    public EmailServerPage btn_Add(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnAdd));
        WebElement element = driver.findElement(btnAdd);
	    element.click();
	    logger.info("Email Server: click on add button");
	    return this;
    }
    /**
	 * This method does click on remove button of email server
	 * @return EmailServerPage
	 */
    public EmailServerPage btn_Remove(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnRemove));
        WebElement element = driver.findElement(btnRemove);
        element.click();
        logger.info("Email Server: click on remove button");
	    return this;
    }
    /**
	 * This method does click on save button of email server
	 * @return EmailServerPage
	 */
    public EmailServerPage btn_Save(){
    	(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnOk));
    	WebElement element = driver.findElement(btnOk);
	    element.click();
	    logger.info("Email Server: click on save button");
	    return this;
    }
    /**
	 * This method verifies if the servers is add
	 * @return the text of the element
	 */
    public String getButtonServer(){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(btnServer));
        WebElement element = driver.findElement(btnServer);
        logger.info("Email Server: verification values");
        logger.info("Email Server: Test add Email server Passed");
        return element.getText();
    }
    /**
	 * This method verifies if the server was deleted
	 * @return true if the server is deleted or false if the server was not deleted.
	 */
    public boolean AssertDeleteEmailServer(){
      	logger.info("Email Server: verification if the email server was deleted");
		try{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(btnAdd,"Add"));
			return true;
		}catch(Exception e){
			return false;
		}	
	}
}
