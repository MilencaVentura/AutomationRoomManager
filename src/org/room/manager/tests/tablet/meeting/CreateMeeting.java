package org.room.manager.tests.tablet.meeting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.pages.tablet.Home.HomePage;
import org.room.manager.pages.tablet.Scheduler.SchedulerPage;
import org.room.manager.pages.tablet.Scheduler.CredentialPage;
import org.room.manager.pages.tablet.Settings.SettingsPage;

public class CreateMeeting {
	 private static WebDriver driver = null;
	 Logger logger=Logger.getLogger("test04CreateMeeting");
	 @Test
	  public void createMeeting() {
		 PropertyConfigurator.configure("Log4j.properties");
		  String conferenceRoom = "RoomgGC-01";
		  String organizer = configReader.getUsername();
		  String subject = "Test Meeting QADEV02";
		  String attendee = configReader.getUsername()+ "@" +configReader.getDomain();
		  String password = configReader.getPassword();
		  driver.get(configReader.getTabletURL());
		  logger.info("Begin the Test: Create Meeting");
		  SettingsPage settings = new SettingsPage(driver);
		  settings.txtSearch(conferenceRoom);
		  settings.selectConferenceRoom();
		  HomePage home = settings.btnAccept();
		  SchedulerPage scheduler = home.clickBtnSchedule();
		  logger.info("Set a values for create a meeting");
		  scheduler.txtOrganizer(organizer);
		  scheduler.txtSubject(subject);
		  scheduler.txtAttendees(attendee);
		  CredentialPage credentials = scheduler.btnCreate();
		  logger.info("Give the credentials values");
		  credentials.txtUsername(organizer);
		  credentials.txtPassword(password);
		  scheduler = credentials.btnOk();
		  logger.info("Finish the Test: Create Meeting");
		  
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  driver = managerPage.getBrowserChrome();
	  }
	  
	  @AfterSuite
	  public void afterSuite() {
		  driver.quit();
	  }
}
