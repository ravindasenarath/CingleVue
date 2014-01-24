package com.cinglevue.dao;

import java.util.List;

import com.cinglevue.model.Result;

/**
 * 
 * Iterface class for access Result Object
 * 
 * @author ravinda
 *
 */
public interface ResultDAO {

	List<Result> getResult(String school);
	
}
