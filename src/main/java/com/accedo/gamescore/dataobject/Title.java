/**
 * 
 */
package com.accedo.gamescore.dataobject;

import org.springframework.data.annotation.Id;

/**
 * @author Sushant Kumar Singh
 *
 */
public class Title {
	
	@Id
	private String id;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
