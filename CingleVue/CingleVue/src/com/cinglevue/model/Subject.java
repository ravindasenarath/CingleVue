package com.cinglevue.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Subject, Store subject details
 * @author ravinda
 *
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Subject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3983995825923255053L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
