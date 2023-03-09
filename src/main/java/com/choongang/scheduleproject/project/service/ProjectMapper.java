package com.choongang.scheduleproject.project.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;

@Mapper
public interface ProjectMapper {
	public int regist(ProjectVO vo);
	
	public List<String> getProjectMember(String pj_num);
	
	public UserVO getUserVO(String user_id);
}
