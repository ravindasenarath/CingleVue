package com.cinglevue.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Result,
 * @author ravinda
 *
 */
@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Result implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8680347400254366914L;
	@Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
	@Embedded
	private School school;
	@Embedded
	private Subject subject;
	@Basic
	private double y3;
	@Basic
	private double y5;
	@Basic
	private double y7;
	@Basic
	private double y9;
	@Basic
	private double rawGainY3ToY5;
	@Basic
	private double factoredGainY3ToY5;
	@Basic
	private double cLGGainY3ToY5;
	@Basic
	private double gainInGainY3ToY5;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School shool) {
		this.school = shool;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public double getY3() {
		return y3;
	}
	
	public void setY3(double y3) {
		this.y3 = y3;
	}
	
	public double getY5() {
		return y5;
	}
	
	public void setY5(double y5) {
		this.y5 = y5;
	}
	
	public double getY7() {
		return y7;
	}
	
	public void setY7(double y7) {
		this.y7 = y7;
	}
	
	public double getY9() {
		return y9;
	}
	
	public void setY9(double y9) {
		this.y9 = y9;
	}
	
	public double getRawGainY3ToY5() {
		return rawGainY3ToY5;
	}
	
	public void setRawGainY3ToY5(double rawGainY3ToY5) {
		this.rawGainY3ToY5 = rawGainY3ToY5;
	}
	
	public double getFactoredGainY3ToY5() {
		return factoredGainY3ToY5;
	}
	
	public void setFactoredGainY3ToY5(double factoredGainY3ToY5) {
		this.factoredGainY3ToY5 = factoredGainY3ToY5;
	}
	
	public double getcLGGainY3ToY5() {
		return cLGGainY3ToY5;
	}
	
	public void setcLGGainY3ToY5(double cLGGainY3ToY5) {
		this.cLGGainY3ToY5 = cLGGainY3ToY5;
	}
	
	public double getGainInGainY3ToY5() {
		return gainInGainY3ToY5;
	}
	
	public void setGainInGainY3ToY5(double gainInGainY3ToY5) {
		this.gainInGainY3ToY5 = gainInGainY3ToY5;
	}
	
	
	
}
