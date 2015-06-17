package org.room.manager.tests.tablet.search;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.tablet.Home.HomePage;
import org.room.manager.pages.tablet.Search.SearchPage;
import org.room.manager.pages.tablet.Settings.SettingsPage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
/*
driver.get(baseUrl + "/tablet/#/home");
driver.findElement(By.cssSelector("div.tile-button-search")).click();
driver.findElement(By.xpath("//button[@type='button']")).click();
driver.findElement(By.id("txtMinimumCapacity")).clear();
driver.findElement(By.id("txtMinimumCapacity")).sendKeys("40");
assertEquals("RoomSM-01", driver.findElement(By.id("556ef8fab49dd60c08ec594e")).getText());
*/
public class SearchByCapacity {
	private static WebDriver driver = null;
	 Logger logger=Logger.getLogger("test04SearchByCapacity");
	 @Test (groups = {"ACCEPTANCE"})
	  public void SearchRoomByCapacity() {
		  PropertyConfigurator.configure("Log4j.properties");
		  String conferenceRoom = "RoomgGC-01";
		  String searchTxt = "40";
		  String expectedResult = "RoomSM-01";
		  driver.get(configReader.getTabletURL());
		  logger.info("Begin the Test: Search by Capacity");
		  SettingsPage settings = new SettingsPage(driver);
		  settings.txtSearch(conferenceRoom);
		  settings.selectConferenceRoom();
		  HomePage home = settings.btnAccept();
		  SearchPage search = home.clickBtnSearch();
		  search.clickBtnAdvanced();
		  logger.info("Set a values for search");
		  search.setTxtCapacity(searchTxt);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  logger.info("verification the datas enter.");
		  search.AssertSearchByCapacity(expectedResult);	
		  logger.info("Finish the Test: Search by Capacity");
	  }
	  @BeforeSuite (groups = {"ACCEPTANCE"})
	  public void beforeSuite() {
		  driver = managerPage.getBrowserChrome();
	  }
	  @AfterSuite (groups = {"ACCEPTANCE"})
	  public void afterSuite() {
		  driver.quit();
	  }
}
