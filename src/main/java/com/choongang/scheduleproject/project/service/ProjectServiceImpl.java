package com.choongang.scheduleproject.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public int regist(ProjectVO vo) {
		return projectMapper.regist(vo);
	}

	@Override
	public List<String> getProjectMember(String pj_num) {
		
		return projectMapper.getProjectMember(pj_num);
	}

	@Override
	public UserVO getUserVO(String user_id) {
		
		return projectMapper.getUserVO(user_id);
	}

}
