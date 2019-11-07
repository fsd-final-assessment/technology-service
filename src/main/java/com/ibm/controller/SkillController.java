package com.ibm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.SkillDto;
import com.ibm.service.impl.SkillServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
@RestController
public class SkillController {

	private final SkillServiceImpl skillServiceImpl;
	
	public SkillController(SkillServiceImpl skillServiceImpl) {
		this.skillServiceImpl = skillServiceImpl;
	}
	
	@PostMapping("/skill")
	public ResponseEntity<SkillDto> createSkill(@Valid @RequestBody SkillDto skillDto) throws Exception {
		log.info("createSkill:"+skillDto);
		return ResponseEntity.ok(skillServiceImpl.save(skillDto));
	}
	
	@GetMapping("/skill/list")
	public ResponseEntity<List<SkillDto>> getAll() throws Exception {
		return ResponseEntity.ok(skillServiceImpl.getAll());
	}
	
}
