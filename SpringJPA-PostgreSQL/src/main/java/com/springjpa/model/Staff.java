
package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.springjpa.model.Faculty;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "position")
	private String position;
	
	protected Staff() {
	}

	// implement
	public Staff(String name, String address, String position, Faculty faculty) {
		this.name = name;
		this.address = address;
		this.position = position;
		this.faculty = faculty;
	}
	
	@JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private Faculty faculty;

	public Faculty getFaculty()
	{
		return this.faculty;
	}

	public void setFaculty(Faculty faculty)
	{
		this.faculty = faculty;
	}

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPosition()
	{
		return this.position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("Staff[id=%d, name='%s', position='%s']", id, name, position);
	}
}

