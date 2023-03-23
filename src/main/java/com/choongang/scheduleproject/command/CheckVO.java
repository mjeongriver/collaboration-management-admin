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
public class CheckVO {
	@JsonProperty("user_id")
	private String userId;
	private String pwReset;
	private String memberDelete;
	private String password;
}
