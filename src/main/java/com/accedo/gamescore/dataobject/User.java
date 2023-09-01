/**
 * 
 */
package com.accedo.gamescore.dataobject;

import org.springframework.data.annotation.Id;

/**
 * @author Sushant Kumar Singh
 *
 */
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
