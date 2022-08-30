package com.cynetcore.bayoss.review;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.ReviewDao;
import com.cynetcore.bayoss.vo.ReviewVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestReview {
	
	@Autowired
	private ReviewDao reviewDao;
	
	//코멘트 등록
	@Test
	public void testreviewInsert() {
		ReviewVo reviewVo = new ReviewVo("test01", 252, "test01", "좋음", "마리콤2장");
		boolean result = reviewDao.reviewInsert(reviewVo);
		System.out.println("testreviewInsert, result : " + result);
	}
	
	@Test
	public void testreviewUpdate() {
		ReviewVo reviewVo = new ReviewVo("test01", 252, "test01", "좋음수정", "마리콤2장");
		boolean result = reviewDao.reviewUpdate(reviewVo);
		System.out.println("testreviewUpdate, result : " + result);
	}
	
	@Test
	public void testreviewDelete() {
		int cmno = 1;
		boolean result = reviewDao.reviewDelete(cmno);
		System.out.println("testreviewDelete, result : " + result);
	}
	
	@Test
	public void testreviewListByItem() {
		int ino = 252;
		List<ReviewVo> List = reviewDao.reviewListByItem(ino);
		System.out.println("testreviewListByItem : " + List);
	}
	
	@Test
	public void testreviewList() {
		String sid = "test01";
		List<ReviewVo> List = reviewDao.reviewList(sid);
		System.out.println("testreviewList : " + List);
	}
	//셀러 스토어 전체 리스트
	@Test
	public void testreviewListhole() {
		List<ReviewVo> List = reviewDao.reviewListhole();
		System.out.println("testreviewListhole : " + List);
	}
	
}
