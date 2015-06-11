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
	private static WebElement element = null;
	 
    public static WebElement btn_Add(WebDriver driver){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(EmailServerEnum.BTNADD.value));
	    element = driver.findElement(EmailServerEnum.BTNADD.value);
	    element.click();
	    return element;
    }
    
    public static WebElement btn_Remove(WebDriver driver){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(EmailServerEnum.BTNREMOVE.value));
	    element = driver.findElement(EmailServerEnum.BTNREMOVE.value);
	    return element;
    }

    public static WebElement txt_Hostname(WebDriver driver, String hostname){
	    element = driver.findElement(EmailServerEnum.TXTHOSTNAME.value);
	    element.clear();
	    element.sendKeys(hostname);
	    return element;
    }
    
    public static WebElement txt_Username(WebDriver driver,String username){
	    element = driver.findElement(EmailServerEnum.TXTUSERNAME.value);
	    element.clear();
	    element.sendKeys(username);
	    return element;
    }
    
    public static WebElement txt_Password(WebDriver driver,String password){
	    element = driver.findElement(EmailServerEnum.TXTPASSWORD.value);
	    element.clear();
	    element.sendKeys(password);
	    return element;
    }
    public static WebElement btn_Save(WebDriver driver){
	    element = driver.findElement(EmailServerEnum.BTNOK.value);
	    element.click();
	    return element;
    }
    
    public static WebElement btn_Server(WebDriver driver){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/a")));
        element = driver.findElement(EmailServerEnum.BTNSERVER.value);
        return element;
    }
    public static void Execute(WebDriver driver){
		HomeAdminPage.lnk_EmailServer(driver).click();			
	}
    public static void Assert(WebDriver driver, String expectedResult){
		assertEquals("The email server was not registered",expectedResult, 
				EmailServerAddPage.btn_Server(driver).getText());
	}
}
