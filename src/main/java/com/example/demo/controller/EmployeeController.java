package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.dto.EmpInputDto;
import com.example.demo.dto.EmpOutputDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService empServ;
		
	// get all employees
	@GetMapping("/employees")
	List<Employee> getAllEmployees() {
		return empServ.getAllEmployees();
	}
	
	// get emp based on id
	@GetMapping("/employees/{id}")
	Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmpById(empId);
		
	}
	
	// add emp
	@PostMapping("/employees")
	ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee emp) {
		EmployeeDto newEmp =  empServ.addEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	// add emp
	@PostMapping("/employees/dto")
	ResponseEntity<EmpOutputDto> addEmployeeDto(@Valid @RequestBody EmpInputDto emp) {
		EmpOutputDto newEmp =  empServ.addEmployeeDto(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	// Add skill
	@PostMapping("/employees/{empId}")
	ResponseEntity<Employee> addSkillByEmpId(@PathVariable("empId") int empId, @RequestBody List<Skill> skills) {
		Employee newEmp =  empServ.addSkillByEmpId(empId, skills);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	// delete employee
	@DeleteMapping("/employees/{id}")
	ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
		Employee deletedEmp = empServ.deleteEmpById(id);
		return new ResponseEntity<>(deletedEmp, HttpStatus.OK); // 200 Ok
	}
	
	// update employee
	@PutMapping("/employees")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updatedEmp = empServ.updateEmployee(emp);
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK); // 200 Ok
	}
	// update emp name
	@PatchMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmpName(@PathVariable("id") int empId, @RequestBody String name) {
		Employee emp = empServ.updateEmpByName(empId, name);
		return new ResponseEntity<>(emp, HttpStatus.OK); // 200 Ok
		
	}
	// update emp salary
	
	// get emp based on name
	@GetMapping("/employees/byName/{name}")
	ResponseEntity<Employee> getEmpByName(@PathVariable("name") String empName) {
		Employee emp = empServ.getEmpByName(empName);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/skills/{skillId}")
	ResponseEntity<List<EmpDto>> getAllEmpBasedOnSkillId(@PathVariable("skillId") int skillId) {
		List<EmpDto> employees = empServ.getAllEmpBasedOnSkillId(skillId);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
