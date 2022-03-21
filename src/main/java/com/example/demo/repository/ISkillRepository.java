package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
	
}
