/**
 * 
 */
package com.accedo.gamescore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.accedo.gamescore.dataobject.HighScore;
import com.accedo.gamescore.dataobject.Title;
import com.accedo.gamescore.dataobject.User;
import com.accedo.gamescore.exception.UnprocessableEntityException;
import com.accedo.gamescore.repository.HighScoreRepository;

/**
 * @author Sushant Kumar Singh
 *
 */
@Service
public class HighScoreDefaultService implements HighScoreService {
	
	Logger log = LoggerFactory.getLogger(HighScoreDefaultService.class);

	private static final String SCORE = "score";

	private HighScoreRepository highScoreRepository;

	private TitleService titleService;

	private UserService userService;

	@Autowired
	public HighScoreDefaultService(HighScoreRepository highScoreRepository, TitleService titleService,
			UserService userService) {
		this.highScoreRepository = highScoreRepository;
		this.titleService = titleService;
		this.userService = userService;
	}

	@Override
	public HighScore findById(String id) {
		return highScoreRepository.findById(id).orElseThrow();
	}

	@Override
	public List<HighScore> findAll() {
		return (List<HighScore>) highScoreRepository.findAll(Sort.by(SCORE));
	}

	@Override
	public List<HighScore> findByUserId(String id) {
		return (List<HighScore>) highScoreRepository.findAll(Sort.by(Direction.DESC, SCORE));
	}

	/**
	 * This service will save the high score
	 * 
	 * @param {@link {@link HighScore}}
	 */
	@Transactional(noRollbackFor = Exception.class)
	@Override
	public void save(HighScore highScore) throws UnprocessableEntityException {
		saveOrFindTitle(highScore);
		saveOrFindUser(highScore);
		highScoreRepository.save(highScore);
	}
	/**
	 * This will return high score list for a title
	 * 
	 * @param userId
	 * @return {@link List<HighScore>}
	 */
	@Override
	public List<HighScore> findByTitleByScoreDesc(String userId) {
		return highScoreRepository.findAllByTitleId(userId, Sort.by(SCORE));
	}

	private void saveOrFindTitle(HighScore highScore) throws UnprocessableEntityException {
		Title title = highScore.getTitle();
		if (!StringUtils.hasText(title.getId()) && !StringUtils.hasText(title.getName())) {
			log.error("Title do not have id and name");
			throw new UnprocessableEntityException("Title should have either id or name");
		}
		if (!StringUtils.hasText(title.getId())) {
			highScore.setTitle(titleService.save(title));
		} else {
			try {
				highScore.setTitle(titleService.findById(title.getId()));
			} catch (NoSuchElementException e) {
				log.debug("Title doesn't exist for the id");
				highScore.setTitle(titleService.save(title));
			}
		}
	}

	private void saveOrFindUser(HighScore highScore) throws UnprocessableEntityException {
		User user = highScore.getUser();
		if (!StringUtils.hasText(user.getId()) && !StringUtils.hasText(user.getFirstName())) {
			log.error("User do not have id and first name");
			throw new UnprocessableEntityException("User should have either id or first name");
		}
		if (!StringUtils.hasText(user.getId())) {
			highScore.setUser(userService.save(user));
		} else {
			try {
				highScore.setUser(userService.findById(user.getId()));
			} catch (NoSuchElementException e) {
				log.debug("User doesn't exist for the id");
				highScore.setUser(userService.save(user));
			}
		}
	}

}
