package org.room.manager.pages.admin;
import org.openqa.selenium.WebDriver;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.HomeAdminEnum;

public class HomeAdminPage {
	private static WebElement element = null;
	 	public static void Execute(WebDriver driver){
		LoginPage.btn_signIn(driver).click(); 
	}
   
    public static WebElement lnk_EmailServer(WebDriver driver){
	    (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(HomeAdminEnum.LINKEMAILSERVER.value));
	    element = driver.findElement(HomeAdminEnum.LINKEMAILSERVER.value);
	    return element;
    }   
    public static WebElement lnk_Resources(WebDriver driver){
	    (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(HomeAdminEnum.LINKRESOURCES.value));
	    element = driver.findElement(HomeAdminEnum.LINKRESOURCES.value);
	    return element;
    }
}