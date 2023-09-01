/**
 * 
 */
package com.accedo.gamescore.service;

import com.accedo.gamescore.dataobject.User;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface UserService {
	
	User save(User user);
	
	User findById(String id);

}
