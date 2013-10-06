package com.cinglevue.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;


/**
 * School, store as a JSON object
 * @author ravinda
 *
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class School implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6130134029287779462L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
