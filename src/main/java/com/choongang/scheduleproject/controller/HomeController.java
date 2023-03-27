package com.choongang.scheduleproject.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {

	@GetMapping("/")
	public String index(HttpSession session, RedirectAttributes ra) {
		//세션값을 기반으로 DB에서 정보 조회
		String adminId = (String)session.getAttribute("admin_id");
		if(adminId != null) {
			ra.addFlashAttribute("msg", "이미 로그인되어 있습니다.");
			return "redirect:/admin/admin-dashboard";
		}
		return "admin/admin-login";

	}

}
