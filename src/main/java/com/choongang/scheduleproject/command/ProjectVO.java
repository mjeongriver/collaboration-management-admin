package com.choongang.scheduleproject.command;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectVO {

	private int pjNum;
	private String pjName;
	private boolean pjActive;
	private String pjWriter;;
	private String pjDescription;
	private String pjStartdate;
	private String pjEnddate;
	private String pjCount;
	private String userName;

}
