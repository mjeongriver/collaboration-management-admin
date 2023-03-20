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
   private String userId;
   private int departmentId;
   private String departmentName;
   private boolean userRole;
   private String userEmail;
   private String userName;
   private String userPw;
   private String userCell;
   private String userBirth;
   private boolean userActive;
   private String userPosition;
   private int userEmployeenumber;
   private Timestamp userRegdate;
   private Timestamp logDate;
   private boolean isObserver;
   private String userMethod;
}