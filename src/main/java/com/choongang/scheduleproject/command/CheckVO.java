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
public class CheckVO {
	private String user_id;
	private String pwReset;
	private String memberDelete;
	private boolean user_active;
}
