package org.room.manager.pages.admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is for login to Room Manager
 * @author Milenca Ventura
 */
public class LoginPage {
	private static WebElement element = null;
	 
    public static WebElement btn_signIn(WebDriver driver){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button")));
	    element = driver.findElement(By.xpath("//button"));
	    return element;
    }
}
