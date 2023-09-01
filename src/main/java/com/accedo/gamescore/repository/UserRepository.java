/**
 * 
 */
package com.accedo.gamescore.repository;

import org.springframework.data.repository.CrudRepository;

import com.accedo.gamescore.dataobject.User;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface UserRepository extends CrudRepository<User, String> {

}
