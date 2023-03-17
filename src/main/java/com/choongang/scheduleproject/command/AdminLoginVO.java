package com.choongang.scheduleproject.command;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginVO {
	@NotNull
	@JsonProperty("admin_id")
	private String adminId;
	@NotNull
	@JsonProperty("admin_pw")
	private String adminPw;
}
