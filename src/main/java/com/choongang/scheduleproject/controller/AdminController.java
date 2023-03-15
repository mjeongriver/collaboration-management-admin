package com.choongang.scheduleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choongang.scheduleproject.service.AdminService;
import com.choongang.scheduleproject.util.Criteria;
import com.choongang.scheduleproject.util.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	//회원목록 페이지
	@GetMapping("/manageMember")
	public String manageMember(Model model , Criteria criteria) { //단순 목록은 타임리프 처리
		int total = adminService.getMemberCount(criteria);//토탈 검색 (search에 따른 검색결과 건수 변화를 위해 criteria를 매개변수로 사용)
		model.addAttribute("count", total); //검색 결과 건수
		model.addAttribute("UserList", adminService.getMemberList(criteria)); //페이지에 넘길 데이터를 모델에 담는다.
		PageVO pageVO = new PageVO(criteria,total ); //pageVO 객체에서 사용할 criteria 와 total 값 주입
		model.addAttribute("pageVO", pageVO); //넘겨줄 VO 데이터
		return "/admin/adminManageMember";
	}
	//프로젝트 관리 페이지
	@GetMapping("/manageProject")
	public String manageProject(Model model , Criteria criteria) {
		int total = adminService.getProjectCount(criteria); //프로젝트 총 갯수
		PageVO pageVO = new PageVO(criteria,total ); //페이징
		model.addAttribute("projectList", adminService.getProjectList(criteria));//화면에 보여질 프로젝트리스트 
		model.addAttribute("pageVO", pageVO);
		return "/admin/adminManageProject";
	}
	//통계 목록 페이지
	@GetMapping("/manageStatistics")
	public String manageStatistics(Model model, Criteria criteria) {
		int total = adminService.getProjectCount(criteria); //프로젝트 총 갯수
		PageVO pageVO = new PageVO(criteria,total ); //페이징
		model.addAttribute("projectStaticVO" , adminService.getProjectStatic(criteria)); //프로젝트 통계 목록 담아줌
		model.addAttribute("pageVO", pageVO); //페이징 
		
		return "/admin/adminManageStatistics";
	}
	@GetMapping("/noticeContent")
	public String noticeContent() {
		return "/admin/adminNoticeContent";
	}
	@GetMapping("/noticeModify")
	public String noticeModify() {
		return "/admin/adminNoticeModify";
	}
	@GetMapping("/noticeRegist")
	public String noticeRegist() {
		return "/admin/adminNoticeRegist";
	}
	@GetMapping("/noticeTableList")
	public String noticeTableList() {
		return "/admin/adminNoticeTableList";
	}
	
	
	
}
