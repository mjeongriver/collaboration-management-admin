package com.choongang.scheduleproject.command;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailVO {

	@JsonProperty("pj_num")
	private String pjNum;
	private String pjName;
	private String pjDescription;
	//private ArrayList<String> pj_member;
	//private ArrayList<String> pj_observer;
}
