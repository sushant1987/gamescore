/**
 * 
 */
package com.accedo.gamescore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accedo.gamescore.dataobject.Title;
import com.accedo.gamescore.repository.TitleRepository;

/**
 * @author Sushant Kumar Singh
 *
 */

@Service
public class TitleDefaultService implements TitleService {
	
	Logger log = LoggerFactory.getLogger(TitleDefaultService.class);

	private TitleRepository titleRepository;

	@Autowired
	public TitleDefaultService(TitleRepository titleRepository) {
		this.titleRepository = titleRepository;
	}

	@Override
	public Title save(Title title) {
		return titleRepository.save(title);
	}

	@Override
	public Title findById(String id) {
		return titleRepository.findById(id).orElseThrow();
	}

}
