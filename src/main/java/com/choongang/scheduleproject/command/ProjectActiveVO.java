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
public class ProjectActiveVO {
	@JsonProperty("pj_num")
	private int pjNum;
	@JsonProperty("pj_active")
	private boolean pjActive;
}
