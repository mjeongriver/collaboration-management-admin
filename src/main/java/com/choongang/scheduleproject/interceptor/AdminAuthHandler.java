package com.choongang.scheduleproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminAuthHandler implements HandlerInterceptor{
	/*
	 *  1. HandlerInterceptor를 implements 받습니다.
	 *   postHandler - 컨트롤러 수행 후에 실행
	 *   preHandler - 컨트롤러 수행 전에 실행
	 *   aftercompletion - 화면으로 가기 직전에 수행
	 *
	 *  2. 인터셉터 클래스를 bean으로 등록
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String admin_id = (String)request.getSession().getAttribute("admin_id"); //세션에 있는 admin 값 받아옴
		if(admin_id == null) { //세션 없을 때
			response.sendRedirect(request.getContextPath() + "/"); //로그인 페이지 리디렉션
			return false; //컨트롤러 실행 x
		}
		return true; //컨트롤러 실행 o
	}

}
