package com.choongang.scheduleproject.command;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailVO {
	
	private String pj_num;
	private String pj_name;
	private String pj_description;
	//private ArrayList<String> pj_member; 
	//private ArrayList<String> pj_observer; 
}
