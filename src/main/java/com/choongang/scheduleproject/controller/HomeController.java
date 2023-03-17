package com.choongang.scheduleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choongang.scheduleproject.command.AdminNoticeListVO;
import com.choongang.scheduleproject.service.AdminNoticeService;
import com.choongang.scheduleproject.service.AdminService;
import com.choongang.scheduleproject.util.Criteria;
import com.choongang.scheduleproject.util.PageVO;

@Controller
@RequestMapping("/admin")
public class HomeController {

	@Autowired //dashBoard
	AdminService adminService;

	@Autowired //공지사항
	@Qualifier("adminNoticeService")
	AdminNoticeService adminNoticeService;


	@GetMapping("/")
	public String index() {
		return "admin/adminNoticeLogin";
	}

	@GetMapping("/admin-dashboard")
	public String adminDashboard(Model model , Criteria criteria) {
	    int totalMember = adminService.getMemberCount(criteria); // 회원 총 갯수
	    int totalProject = adminService.getProjectCount(criteria); // 프로젝트 총 갯수

	    PageVO memberPageVO = new PageVO(criteria, totalMember);
	    model.addAttribute("UserList", adminService.getMemberList(criteria)); // 회원 목록 데이터
	    model.addAttribute("memberPageVO", memberPageVO); // 회원 목록 페이지 정보

	    PageVO projectPageVO = new PageVO(criteria, totalProject);
	    model.addAttribute("projectList", adminService.getProjectList(criteria)); // 프로젝트 목록 데이터
	    model.addAttribute("projectPageVO", projectPageVO); // 프로젝트 목록 페이지 정보

	    return "admin/admin-dashboard";
	}

	//관리자 공지사항 게시판
	@GetMapping("/notice-tablelist")
	public String noticeTableList(Criteria cri, Model model) {

		int total = adminNoticeService.getCount(cri);
		model.addAttribute("AdminNoticeList", adminNoticeService.getList(cri)); //페이지에 넘길 데이터

		PageVO pageVO = new PageVO(cri, total); //페이징에 사용
		System.out.println(pageVO.toString());
		model.addAttribute("pageVO", pageVO);

		return "admin/notice-tablelist";
	}

	//위의 noticeTableList를 상세 조회하는 컨트롤러
	@GetMapping("/notice-content")
	public String noticeContent(@RequestParam int notice_num, Model model) {

		//클릭한 글 번호에 대한 내용을 조회
		AdminNoticeListVO adminNoticeListVO = adminNoticeService.getContent(notice_num);
		model.addAttribute("adminNoticeListVO", adminNoticeListVO);

			return "admin/notice-content";
		}

	//삭제 기능
	@PostMapping(value="/deleteform")
	public String deleteNotice(@RequestParam("notice_num") int notice_num, RedirectAttributes ra) {

		int result = adminNoticeService.deleteNotice(notice_num);
		String msg = result == 1 ? "삭제되었습니다" : "삭제에 실패했습니다";
		ra.addFlashAttribute("msg", msg);

		return "redirect:/admin/notice-tablelist";
	}



}
