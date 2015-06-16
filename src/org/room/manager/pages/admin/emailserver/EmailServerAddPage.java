package org.room.manager.pages.admin.emailserver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerEnum;
import org.room.manager.pages.admin.HomeAdminPage;

/**
 * This page is for add a email server. 
 * @author Milenca Ventura
 */
public class EmailServerAddPage {
	private WebDriver driver;
	By btnAdd = EmailServerEnum.BTNADD.value;
    By btnRemove = EmailServerEnum.BTNREMOVE.value;
    By txtHostname = EmailServerEnum.TXTHOSTNAME.value;
    By txtUsername = EmailServerEnum.TXTUSERNAME.value;
    By txtPassword = EmailServerEnum.TXTPASSWORD.value;
    By btnOk = EmailServerEnum.BTNOK.value;
    By btnServer = EmailServerEnum.BTNSERVER.value;
    By btnDelete = EmailServerEnum.BTNDELETE.value;
	public EmailServerAddPage (WebDriver driver){
		this.driver = driver;
	}
	
    public EmailServerAddPage btn_Add(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnAdd));
        WebElement element = driver.findElement(btnAdd);
	    element.click();
	    return this;
    }
    
    public EmailServerAddPage btn_Remove(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnRemove));
        WebElement element = driver.findElement(btnRemove);
        element.click();
	    return this;
    }
    
    public EmailServerAddPage btn_Delete(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnDelete));
        WebElement element = driver.findElement(btnDelete);
        element.click();
	    return this;
    }
    public EmailServerAddPage txt_Hostname(String hostname){
    	WebElement element = driver.findElement(txtHostname);
	    element.clear();
	    element.sendKeys(hostname);
	    return this;
    }
    
    public EmailServerAddPage txt_Username(String username){
    	WebElement element = driver.findElement(txtUsername);
	    element.clear();
	    element.sendKeys(username);
	    return this;
    }
    
    public EmailServerAddPage txt_Password(String password){
    	WebElement element = driver.findElement(txtPassword);
	    element.clear();
	    element.sendKeys(password);
	    return this;
    }
    public EmailServerAddPage btn_Save(){
    	WebElement element = driver.findElement(btnOk);
	    element.click();
	    return this;
    }
    
    public String getButtonServer(){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(btnServer));
        WebElement element = driver.findElement(btnServer);
        return element.getText();
    }
    public EmailServerAddPage Execute(){
		HomeAdminPage.lnk_EmailServer(driver).click();
		return this;
	}
 
    public  EmailServerAddPage Assert(String expectedResult){
		assertEquals("The email server was not registered",expectedResult, btnServer);
		return this;
	}
    public boolean AssertDeleteEmailServer(){
		try{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(btnAdd,"Add"));
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
