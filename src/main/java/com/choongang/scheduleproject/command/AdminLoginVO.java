package com.choongang.scheduleproject.command;

import javax.validation.constraints.NotNull;

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
	private String admin_id;
	@NotNull
	private String admin_pw;
}
