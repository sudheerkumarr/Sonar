package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.service.ISkillService;

@RestController
public class SkillController {

	@Autowired
	ISkillService skillService;
	
	@PostMapping("/skills")
	ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
		Skill newSkill = skillService.addSkill(skill);
		return new ResponseEntity<>(newSkill, HttpStatus.OK);
	}
	
	

}
