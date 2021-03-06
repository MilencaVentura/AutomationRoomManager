package org.room.manager.tests.tablet.search;

import java.util.concurrent.TimeUnit;

import org.room.manager.utils.HttpRequest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.tablet.Home.HomePage;
import org.room.manager.pages.tablet.Settings.SettingsPage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.pages.tablet.Search.SearchPage;

public class SearchByName {

	private static WebDriver driver = null;
	 Logger logger=Logger.getLogger("test04SearchByName");
	
	 @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
		     driver = managerPage.getBrowserChrome();
		     HttpRequest.addEmailServerJson(configReader.getUsername(),configReader.getPassword(),configReader.getHostName());
		}
	 
	 @Test (groups = {"ACCEPTANCE"})
	  public void SearchRoomByName() {
		  PropertyConfigurator.configure("Log4j.properties");
		  String conferenceRoom = "RoomgGC-01";
		  String searchTxt = "01";
		  String expectedResult = "RoomSM-01";
		  driver.get(configReader.getTabletURL());
		  logger.info("Begin the Test: Search by Name");
		  SettingsPage settings = new SettingsPage(driver);
		  settings.txtSearch(conferenceRoom);
		  settings.selectConferenceRoom();
		  HomePage home = settings.btnAccept();
		  SearchPage search = home.clickBtnSearch();
		  search.clickBtnAdvanced();
		  logger.info("Set a values for search");
		  search.setTxtRoomName(searchTxt);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  logger.info("verification the datas enter.");
		  //boolean searchP = search.getAllrooms();
		  // Assert.assertTrue(searchP, message);
		  search.AssertSearchByName(expectedResult);	
		  logger.info("Finish the Test: Search by Name");
		  
	  }
	  
	  @AfterSuite (groups = {"ACCEPTANCE"})
	  public void afterSuite() {
		  driver.quit();
	  }
}
