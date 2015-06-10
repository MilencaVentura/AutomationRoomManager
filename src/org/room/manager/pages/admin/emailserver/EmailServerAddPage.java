package org.room.manager.pages.admin.emailserver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is for add a email server. 
 * @author Milenca Ventura
 */
public class EmailServerAddPage {
	private static WebElement element = null;
	 
    public static WebElement btn_Add(WebDriver driver){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(By.xpath("//div[2]/button"),"Add"));
	    element = driver.findElement(By.xpath("//div[2]/button"));
	    return element;
    }
    
    public static WebElement btn_Remove(WebDriver driver){
        (new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(By.xpath("//button[2]"),"Remove"));
	    element = driver.findElement(By.xpath("//button[2]"));
	    return element;
    }
    
    public static WebElement txtbx_Hostname(WebDriver driver){
	    element = driver.findElement(By.id("add-mailserver-hostname"));
	    return element;
    }
    
    public static WebElement txtbx_Username(WebDriver driver){
	    element = driver.findElement(By.id("add-mailserver-username"));
	    return element;
    }
    
    public static WebElement txtbx_Password(WebDriver driver){
	    element = driver.findElement(By.id("add-mailserver-password"));
	    return element;
    }
    public static WebElement btn_Save(WebDriver driver){
	    element = driver.findElement(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary"));
	    return element;
    }
    
    public static WebElement btn_Server(WebDriver driver){
        (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/a")));
        element = driver.findElement(By.xpath("//div/div/a"));
        return element;
    }
}
