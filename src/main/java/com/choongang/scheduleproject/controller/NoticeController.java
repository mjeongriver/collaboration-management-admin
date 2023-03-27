package com.choongang.scheduleproject.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choongang.scheduleproject.command.AdminNoticeListVO;
import com.choongang.scheduleproject.command.ProjectStaticVO;
import com.choongang.scheduleproject.service.AdminNoticeService;
import com.choongang.scheduleproject.service.AdminService;
import com.choongang.scheduleproject.util.Criteria;
import com.choongang.scheduleproject.util.PageVO;

@Controller
@RequestMapping("/admin")
public class NoticeController {

	@Autowired //dashBoard
	AdminService adminService;

	@Autowired //공지사항
	@Qualifier("adminNoticeService")
	AdminNoticeService adminNoticeService;


	@GetMapping("/board-content")
	public String boardContent() {
		return "admin/board-content";
	}

	@GetMapping("/board-write")
	public String boardWrite() {
	    return "admin/board-write";
	}

	//수정
	@GetMapping("/board-modify")
	public String boardModify(@RequestParam("notice_num") int noticeNum, Model model) {

		AdminNoticeListVO vo = adminNoticeService.getContent(noticeNum);
		model.addAttribute("vo", vo);

		return "admin/board-modify";
	}

	//대시보드
	@GetMapping("/admin-dashboard")
	public String adminDashboard(Model model, Criteria criteria) {
		criteria.setAmount(5);
	    int totalMember = adminService.getMemberCount(criteria); // 회원 총 갯수
	    int totalProject = adminService.getProjectCount(criteria); // 프로젝트 총 갯수

	    PageVO memberPageVO = new PageVO(criteria, totalMember);
	    model.addAttribute("UserList", adminService.getMemberList(criteria)); // 회원 목록 데이터
	    model.addAttribute("memberPageVO", memberPageVO); // 회원 목록 페이지 정보

	    PageVO projectPageVO = new PageVO(criteria, totalProject);
	    model.addAttribute("projectList", adminService.getProjectList(criteria)); // 프로젝트 목록 데이터
	    model.addAttribute("projectPageVO", projectPageVO); // 프로젝트 목록 페이지 정보

	    ArrayList<ProjectStaticVO> projectStaticList = adminService.getProjectStatic(criteria); // 프로젝트 통계 데이터
	    PageVO projectStaticVO = new PageVO(criteria, projectStaticList.size());
	    model.addAttribute("projectStaticList", projectStaticList);
	    model.addAttribute("projectStaticVO", projectStaticVO);

	    ArrayList<AdminNoticeListVO> noticeList = adminNoticeService.getList(criteria); // 공지사항 목록 데이터
	    PageVO noticePageVO = new PageVO(criteria, noticeList.size());
	    model.addAttribute("noticeList", noticeList);
	    model.addAttribute("noticePageVO", noticePageVO);

	    return "admin/admin-dashboard";
	}


	//관리자 공지사항 게시판
	@GetMapping("/notice-tablelist")
	public String noticeTableList(Criteria cri, Model model) {

		int total = adminNoticeService.getCount(cri);
		model.addAttribute("AdminNoticeList", adminNoticeService.getList(cri)); //페이지에 넘길 데이터

		PageVO pageVO = new PageVO(cri, total); //페이징에 사용
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
	@PostMapping(value="/delete-form")
	public String deleteNotice(@RequestParam("noticeNum") int noticeNum, RedirectAttributes ra) {

		int result = adminNoticeService.deleteNotice(noticeNum);
		String msg = result == 1 ? "삭제되었습니다" : "삭제에 실패했습니다";
		ra.addFlashAttribute("msg", msg);

		return "redirect:/admin/notice-tablelist"; //목록으로
	}

	//등록기능
	@PostMapping("/write-form")
	public String writeForm(@ModelAttribute AdminNoticeListVO vo, RedirectAttributes ra) {

	    int result = adminNoticeService.writeNotice(vo);
	    String msg = result == 1 ? "공지사항이 정상 등록되었습니다" : "공지사항 등록에 실패했습니다.";

	    ra.addFlashAttribute("msg", msg);

	    return "redirect:/admin/notice-tablelist"; // 목록으로
	}

	//수정기능
	@PostMapping("/modify-form")
	public String modifyForm(@ModelAttribute AdminNoticeListVO vo, RedirectAttributes ra) {

		int result = adminNoticeService.updateNotice(vo);
		String msg = result == 1 ? "공지사항이 수정되었습니다" : "공지사항 수정에 실패했습니다.";
	    ra.addFlashAttribute("msg", msg);

		return "redirect:/admin/notice-tablelist"; //목록으로
	}














}
