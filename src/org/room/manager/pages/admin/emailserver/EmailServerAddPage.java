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
    
	public EmailServerAddPage (WebDriver driver){
		this.driver = driver;
	}
	
	 /*aumentar variables globales*/
    public EmailServerAddPage btn_Add(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(EmailServerEnum.BTNADD.value));
        WebElement element = driver.findElement(btnAdd);
	    element.click();
	    return this;
    }
    
    public EmailServerAddPage btn_Remove(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(EmailServerEnum.BTNREMOVE.value));
        WebElement element = driver.findElement(btnRemove);
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
    
    public EmailServerAddPage btn_Server(){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/a")));
        WebElement element = driver.findElement(btnServer);
        return this;
    }
    public EmailServerAddPage Execute(){
		HomeAdminPage.lnk_EmailServer(driver).click();
		return this;
	}
    /*
     *   
     * */
    public EmailServerAddPage btn_Delete(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pull-right > button.btn-clear.info")));
    	WebElement element =driver.findElement(btnRemove);
    	element.click();
    	return this;
    }
    public  EmailServerAddPage Assert(String expectedResult){
		assertEquals("The email server was not registered",expectedResult, btnServer);
		/*
		 * EmailServerAddPage.btn_Server().getText()
		 * */
		return this;
	}
    public void AssertDelete(String string){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(EmailServerEnum.BTNADD.value));
	    assertEquals("Add", driver.findElement(btnAdd));
    }
}
