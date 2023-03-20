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
	private int pjNum;
	private String pjName;
	private boolean pjActive;
	private String pjWriter;
	private String pjStartdate;
	private int complete;
	private int uncomplete;
	private int progress;
}
