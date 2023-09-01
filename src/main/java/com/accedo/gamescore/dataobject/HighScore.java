/**
 * 
 */
package com.accedo.gamescore.dataobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import jakarta.validation.constraints.NotNull;

/**
 * @author Sushant Kumar Singh
 *
 */
public class HighScore {

	@Id
	private String id;

	@NotNull
	private Integer score;
	
	@DBRef
	@NotNull
	private Title title;
	
	@DBRef
	@NotNull
	private User user;

	public String getId() {
		return id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
