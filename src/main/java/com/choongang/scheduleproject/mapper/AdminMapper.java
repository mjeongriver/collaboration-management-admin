package com.choongang.scheduleproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

@Mapper
public interface AdminMapper {
	/***
	 *
	 * @param criteria
	 * @return int
	 */
	public int getMemberCount(Criteria criteria); //유저 검색결과 숫자
	/***
	 *
	 * @param criteria
	 * @return ArrayList
	 */
	public ArrayList<UserVO> getMemberList(Criteria criteria); //유저 정보 리스트 출력
	/***
	 *
	 * @param CheckVO
	 * @return int
	 */
	public int checkMemberUpdate(CheckVO vo); //유저 정보 check 박스 값 업데이트
	/***
	 *
	 * @param CheckVO
	 * @return int
	 */
	public int deleteMember(CheckVO vo);//회원 삭제
	/***
	 *
	 * @param CheckVO
	 * @return int
	 */
	public int deleteTeamUser(CheckVO vo);//팀 - 유저 매핑테이블 회원 삭제
	/***
	 *
	 * @param criteria
	 * @return int
	 */
	public int getProjectCount(Criteria criteria); //프로젝트 검색결과 총갯수
	/***
	 *
	 * @param criteria
	 * @return ArrayList
	 */
	public ArrayList<ProjectVO> getProjectList(Criteria criteria);// 프로젝트 목록 출력
	/***
	 *
	 * @param projectCheckVO
	 * @return int
	 */
	public int updateProjectList(ProjectCheckVO projectCheckVO); //프로젝트 관리 체크박스 업데이트
	/***
	 *
	 * @param projectCheckVO
	 * @return int
	 */
	public int deleteProjectList(ProjectCheckVO projectCheckVO);//프로젝트 관리 삭제 기능
	/***
	 *
	 * @param vo
	 * @return ProjectDetailVO
	 */
	public ProjectDetailVO getProjectDetail(ProjectDetailVO vo); //프로젝트 상세내용 받아오는 것
	/***
	 *
	 * @param vo
	 * @return ArrayList
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
	 * @return ArrayList
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
	 * @return ArrayList
	 */
	public ArrayList<UserStaticVO> getMemberStatistics(int pjNum); //회원당 통계 가져오기
	/***
	 *
	 * @return ArrayList
	 */
	public ArrayList<DepartmentVO> getDepList();//부서 가져오기
	/***
	 *
	 * @param departmentId
	 * @return ArrayList
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
	public int insertMember(@Param("userId") String userId, @Param("pjNum") String pjNum);//해당 프로젝트 인원 추가
	/***
	 *
	 * @param userId
	 * @param pjNum
	 * @return int
	 */
	public int deleteTeamMember(@Param("userId") String userId, @Param("pjNum") String pjNum);//해당 프로젝트 인원 삭제
	/***
	 *
	 * @param userId
	 * @param pjNum
	 * @param isObserver
	 * @return int
	 */
	public int updateTeamMember(@Param("userId") String userId,
								@Param("pjNum") String pjNum,
								@Param("isObserver") int isObserver);//프로젝트 인원 수정
	public void testInsert(String password);

}
