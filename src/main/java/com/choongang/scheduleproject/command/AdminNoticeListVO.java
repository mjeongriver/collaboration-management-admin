package com.choongang.scheduleproject.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminNoticeListVO {

	private int noticeNum;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegdate;
	private String noticeWriter;
	private String noticeNote;




}


