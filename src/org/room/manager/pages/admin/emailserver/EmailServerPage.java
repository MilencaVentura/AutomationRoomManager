package org.room.manager.pages.admin.emailserver;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerEnum;
import org.room.manager.pages.admin.HomeAdminPage;

public class EmailServerPage {
	
	private WebDriver driver;
	By btnAdd = EmailServerEnum.BTNADD.value;
    By btnRemove = EmailServerEnum.BTNREMOVE.value;
    By btnOk = EmailServerEnum.BTNOK.value;
    By btnServer = EmailServerEnum.BTNSERVER.value;
    By btnDelete = EmailServerEnum.BTNDELETE.value;
    
    public EmailServerPage (WebDriver driver){
		this.driver = driver;
	}
    public EmailServerPage btn_Add(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnAdd));
        WebElement element = driver.findElement(btnAdd);
	    element.click();
	    return this;
    }
    
    public EmailServerPage btn_Remove(){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnRemove));
        WebElement element = driver.findElement(btnRemove);
        element.click();
	    return this;
    }
        
    public EmailServerPage btn_Save(){
    	(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(btnOk));
    	WebElement element = driver.findElement(btnOk);
	    element.click();
	    return this;
    }
    
    public String getButtonServer(){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(btnServer));
        WebElement element = driver.findElement(btnServer);
        return element.getText();
    }
    public EmailServerPage Execute(){
		HomeAdminPage.lnk_EmailServer(driver).click();
		return this;
	}
 
    public  EmailServerPage Assert(String expectedResult){
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
