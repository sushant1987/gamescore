/**
 * 
 */
package com.accedo.gamescore.repository;

import org.springframework.data.repository.CrudRepository;

import com.accedo.gamescore.dataobject.Title;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface TitleRepository extends CrudRepository<Title, String> {

}
