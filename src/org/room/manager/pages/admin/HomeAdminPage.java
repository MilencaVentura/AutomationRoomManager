package org.room.manager.pages.admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.HomeAdminEnum;

public class HomeAdminPage {
	By linkEmailServer = HomeAdminEnum.LINKEMAILSERVER.value;
	By linkResource = HomeAdminEnum.LINKRESOURCES.value;
	private WebDriver driver;
	
	public HomeAdminPage(WebDriver driver){
			this.driver = driver;
		}
	/**
	 * This method select the link of the email server
	 * @return EmailServerPage
	 */
    public  EmailServerPage lnk_EmailServer(){
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(HomeAdminEnum.LINKEMAILSERVER.value));
	    WebElement element = driver.findElement(linkEmailServer);
	    element.click();
	    return new EmailServerPage(driver);
    }   
    /**
	 * This method select the link of the resource
	 * @return ResourcePage
	 */
    public  ResourcePage lnk_Resources(){
	    (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(HomeAdminEnum.LINKRESOURCES.value));
	    WebElement element = driver.findElement(linkResource);
	    element.click();
	    return new ResourcePage(driver);
    }
}