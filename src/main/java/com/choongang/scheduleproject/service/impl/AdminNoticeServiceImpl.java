package com.choongang.scheduleproject.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choongang.scheduleproject.command.AdminNoticeListVO;
import com.choongang.scheduleproject.mapper.AdminNoticeListMapper;
import com.choongang.scheduleproject.service.AdminNoticeService;
import com.choongang.scheduleproject.util.Criteria;

@Service("adminNoticeService")
public class AdminNoticeServiceImpl implements AdminNoticeService{

	@Autowired
	private AdminNoticeListMapper adminNoticeListMapper;

	@Override
	public ArrayList<AdminNoticeListVO> getList(Criteria cri) {
		return adminNoticeListMapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return adminNoticeListMapper.getTotal(cri);
	}

	@Override
	public int getCount(Criteria cri) {
		return adminNoticeListMapper.getCount(cri);
	}

	//상세보기
	@Override
	public AdminNoticeListVO getContent(int noticeNum) {
		return adminNoticeListMapper.getContent(noticeNum);
	}

	//삭제기능
	@Override
	public int deleteNotice(int noticeNum) {
		return adminNoticeListMapper.deleteNotice(noticeNum);
	}

	@Override
	public int writeNotice(AdminNoticeListVO vo) {
		return adminNoticeListMapper.writeNotice(vo);
	}

	@Override
	public int updateNotice(AdminNoticeListVO vo) {
		return adminNoticeListMapper.updateNotice(vo);
	}


}
