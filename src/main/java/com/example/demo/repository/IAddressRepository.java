package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer>{
	@Query(value= "select * from address join employee on address.emp_id=employee.emp_id where employee.emp_id=:eId", nativeQuery = true)
	List<Address> getAllAddressesById(@Param("eId") int id);

}
