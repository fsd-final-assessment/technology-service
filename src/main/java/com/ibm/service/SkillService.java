package com.ibm.service;

import java.util.List;

import com.ibm.dto.SkillDto;

import javassist.NotFoundException;

public interface SkillService {
	
	public SkillDto save(SkillDto skillDto);
	
	public List<SkillDto> getAll() throws NotFoundException ;
}
