/**
 * 
 */
package com.accedo.gamescore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.accedo.gamescore.dataobject.HighScore;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface HighScoreRepository extends PagingAndSortingRepository<HighScore, String> {

	Optional<HighScore> findById(String id);
	
	HighScore save(HighScore save);
	
	List<HighScore> findAllByTitleId(String id, Sort sort);

}
