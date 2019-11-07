package com.ibm;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.entity.Skill;
import com.ibm.repository.SkillRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnologyServiceApplicationTests {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Before
    public void init() {
		this.skillRepository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		Skill s1 = new Skill();
		s1.setName("ReactJs");
		s1.setToc("test123");
		s1.setPrerequites("test123");
		s1.setStatus("Active");
		s1.setCreateDate(LocalDateTime.now());
		this.skillRepository.save(s1);
		Assert.assertTrue(s1.getId() != null);
	}

}
