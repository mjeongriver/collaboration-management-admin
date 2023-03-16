package com.choongang.scheduleproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectActiveVO;
import com.choongang.scheduleproject.command.ProjectCheckVO;
import com.choongang.scheduleproject.command.ProjectDetailMemberVO;
import com.choongang.scheduleproject.command.ProjectDetailVO;
import com.choongang.scheduleproject.command.UserActiveVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.service.AdminService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	//체크 리스트 넘겨주는 컨트롤러
	@PostMapping("/checkRegist")
	public String manageMember(@RequestBody ArrayList<CheckVO> list) { //JSON 데이터(여러개)를 리스트 형태로 받아옴
		int updateResult = adminService.checkMemberUpdate(list); //비밀번호 초기화
		int deleteResult = adminService.deleteMember(list); //회원 삭제
		if(updateResult == 1 || deleteResult == 1) {
			return "등록 성공했습니다.";
		}
		return "해당 항목에 선택해주시길 바랍니다.";
	}
	//유저 활성 비활성 유무 넘겨줌
	@PostMapping("/checkActiveRegist")
	public String checkActiveRegist(@RequestBody UserActiveVO vo) {
		int activeResult = adminService.userActiveUpdate(vo);
		if(activeResult == 1) {
			return "등록 성공";
		}
		return "등록 실패";
	}
	//프로젝트 체크박스 업데이트
	@PostMapping("/projectCheckRegist")
	public String manageProject(@RequestBody ArrayList<ProjectCheckVO> list) { //JSON데이터를 리스트 형태로 받음
		int deleteResult = adminService.deleteProjectList(list);
		if(deleteResult == 1 ) {
			return "등록 성공했습니다.";
		}
		return "해당 항목에 체크해주세요";
	}
	//프로젝트 활성/비활성 유무
	@PostMapping("/projectActiveUpdate")
	public String projectActiveUpdate(@RequestBody ProjectActiveVO vo) {
		int activeResult = adminService.projectActiveUpdate(vo);
		if(activeResult == 1) {
			return "등록 성공";
		}
		return "등록 실패";
	}
	@PostMapping("/getProjectDetail")
	public String getProjectDetail(@RequestBody ProjectDetailVO vo) { //
		ProjectDetailVO ProjectDetailData = adminService.getProjectDetail(vo);
		ArrayList<ProjectDetailMemberVO> ProjectDetailMember = adminService.getProjectDetailMember(vo);
		JsonArray team = new JsonArray(); //팀원 
		JsonArray observer = new JsonArray(); //옵저버
		JsonObject ProjectDetail = new JsonObject(); //넘겨줄 데이터 Gson의 json으로 파싱
		ProjectDetail.addProperty("projectName", ProjectDetailData.getPj_name()); //프로젝트 이름 문자열로 담아줌
		ProjectDetail.addProperty("projectDescription", ProjectDetailData.getPj_description()); //프로젝트 설명 문자열로 담아줌
		//프로젝트의 옵저버와 팀원을 구분해서 담아줌
		for(ProjectDetailMemberVO pdmVO : ProjectDetailMember ) {
			if(pdmVO.is_observer() == true) {
				observer.add(pdmVO.getUser_name());
			} else {
				team.add(pdmVO.getUser_name());				
			}
		}
		ProjectDetail.add("team", team); //배열로 담아줌
		ProjectDetail.add("observer", observer); 
		
		return ProjectDetail.toString(); //json 스트링으로 반환
	}
	
}
