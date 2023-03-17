package com.choongang.scheduleproject.util;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PageVO {

	private int start;
	private int end;
	private boolean prev;
	private boolean next;

	private int page;
	private int amount;
	private int total;
	private int realEnd;

	private Criteria criteria;
	private ArrayList<Integer> pageList; //화면에 반복시킬

	public static final int PAGE_COUNT = 10; //페이지네이션 개수


	public PageVO(Criteria criteria, int total) {
		this.page = criteria.getPage();
		this.amount = criteria.getAmount();
		this.total = total;
		this.criteria = criteria;

		//끝 페이지 번호
		this.end = (int)Math.ceil(this.page/(double)PAGE_COUNT) * PAGE_COUNT;
		this.start=this.end - PAGE_COUNT + 1;

		//실제 끝번호

		this.realEnd = (int)Math.ceil(this.total/(double)this.amount);
		this.end = this.end > this.realEnd ? this.realEnd:this.end;

		//이전버튼 활성화
		//start 1, 11
		this.prev = this.start > 1;

		//다음버튼 활성화
		this.next = this.realEnd > this.end;

		//화면에서 반복시킬 페이지 데이터
		this.pageList = new ArrayList<>();
		for(int i = this.start; i<=this.end; i++) {
			pageList.add(i);
		}

	}

}
