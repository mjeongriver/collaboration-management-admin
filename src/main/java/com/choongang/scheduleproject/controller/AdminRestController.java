package com.choongang.scheduleproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.DepartmentVO;
import com.choongang.scheduleproject.command.ProjectActiveVO;
import com.choongang.scheduleproject.command.ProjectCheckVO;
import com.choongang.scheduleproject.command.ProjectDetailMemberVO;
import com.choongang.scheduleproject.command.ProjectDetailVO;
import com.choongang.scheduleproject.command.UserActiveVO;
import com.choongang.scheduleproject.command.UserStaticVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.service.AdminService;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
public class AdminRestController {

	@Autowired
	AdminService adminService;

	//체크 리스트 넘겨주는 컨트롤러
	@PostMapping("/check-regist")
	public String manageMember(@RequestBody ArrayList<CheckVO> list) { //JSON 데이터(여러개)를 리스트 형태로 받아옴
		int updateResult = adminService.checkMemberUpdate(list); //비밀번호 초기화
		int deleteResult = adminService.deleteMember(list); //회원 삭제
		if(updateResult == 1 || deleteResult == 1) {
			return "완료했습니다.";
		}
		return "해당 항목에 선택해주시길 바랍니다.";
	}
	//유저 활성 비활성 유무 넘겨줌
	@PostMapping("/check-active-regist")
	public String checkActiveRegist(@RequestBody UserActiveVO vo) {
		int activeResult = adminService.userActiveUpdate(vo);
		if(activeResult == 1) {
			return "등록 성공";
		}
		return "등록 실패";
	}
	//프로젝트 체크박스 업데이트
	@PostMapping("/project-check-regist")
	public String manageProject(@RequestBody ArrayList<ProjectCheckVO> list) { //JSON데이터를 리스트 형태로 받음
		int deleteResult = adminService.deleteProjectList(list);
		if(deleteResult == 1 ) {
			return "삭제 성공했습니다.";
		}
		return "해당 항목에 체크해주세요";
	}
	//프로젝트 활성/비활성 유무
	@PostMapping("/project-active-update")
	public String projectActiveUpdate(@RequestBody ProjectActiveVO vo) {
		int activeResult = adminService.projectActiveUpdate(vo);
		if(activeResult == 1) {
			return "등록 성공";
		}
		return "등록 실패";
	}
	//플젝당 상세보기 및 인원
	@PostMapping("/get-project-detail")
	public String getProjectDetail(@RequestBody ProjectDetailVO vo) { //
		ProjectDetailVO ProjectDetailData = adminService.getProjectDetail(vo);
		ArrayList<ProjectDetailMemberVO> ProjectDetailMember = adminService.getProjectDetailMember(vo);
		JsonArray team = new JsonArray(); //팀원
		JsonArray observer = new JsonArray(); //옵저버
		JsonObject ProjectDetail = new JsonObject(); //넘겨줄 데이터 Gson의 json으로 파싱
		ProjectDetail.addProperty("projectName", ProjectDetailData.getPjName()); //프로젝트 이름 문자열로 담아줌
		ProjectDetail.addProperty("projectDescription", ProjectDetailData.getPjDescription()); //프로젝트 설명 문자열로 담아줌
		//프로젝트의 옵저버와 팀원을 구분해서 담아줌
		for(ProjectDetailMemberVO pdmVO : ProjectDetailMember ) {
			if(pdmVO.isObserver() == true) {
				observer.add(pdmVO.getUserName());
			} else {
				team.add(pdmVO.getUserName());
			}
		}
		ProjectDetail.add("team", team); //배열로 담아줌
		ProjectDetail.add("observer", observer);

		return ProjectDetail.toString(); //json 스트링으로 반환
	}
	//플젝 당 팀원 통계
	@GetMapping("/get-member-statistics")
	public String getMemberStatistics(@RequestParam("pj_num") int pjNum) {
		ArrayList<UserStaticVO> memberStatistics = adminService.getMemberStatistics(pjNum); //결과값 담아주는 리스트
		JsonArray member = new JsonArray(); //팀원
		JsonArray progress = new JsonArray(); //통계
		JsonObject memberStatic = new JsonObject(); //넘겨줄 데이터 Gson의 json으로 파싱
		for(UserStaticVO vo : memberStatistics) {
			member.add(vo.getUserName()); //팀원 JSON 에 담아줌
			progress.add(vo.getProgress()); //진행률 JSON에 담아줌
		}
		memberStatic.add("member", member);
		memberStatic.add("progress", progress);
		return memberStatic.toString();
	}

	//부서 요청
	@GetMapping("/get-dlist")
	public ArrayList<DepartmentVO> getDepList (){
		return adminService.getDepList();
	}
	//부서별 팀원 요청
	@GetMapping("/get-dmlist")
	public ArrayList<UserVO> getDepMemberList(@RequestParam("department_id") int departmentId) {
		return adminService.getDepMemberList(departmentId);
	}
	//해당 프로젝트 팀원 요청
	@GetMapping("/get-team-member")
	public ArrayList<UserVO> getTeamMemberList(@RequestParam("pj_num") int pjNum) {
		return adminService.getTeamMemberList(pjNum);
	}
	//해당 프로젝트 인원 추가
	@PostMapping("/insert-member")
	public String insertMember(@RequestParam("user_id") String userId, @RequestParam("pj_num") String pjNum) {
		if(userId == "") {
			return "이미 추가된 인원입니다.";
		}
		adminService.insertMember(userId, pjNum);
		return "추가했습니다.";
	}
	//해당 프로젝트 인원 삭제
	@PostMapping("/delete-member")
	public String deleteMember(@RequestParam("user_id") String userId, @RequestParam("pj_num") String pjNum) {

		if(1==adminService.deleteTeamMember(userId, pjNum)) {
			return "삭제했습니다.";
		}
		return "삭제할 수 없습니다.";
	}
	//해당 프로젝트 인원 권한 변경
	@PostMapping("/update-team-member")
	public String updateTeamMember(@RequestParam("user_id") String userId,
									@RequestParam("pj_num") String pjNum,
									@RequestParam("is_observer") int isObserver) {
		if(1 == adminService.updateTeamMember(userId, pjNum, isObserver)) {
			return "변경했습니다";
		}

		return "변경 중 오류가 발생했습니다.";
	}
}
