package com.choongang.scheduleproject.service;

import java.util.ArrayList;

import com.choongang.scheduleproject.command.AdminLoginVO;
import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.DepartmentVO;
import com.choongang.scheduleproject.command.ProjectActiveVO;
import com.choongang.scheduleproject.command.ProjectCheckVO;
import com.choongang.scheduleproject.command.ProjectDetailMemberVO;
import com.choongang.scheduleproject.command.ProjectDetailVO;
import com.choongang.scheduleproject.command.ProjectStaticVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserActiveVO;
import com.choongang.scheduleproject.command.UserStaticVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.util.Criteria;


public interface AdminService {
	/***
	 *
	 * @param criteria
	 * @return int
	 */
	public int getMemberCount(Criteria criteria); //검색결과 건수
	/***
	 *
	 * @param criteria
	 * @return UserVO
	 */
	public ArrayList<UserVO> getMemberList(Criteria criteria); //유저 정보 리스트 출력
	/***
	 *
	 * @param list
	 * @return int
	 */
	public int checkMemberUpdate(ArrayList<CheckVO> list); //유저 정보 check 박스 값 업데이트
	/***
	 *
	 * @param list
	 * @return int
	 */
	public int deleteMember(ArrayList<CheckVO> list);//회원 삭제
	/***
	 *
	 * @param criteria
	 * @return int
	 */
	public int getProjectCount(Criteria criteria); //프로젝트 검색결과 총갯수
	/***
	 *
	 * @param criteria
	 * @return ProjectVO
	 */
	public ArrayList<ProjectVO> getProjectList(Criteria criteria);// 프로젝트 목록 출력
	/***
	 *
	 * @param list
	 * @return int
	 */
	public int deleteProjectList(ArrayList<ProjectCheckVO> list);//프로젝트 관리 삭제 기능
	/***
	 *
	 * @param vo
	 * @return ProjectDetailVO
	 */
	public ProjectDetailVO getProjectDetail(ProjectDetailVO vo); //프로젝트 상세내용 받아오는 것
	/***
	 *
	 * @param vo
	 * @return ProjectDetailMemberVO
	 */
	public ArrayList<ProjectDetailMemberVO> getProjectDetailMember(ProjectDetailVO vo);//프로젝트에저장된 pj_num을 이용해서 해당 프로젝트 인원 가져오기
	/***
	 *
	 * @param vo
	 * @return int
	 */
	public int userActiveUpdate(UserActiveVO vo);//유저 활성/ 비활성 기능
	/***
	 *
	 * @param vo
	 * @return int
	 */
	public int projectActiveUpdate(ProjectActiveVO vo); //프로젝트 활성/ 비활성 기능
	/***
	 *
	 * @param criteria
	 * @return ProjectStaticVO
	 */
	public ArrayList<ProjectStaticVO> getProjectStatic(Criteria criteria); //프로젝트 통계목록 불러오기
	/***
	 *
	 * @param vo
	 * @return AdminLoginVO
	 */
	public AdminLoginVO getLoginVO(AdminLoginVO vo); //로그인 정보 가져오기
	/***
	 *
	 * @param pjNum
	 * @return UserStaticVOt
	 */
	public ArrayList<UserStaticVO> getMemberStatistics(int pjNum); //회원당 통계 가져오기
	/***
	 *
	 * @return DepartmentVO
	 */
	public ArrayList<DepartmentVO> getDepList();//부서 가져오기
	/***
	 *
	 * @param departmentId
	 * @return UserVO
	 */
	public ArrayList<UserVO> getDepMemberList(int departmentId); //해당 부서의 인원 가져오기
	/***
	 *
	 * @param pjNum
	 * @return UserVO
	 */
	public ArrayList<UserVO> getTeamMemberList(int pjNum);//프로젝트당 해당 팀원 가져오기
	/***
	 *
	 * @param userId
	 * @param pjNum
	 * @return int
	 */
	public int insertMember(String userId, String pjNum);//해당 프로젝트 인원 추가
	/***
	 *
	 * @param userId
	 * @param pjNum
	 * @return int
	 */
	public int deleteTeamMember(String userId, String pjNum);//해당 프로젝트 인원 삭제
	/***
	 *
	 * @param userId
	 * @param pjNum
	 * @param isObserver
	 * @return int
	 */
	public int updateTeamMember(String userId, String pjNum, int isObserver); //프로젝트 인원 옵저버 수정
}
