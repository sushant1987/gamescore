/**
 * This is a service class for {@link User} data object
 */
package com.accedo.gamescore.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accedo.gamescore.dataobject.User;
import com.accedo.gamescore.repository.UserRepository;

/**
 * @author Sushant Kumar Singh
 *
 */
@Service
public class UserDefaultService implements UserService {
	
	Logger log = LoggerFactory.getLogger(UserDefaultService.class);

	private UserRepository userRepository;

	@Autowired
	public UserDefaultService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * This method will return user by id 
	 * @param id
	 * @return {@link User}
	 * @throws @{@link NoSuchElementException}
	 */
	@Override
	public User findById(String id) {
		return userRepository.findById(id).orElseThrow();
	}

}
