package org.room.manager.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * This class select a driver for run test cases.
 * @author Milenca Ventura
 */
public class configReader {
	static Properties driver = new Properties();
	static Properties url = new Properties();
	static Properties resources = new Properties();
    static InputStream input = null;
    static Properties resourceValue = new Properties();
       
	/**
	 * Select a browser
	 */
private static void initializeDriver() {
	try {
        input = new FileInputStream("properties/config.properties");
        driver.load(input);

  } catch (IOException ex) {
        ex.printStackTrace();
  } finally {
        if (input != null) {
              try {
                    input.close();
              } catch (IOException e) {
                    e.printStackTrace();
              }
        }
  	}
}
/**
 * give a values of exchange email server.
 */
private static void initializeResources() {
	try {
        input = new FileInputStream("properties/resources.properties");
        resources.load(input);

  } catch (IOException ex) {
        ex.printStackTrace();
  } finally {
        if (input != null) {
              try {
                    input.close();
              } catch (IOException e) {
                    e.printStackTrace();
              }
        }
  	}
}
/**
 * give a url of room manager
 */
private static void initializeUrl() {
	try {
        input = new FileInputStream("properties/url.properties");
        url.load(input);

  } catch (IOException ex) {
        ex.printStackTrace();
  } finally {
        if (input != null) {
              try {
                    input.close();
              } catch (IOException e) {
                    e.printStackTrace();
              }
        }
  	}
}
/**
 * give a datas of resources
 */
private static void getResource() {
	try {
        input = new FileInputStream("properties/resourcesData.properties");
        url.load(input);

  } catch (IOException ex) {
        ex.printStackTrace();
  } finally {
        if (input != null) {
              try {
                    input.close();
              } catch (IOException e) {
                    e.printStackTrace();
              }
        }
  	}
}
public static String getChromeDriver(){
	initializeDriver();
    return driver.getProperty("DRIVER-CHROME");
	}
public static String getUrl(){
	initializeUrl();
    return url.getProperty("URL");
	}
public static String getHostName(){
	initializeResources();
    return resources.getProperty("HOSTNAME");
	}
public static String getUsername(){
	initializeResources();
    return resources.getProperty("USERNAME");
	}
public static String getPassword(){
	initializeResources();
    return resources.getProperty("PASSWORD");
	}
public static String getDomain(){
	initializeResources();
	return resources.getProperty("DOMAIN");
}
public static String getTabletURL(){
	initializeDriver();
	return resources.getProperty("TABLET_URL");
}
public static String getName(){
	getResource();
    return resourceValue.getProperty("NAME");
	}
public static String getDisplayName(){
	getResource();
    return resourceValue.getProperty("CUSTOMNAME");
	}
public static String getIcon(){
	getResource();
    return resourceValue.getProperty("FONTICON");
	}
public static String getDescription(){
	getResource();
    return resourceValue.getProperty("DESCRIPTION");
	}
}