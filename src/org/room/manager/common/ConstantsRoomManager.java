package org.room.manager.common;

import org.openqa.selenium.By;

/**
 * This class contains all constants for Room Manager
 * @author Milenca Ventura
 *
 */
public enum ConstantsRoomManager {
	ADMINURL (By.xpath("//button[2]"));
	
    public final By value;  
    
    private ConstantsRoomManager(By value){
    	this.value = value;
    	
    }
}
