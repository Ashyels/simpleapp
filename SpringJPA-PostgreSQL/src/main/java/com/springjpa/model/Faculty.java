package com.springjpa.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "established_date")
	private Date established_date;

	@Column(name = "name")
	private String name;

	// constructor lebih penting
	protected Faculty() {
		
	}

	// constructor penting
	public Faculty(String name, Date established_date) {
		this.name = name;
		this.established_date = established_date;
	}

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setId(String name)
	{
		this.name = name;
	}

	public Date getEstablishedDate()
	{
		return this.established_date;
	}

	public void setId(Date established_date)
	{
		this.established_date = established_date;
	}

	
	@Override
	public String toString() {
		return String.format("Faculty[id=%d, name='%s', established_date='%s']", id, name, established_date);
	}
}
