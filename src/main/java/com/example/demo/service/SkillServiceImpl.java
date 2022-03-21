package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Skill;
import com.example.demo.dto.EmpDto;
import com.example.demo.repository.ISkillRepository;

@Service
public class SkillServiceImpl implements ISkillService {

	@Autowired
	ISkillRepository skillRepo;
	
	@Override
	public List<Skill> getAllSkills() {
		
		return skillRepo.findAll();
	}

	@Override
	public Skill getSkillById(int skillId) {

		return skillRepo.getById(skillId);
	}

	@Override
	public Skill addSkill(Skill skill) {
		
		return skillRepo.save(skill);
	}

	@Override
	public Skill deleteSkillById(int skillId) {

		return null;
	}

	@Override
	public Skill updateSkill(Skill skill) {

		return null;
	}

	

}
