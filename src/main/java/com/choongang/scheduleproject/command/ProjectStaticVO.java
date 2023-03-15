package com.choongang.scheduleproject.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectStaticVO {
	private int pj_num;
	private String pj_name;
	private boolean pj_active;
	private String pj_writer;;
	private String pj_startdate;
}
