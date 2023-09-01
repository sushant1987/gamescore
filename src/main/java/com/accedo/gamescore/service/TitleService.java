/**
 * 
 */
package com.accedo.gamescore.service;

import com.accedo.gamescore.dataobject.Title;

/**
 * @author Sushant Kumar Singh
 *
 */
public interface TitleService {
	
	Title save(Title title);
	
	Title findById(String id);

}
