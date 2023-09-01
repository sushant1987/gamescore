/**
 * 
 */
package com.accedo.gamescore.service;

import java.util.List;

import com.accedo.gamescore.dataobject.HighScore;
import com.accedo.gamescore.exception.UnprocessableEntityException;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface HighScoreService {
	
	HighScore findById(String id);
	
	void save(HighScore highScore) throws UnprocessableEntityException;
	
	List<HighScore> findAll();

	List<HighScore> findByUserId(String id);
	
	/**
	 * This will return high score list for a user
	 * 
	 * @param userId
	 * @return {@link List<HighScore>}
	 */
	List<HighScore> findByTitleByScoreDesc(String userId);

}
