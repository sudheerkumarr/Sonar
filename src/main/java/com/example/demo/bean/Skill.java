package com.example.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Skill {
	
	@Id
	@GeneratedValue
	private int id;
	private String skillName;
	
	// @ManyToMany(mappedBy="skills")
	//private List<Employee> employees;
}
