package com.ibm.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ibm.dto.SkillDto;
import com.ibm.entity.Skill;
import com.ibm.repository.SkillRepository;
import com.ibm.service.SkillService;

import javassist.NotFoundException;

@Service
public class SkillServiceImpl implements SkillService{
	
	private final SkillRepository skillRepository;
	
	private final ModelMapper modelMapper;
	
	public SkillServiceImpl(SkillRepository skillRepository,ModelMapper modelMapper) {
		this.skillRepository = skillRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public SkillDto save(SkillDto skillDto) {
		Skill skill = modelMapper.map(skillDto, Skill.class);
		skillRepository.save(skill);
		skillDto.setId(skill.getId());
		return skillDto;
	}
	@Override
	public List<SkillDto> getAll() throws NotFoundException {
		List<Skill> skills = skillRepository.findAll(); 
		if (skills.size() < 1) {
			throw new NotFoundException("Author don't already exist");
		}
		SkillDto[] authorDtos = modelMapper.map(skills, SkillDto[].class);

		return Arrays.asList(authorDtos);
	}

}
