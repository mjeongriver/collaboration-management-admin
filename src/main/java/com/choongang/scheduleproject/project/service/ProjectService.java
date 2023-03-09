package com.choongang.scheduleproject.project.service;

import java.util.List;

import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;

public interface ProjectService {
	
	public int regist(ProjectVO vo);
	
	public List<String> getProjectMember(String pj_num);
	
	public UserVO getUserVO(String user_id);
	
}
