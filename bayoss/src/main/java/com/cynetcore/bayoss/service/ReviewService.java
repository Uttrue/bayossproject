package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.ReviewVo;

public interface ReviewService {
	//리뷰 입력
	public boolean reviewInsert(ReviewVo reviewVo);
	//리뷰 업데이트
	public boolean reviewUpdate(ReviewVo reviewVo);
	//리뷰 조회
	public ReviewVo reviewStatus(int rno);
	//리뷰 상태변경
	public boolean reviewDelete(int rno);
	//리뷰 아이템별 리스트
	public List<ReviewVo> reviewListByItem(int ino);
	//리뷰 셀러별 리스트
	public List<ReviewVo> reviewList(String sid);
	//리뷰 전체리스트 관리자용
	public List<ReviewVo> reviewListhole();
}
