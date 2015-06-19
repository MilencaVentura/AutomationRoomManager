package org.room.manager.pages.admin.emailserver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerAddEnum;

/**
 * This page is for add a email server. 
 * @author Milenca Ventura
 */
public class EmailServerAddPage {
	
	Logger logger=Logger.getLogger("Test EmailServer");
	
	private WebDriver driver;
    By txtHostname = EmailServerAddEnum.TXTHOSTNAME.value;
    By txtUsername = EmailServerAddEnum.TXTUSERNAME.value;
    By txtPassword = EmailServerAddEnum.TXTPASSWORD.value;
    By btnOk = EmailServerAddEnum.BTNOK.value;
    
	public EmailServerAddPage (WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method set a hostname of email server
	 * @param hostname
	 * @return EmailServerAddPage
	 */
    public EmailServerAddPage txt_Hostname(String hostname){
    	PropertyConfigurator.configure("Log4j.properties");
    	WebElement element = driver.findElement(txtHostname);
	    element.clear();
	    element.sendKeys(hostname);
	    logger.info("EmailServer: Set the hotsname");
	    return this;
    }
    /**
	 * This method set a username of email server
	 * @param username
	 * @return EmailServerAddPage
	 */
    public EmailServerAddPage txt_Username(String username){
    	PropertyConfigurator.configure("Log4j.properties");
    	WebElement element = driver.findElement(txtUsername);
	    element.clear();
	    element.sendKeys(username);
	    logger.info("EmailServer: Set the username");
	    return this;
    }
    /**
	 * This method set a password of email server
	 * @param password
	 * @return EmailServerAddPage
	 */
    public EmailServerAddPage txt_Password(String password){
    	PropertyConfigurator.configure("Log4j.properties");
    	WebElement element = driver.findElement(txtPassword);
	    element.clear();
	    element.sendKeys(password);
	    logger.info("EmailServer: Set the password");
	    return this;
    }
    /**
	 * This method does click on save button email server
	 * @return new EmailServerPage
	 */
    public EmailServerPage btn_Save(){
    	PropertyConfigurator.configure("Log4j.properties");
    	WebElement element = driver.findElement(btnOk);
	    element.click();
	    logger.info("EmailServer: click on save button");
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.invisibilityOfElementLocated(btnOk));

	    return new EmailServerPage(driver);
    }
}
