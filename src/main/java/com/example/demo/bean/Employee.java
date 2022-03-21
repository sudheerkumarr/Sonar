package com.example.demo.bean;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
public class Employee {
	
	// Fields
	@Id
	@GeneratedValue
	private int empId;
	
	
	public Employee(int empId, String empName, String contactNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.contactNo = contactNo;
	}


	//@Getter
	//@Setter
	@NotNull(message="Name shouldn't be empty")
	@Size(min=3, max=50, message="Min 3 characters required")
	private String empName;
	//@Length(min=10, max=10)
	private String contactNo;
	private  double salary; //0.0
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empId")
	private List<Address> address;// null
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
		name = "employee_skill", 
		joinColumns = { @JoinColumn(name = "emp_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "skill_id") }
	)
	private List<Skill> skills;//null
	
	// Constructors
	//Getters &Setters
	
	

}
