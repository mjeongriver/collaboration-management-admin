package com.choongang.scheduleproject.service;

import java.util.ArrayList;
import java.util.List;

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
		ArrayList<UserVO> list = new ArrayList<>(); //userVO 담아줄 리스트
		for(UserVO userVO : adminMapper.getMemberList(criteria)) {
			list.add(adminMapper.getMemeberListResult(userVO)); //VO갯수만큼 호출해서 user_id당 담아줌
		}
		//이렇게 일일히 하는 이유는 sql join시 user_log 에서 여러 기록이 있으면 user_user에서 동일한 회원 컬럼이 여러개 생성되기 때문
		return list; 
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
		ArrayList<ProjectVO> list = new ArrayList<>();//projectVO 담아줄 리스트
		for(ProjectVO projectVO: adminMapper.getProjectList(criteria)) { //가져온 projectVO 만큼 반복함
			list.add(adminMapper.getProjectListResult(projectVO)); //반복하면서 select 실행 한 후 결과값 list에 담아줌
		}
		return list; //반환
	}
	//검색 시 프로젝트 결과 총갯수
	@Override
	public int getProjectCount(Criteria criteria) {
		return adminMapper.getProjectCount(criteria);
	}
	
}
