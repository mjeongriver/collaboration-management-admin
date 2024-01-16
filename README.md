# 📆 Collaboration Management(admin) Project 

<img src="https://user-images.githubusercontent.com/116552282/232581103-2c929819-e577-46b4-b53d-a27d39dad65a.png">

> 관리자 페이지에서는 사용자 사이트 내부의 정보들을 관리할 수 있습니다.
<br/>

### 레퍼런스
---
<img src="https://user-images.githubusercontent.com/116552282/232567464-1bcba549-d4fb-4bb1-9724-ce3fbd5ade9f.png">

> 현재 일정관리 툴로 사용되고 있는 flow, slack 등을 참고하여 기능 및 UI를 설계 하였습니다.
<br/>

### 바로가기
---
1. [제작 기간 & 참여 인원](#1-제작-기간--참여-인원)
2. [사용 기술](#2-사용-기술)
3. [배포 주소](#3-배포-주소-바로가기)
4. [기능 소개](#4-기능-소개)
<br/>

### 1. 제작 기간 & 참여 인원
---
- 2023-02-28 ~ 2023-03-28(1개월)
- 팀원: 강민정, 권도은, 이승완, 이세민, 이동민
<br/>

### 2. 사용 기술
---
- BACK: JAVA(JDK 11), SpringBoot(2.7.9), springSecurity
- FRONT: HTML5, CSS, javascript(ES5), thymeleaf
- DB: MySQL(8.0)
- IDE: Eclipse(2022-09), HeidiSQL
- API, LIBRARY: SummerNote API, Lombok(1.18), myBatis(2.3), jquery(1.12), BootStrap3
<br/>

### 3. [배포 주소 바로가기](http://13.124.250.123:8787)
---
```
 페이지 계정: admin / password
```


### 4. 기능 소개
---
- **main**
  - 모든 목록을 간략하게 볼 수 있음
  <br/>
- **회원관리 목록**
  - 회원의 마지막 로그인 기록, 비밀번호 초기화, 회원 삭제, 활성 및 비활성화 가능
  <br/>
- **프로젝트 관리**
  - 각 프로젝트 상세 보기 가능
  - 각 프로젝트당 팀원 수정 가능
  - 프로젝트 활성화 여부 변경 가능
  - 프로젝트 삭제
  <br/>
- **통계**
  - 실시간으로 프로젝트의 전체 진척률과 통계 상세보기 가능
  - 해당 프로젝트에 속한 팀원의 진척률 확인 가능
  <br/>
- **관리자 공지사항**
  - 글 목록: 페이지네이션, 검색, n개씩 보기
  - 게시글 등록, 수정, 삭제
  - summernote를 활용하여 관리자가 커스터마이징하여 글 작성 가능
  <br/>
