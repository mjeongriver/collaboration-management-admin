package com.choongang.scheduleproject.service;

import java.util.ArrayList;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.util.Criteria;


public interface AdminService {
	public int getMemberCount(Criteria criteria); //검색결과 건수
	public ArrayList<UserVO> getMemberList(Criteria criteria); //유저 정보 리스트 출력
	public int checkMemberUpdate(ArrayList<CheckVO> list); //유저 정보 check 박스 값 업데이트
	public int deleteMember(ArrayList<CheckVO> list);//회원 삭제
	public int getProjectCount(Criteria criteria); //프로젝트 검색결과 총갯수
	public ArrayList<ProjectVO> getProjectList(Criteria criteria);// 프로젝트 목록 출력
}
