package com.cynetcore.bayoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cynetcore.bayoss.service.ReviewService;
import com.cynetcore.bayoss.vo.ReviewVo;

@Controller
@RequestMapping(value = "/review")
public class reviewController {

	//리뷰파트 전체 수정 요!! 08-30
	
	@Autowired
	private ReviewService reviewService;
	
	//리뷰 등록 폼
	@RequestMapping(value = "/reviewform", method = RequestMethod.GET)
	public String reviewform(int cmno) {
		System.out.println("reviewform");
		return "sub/reviewform";
	}
	
	//리뷰 등록 실행
	@RequestMapping(value = "/reviewinsert", method = RequestMethod.POST)
	public String reviewinsert(ReviewVo reviewVo) {
		System.out.println("reviewinsert");
		boolean result = reviewService.reviewInsert(reviewVo);
		return "redirect:/sub/review";
	}
	
	//리뷰 업데이트 실행
	@RequestMapping(value = "/reviewupdate", method = RequestMethod.POST)
	public String reviewupdate(ReviewVo reviewVo) {
		System.out.println("reviewinsert");
		boolean result = reviewService.reviewUpdate(reviewVo);
		return String.valueOf(result);
	}
	
	//리뷰 조회 - 상태조회
	@RequestMapping(value = "/reviewstatus", method = RequestMethod.GET)
	public ReviewVo reviewstatus(int cmno) {
		System.out.println("reviewinsert");
		ReviewVo reviewVo = reviewService.reviewStatus(cmno);
		return reviewVo;
	}
	
	//리뷰 삭제 - 상태변경
	@RequestMapping(value = "/reviewdelete", method = RequestMethod.GET)
	public String reviewdelete(int cmno) {
		System.out.println("reviewinsert");
		boolean result = reviewService.reviewDelete(cmno);
		return String.valueOf(result);
	}
	
	
	//리뷰 아이템별 리스트
	@RequestMapping(value = "/reviewlistbyitem", method = RequestMethod.GET)
	public List<ReviewVo> reviewlistbyitem(int ino) {
		List<ReviewVo> list = reviewService.reviewListByItem(ino);
		System.out.println("reviewlistbyitem");
		return list;
	}
	
	//리뷰 리스트
	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
	public List<ReviewVo> reviewlist(String sid) {
		List<ReviewVo> list = reviewService.reviewList(sid);
		System.out.println("reviewlist");
		return list;
	}
	
	//리뷰 전체 리스트
	@RequestMapping(value = "/reviewlisthole", method = RequestMethod.GET)
	public List<ReviewVo> reviewlisthole() {
		List<ReviewVo> list = reviewService.reviewListhole();
		System.out.println("reviewlisthole");
		return list;
	}	
	
}
