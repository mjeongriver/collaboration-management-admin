package com.choongang.scheduleproject.command;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
   private String user_id;
   private int department_id;
   private String department_name;
   private boolean user_role;
   private String user_email;
   private String user_name;
   private String user_pw;
   private String user_cell;
   private String user_birth;
   private boolean user_active;
   private String user_position;
   private int user_employeenumber;
   private Timestamp user_regdate;
   private Timestamp log_date;
}