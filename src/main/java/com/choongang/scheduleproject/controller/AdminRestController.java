package com.choongang.scheduleproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.service.AdminService;

@RestController
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	//체크 리스트 넘겨주는 컨트롤러
	@PostMapping("/checkRegist")
	public String manageMember(@RequestBody ArrayList<CheckVO> list) { //JSON 데이터(여러개)를 리스트 형태로 받아옴
		int updateResult = adminService.checkMemberUpdate(list);
		int deleteResult = adminService.deleteMember(list);
		if(updateResult == 1) {
			return "등록 성공했습니다.";
		}
		return "등록 실패했습니다.";
	}
	
	
}
