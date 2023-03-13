package com.choongang.scheduleproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.util.Criteria;

@Mapper
public interface AdminMapper {
	public int getMemberCount(Criteria criteria); //검색결과 숫자
	public ArrayList<UserVO> getMemberList(Criteria criteria); //유저 정보 리스트 출력
	public UserVO getMemeberListResult(UserVO userVO); //유저 id 확인해서 id당 리스트 출력
	public int checkMemberUpdate(CheckVO vo); //유저 정보 check 박스 값 업데이트
	public int deleteMember(CheckVO vo);//회원 삭제
	public int getProjectCount(Criteria criteria); //프로젝트 검색결과 총갯수
	public ArrayList<ProjectVO> getProjectList(Criteria criteria);// 프로젝트 목록 출력
	public ProjectVO getProjectListResult(ProjectVO projectVO); //프로젝트 num 확인해서 프로젝트당 인원수와 팀장 확인
}
