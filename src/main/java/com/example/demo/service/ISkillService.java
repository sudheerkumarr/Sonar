package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Skill;


public interface ISkillService {
	
	List<Skill> getAllSkills();
	Skill getSkillById(int skillId);
	Skill addSkill(Skill skill);
	Skill deleteSkillById(int skillId);
	Skill updateSkill(Skill skill);
	

}
