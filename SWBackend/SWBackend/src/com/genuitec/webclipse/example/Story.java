package com.genuitec.webclipse.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
@XmlRootElement
@Entity
@Table(name = "Story", schema = "STARWARS")
public class Story implements java.io.Serializable {
	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer hours;
	
	private Integer personId;

	// Constructors

	/** default constructor */
	public Story() {
	}

	/** minimal constructor */
	public Story(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Story(Integer id, String name,
			String gender, String skincolor, String haircolor,
			String eyecolor, String birthyear,
			Integer height, Integer mass) {
		this.id = id;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "ID")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Column(name="hours", columnDefinition="DEFAULT 0")
	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	@Column(name="personId")
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

}