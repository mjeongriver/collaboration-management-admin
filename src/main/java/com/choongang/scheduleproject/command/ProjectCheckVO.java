package com.choongang.scheduleproject.command;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCheckVO {
	@JsonProperty("pj_num")
	private int pjNum;
	@JsonProperty("pj_delete")
	private boolean pjDelete;
}
