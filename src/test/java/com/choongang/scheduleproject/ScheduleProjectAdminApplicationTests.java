package com.choongang.scheduleproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.choongang.scheduleproject.mapper.AdminMapper;

@SpringBootTest
class ScheduleProjectAdminApplicationTests {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AdminMapper adminMapper;

//	@Test
//	void contextLoads() {
//		String password=passwordEncoder.encode("password");
//		adminMapper.testInsert(password);
//	}

}
