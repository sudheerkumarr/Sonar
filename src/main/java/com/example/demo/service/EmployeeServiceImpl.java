package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Login;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.dto.EmpInputDto;
import com.example.demo.dto.EmpOutputDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+id);
		}
//		Employee emp = empRepo.getById(id);
//		if(emp==null) {
//			throw new EmployeeNotFoundException("Employee not fouud with the id "+id);
//		}
		return opt.get();
	}

	@Override
	public Employee getEmpByName(String name) {
		
		return empRepo.findByEmpName(name);
	}

	@Override
	public EmployeeDto addEmployee(Employee employee) {
		// Convert Employee to Employee Dto
		Employee emp = empRepo.save(employee);
		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpName(emp.getEmpName());
		empDto.setContactNo(emp.getContactNo());
		
		// convert Login to LoginDto
		Login login = emp.getLogin();
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail(login.getEmail());
		loginDto.setLogin(login.isLogin());
		
		empDto.setLoginDto(loginDto);
		
		// return EmployeeDto
		return empDto;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// Check given emp is there in db or not
				
		Optional<Employee> opt = empRepo.findById(employee.getEmpId());
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+ employee.getEmpId());
		}
		return empRepo.save(employee);
		
	}

	@Override
	public Employee deleteEmpById(int id) {
		// Check given emp is there in db or not
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+id);
		}
		// delete emp
		empRepo.deleteById(id);
		return opt.get();
		
	}

	@Override
	public Employee updateEmpByName(int empId, String name) {
		// Check given emp is there in db or not
				
				Optional<Employee> opt = empRepo.findById(empId);
				if(!opt.isPresent()) {
					throw new EmployeeNotFoundException("Employee not found with the given id: "+empId);
				}
				opt.get().setEmpName(name);
				empRepo.save(opt.get());
				return opt.get();
		
	}

	@Override
	public Employee updateEmpSalary(int id, double salary) {
		
		return null;
	}

	@Override
	public EmpOutputDto addEmployeeDto(EmpInputDto empInputDto) {
		
		// Convert EmpInputDto obj to Employee obj
		Employee emp = new Employee();
		emp.setEmpName(empInputDto.getEmpName());
		emp.setContactNo(empInputDto.getContactNo());
		//create Login object
		Login login = new Login();
		login.setEmail(empInputDto.getEmail());
		login.setPassword(empInputDto.getPassword());
		
		// add login obj to emp
		emp.setLogin(login);

		// Persist emp object in db
		Employee newEmp= empRepo.save(emp);
		
		// Convert Employee obj to EmpOutputDto obj
		EmpOutputDto empOutputDto = new EmpOutputDto();
		empOutputDto.setEmpName(newEmp.getEmpName());
		empOutputDto.setContactNo(newEmp.getContactNo());
		empOutputDto.setEmail(newEmp.getLogin().getEmail());
		
		return empOutputDto;
	}

	@Override
	public Employee addSkillByEmpId(int empId, List<Skill> skills) {
		Optional<Employee> opt = empRepo.findById(empId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+ empId);
		}
		Employee emp = opt.get();
		emp.setSkills(skills);
		return empRepo.save(emp);
	}
	
//	@Override
//	public List<Employee> getAllEmpBasedOnSkillId(int skillId) {
//		return empRepo.getAllEmpBasedOnSkillId(skillId);
//	}

	@Override
	public List<EmpDto> getAllEmpBasedOnSkillId(int skillId) {
		List<Employee> employeeList = empRepo.getAllEmpBasedOnSkillId(skillId);
		
		// Convert List<Employee> to List<EmpDto>
		List<EmpDto> empDtoList = new ArrayList<>();
		
		for(Employee emp :employeeList) {
			// Create EmpDto Obj
			EmpDto empDto = new EmpDto();
			// Update EmpDto obj properties
			empDto.setEmpId(emp.getEmpId());
			empDto.setEmpName(emp.getEmpName());
			empDto.setContactNo(emp.getContactNo());
			empDto.setEmail(emp.getLogin().getEmail());
			// add empDto to empDtoList
			empDtoList.add(empDto);
		}
		// return empDtoList
		return empDtoList;
	}
}
