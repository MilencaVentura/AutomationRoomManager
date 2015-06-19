package org.room.manager.tests.admin.emailserver;
import org.room.manager.utils.HttpRequest;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.room.manager.common.Common;
import org.room.manager.pages.admin.HomeAdminPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.utils.configReader;
import org.apache.log4j.Logger;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.LoginPage;;

/**
 * This test case is for verify that is possible add a email server in Room Manager. 
 * @author Milenca Ventura
 */
public class AddEmailServerToRoomManager {
	
	private static WebDriver driver = null;
    Logger logger=Logger.getLogger("test01AddEmailServer");
    
    @BeforeSuite (groups = {"ACCEPTANCE"})
	public void setUp() throws Exception {
        driver = managerPage.getBrowserChrome();
        HttpRequest.deleteServiceByName("Microsoft Exchange Server 2010 SP2");
	}
	@Test  (groups = {"ACCEPTANCE"})
	public void registerEmailService() throws Exception {
		String expectedResult = configReader.getHostName() + "\nMicrosoft Exchange Server 2010 SP2";
		String message = "The email server is not registered";
		driver.get(configReader.getUrl() + "/admin/#/login");
		LoginPage login = new LoginPage(driver);
		login.btn_signIn();
		HomeAdminPage home = new HomeAdminPage(driver);
		Common refresh = new Common();
		refresh.RefreshPage(driver);
		home.lnk_EmailServer();
		EmailServerPage emailServer = new EmailServerPage(driver);
		emailServer.btn_Add();
		EmailServerAddPage addEmailServer = new EmailServerAddPage(driver);
		addEmailServer.txt_Hostname( configReader.getHostName()).txt_Username( configReader.getUsername())
		.txt_Password( configReader.getPassword()).btn_Save();
		Assert.assertEquals(emailServer.getButtonServer(), expectedResult, message);
	}
	
	@AfterSuite (groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   HttpRequest.deleteServiceByName("Microsoft Exchange Server 2010 SP2");
	   driver.quit();
	}
}
