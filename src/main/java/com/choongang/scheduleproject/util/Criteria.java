package com.choongang.scheduleproject.util;

import lombok.Data;

// 페이지 번호 , 데이터 갯수 클래스
@Data 
public class Criteria {
	
	private int page; //페이지번호
	private int amount; //데이터 개수
	
	private String searchType; //검색 타입
	private String search; //검색 값 
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}
	
	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	//limit 함수의 페이지 시작 부분에 들어갈 getter
	public int getPageStart() {
		return (page-1) * amount;
	}
}
