package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Login;
import com.example.demo.dto.EmpInputDto;
import com.example.demo.dto.EmpOutputDto;
import com.example.demo.repository.IEmployeeRepository;

@ExtendWith(SpringExtension.class)
class EmployeeServiceMockitoTest {

	// @InjectMock - Creates instance of a class and injects mocks that are created
	// with @Mock

		@InjectMocks
		EmployeeServiceImpl empService;

		// @MockBean - Creates Mock of a class or interface

		@MockBean
		IEmployeeRepository empRepo;

		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
		@Test
		void getEmpByIdTest() {
			// Employee emp = empService.getEmpById(37);
			Employee employee = new Employee(37, "Raj", "9999955555");
			Mockito.when(empRepo.findById(37)).thenReturn(Optional.of(employee));
			Employee emp = empService.getEmpById(37);
			assertEquals(37, emp.getEmpId());
			assertEquals("Raj", emp.getEmpName());
			assertEquals("9999955555", emp.getContactNo());
			
		}
		
		@Test
		void addEmployeeDtoTest() {
			//EmpOutputDto addEmployeeDto(EmpInputDto empInputDto)
			EmpInputDto empInputDto = new EmpInputDto("Ramesh", "ramesh@gmail.com", "abc@1323", "9999911111");
			
			Employee emp = new Employee();
			
			emp.setEmpName(empInputDto.getEmpName());
			emp.setContactNo(empInputDto.getContactNo());
			Login login = new Login();
			login.setEmail(empInputDto.getEmail());
			login.setPassword(empInputDto.getPassword());
			emp.setLogin(login);
			
			Mockito.when(empRepo.save(emp)).thenReturn(emp);
					
			EmpOutputDto empOutDto= empService.addEmployeeDto(empInputDto);
			
			assertEquals("Ramesh", empOutDto.getEmpName());
			assertEquals("9999911111", empOutDto.getContactNo());
			assertEquals("ramesh@gmail.com", empOutDto.getEmail());
		}
		
		
		
}
