package com.choongang.scheduleproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.mapper.AdminMapper;
import com.choongang.scheduleproject.util.Criteria;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	// 회원 목록
	@Override
	public ArrayList<UserVO> getMemberList(Criteria criteria) {
		return adminMapper.getMemberList(criteria); 
	}
	//총 회원 수
	@Override
	public int getMemberCount(Criteria criteria) {
		return adminMapper.getMemberCount(criteria);
	}
	//회원 체크박스 업데이트
	@Override
	public int checkMemberUpdate(ArrayList<CheckVO> list) {
		int result=0; //결과값 반환
		for(CheckVO vo : list) {
			result = adminMapper.checkMemberUpdate(vo);
		}//리스트에 담긴 VO 객체 매퍼에 담아서 처리
		return result;
	}
	//회원 삭제
	@Override
	public int deleteMember(ArrayList<CheckVO> list) {
		int result=0; //결과값 반환
		for(CheckVO vo : list) {
			if(vo.getMemberDelete().equals("on")) {
				result = adminMapper.deleteMember(vo);
			}
		}//리스트에 담긴 VO 객체 매퍼에 담아서 처리
		return result;
	}
	//프로젝트 목록 출력
	@Override
	public ArrayList<ProjectVO> getProjectList(Criteria criteria) {
		return adminMapper.getProjectList(criteria);
	}
	//검색 시 프로젝트 결과 총갯수
	@Override
	public int getProjectCount(Criteria criteria) {
		return adminMapper.getProjectCount(criteria);
	}
	
}
