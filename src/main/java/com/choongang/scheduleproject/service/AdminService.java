package com.choongang.scheduleproject.service;

import java.util.ArrayList;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectActiveVO;
import com.choongang.scheduleproject.command.ProjectCheckVO;
import com.choongang.scheduleproject.command.ProjectDetailMemberVO;
import com.choongang.scheduleproject.command.ProjectDetailVO;
import com.choongang.scheduleproject.command.ProjectStaticVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserActiveVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.util.Criteria;


public interface AdminService {
	public int getMemberCount(Criteria criteria); //검색결과 건수
	public ArrayList<UserVO> getMemberList(Criteria criteria); //유저 정보 리스트 출력
	public int checkMemberUpdate(ArrayList<CheckVO> list); //유저 정보 check 박스 값 업데이트
	public int deleteMember(ArrayList<CheckVO> list);//회원 삭제
	public int getProjectCount(Criteria criteria); //프로젝트 검색결과 총갯수
	public ArrayList<ProjectVO> getProjectList(Criteria criteria);// 프로젝트 목록 출력
	public int deleteProjectList(ArrayList<ProjectCheckVO> list);//프로젝트 관리 삭제 기능
	public ProjectDetailVO getProjectDetail(ProjectDetailVO vo); //프로젝트 상세내용 받아오는 것
	public ArrayList<ProjectDetailMemberVO> getProjectDetailMember(ProjectDetailVO vo);//프로젝트에저장된 pj_num을 이용해서 해당 프로젝트 인원 가져오기
	public int userActiveUpdate(UserActiveVO vo);//유저 활성/ 비활성 기능
	public int projectActiveUpdate(ProjectActiveVO vo); //프로젝트 활성/ 비활성 기능
	public ArrayList<ProjectStaticVO> getProjectStatic(Criteria criteria); //프로젝트 통계목록 불러오기
	
	
}
