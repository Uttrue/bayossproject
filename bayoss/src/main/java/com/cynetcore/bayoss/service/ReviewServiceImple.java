package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.ReviewDao;
import com.cynetcore.bayoss.vo.ReviewVo;

@Service
public class ReviewServiceImple implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public boolean reviewInsert(ReviewVo reviewVo) {
		boolean result = reviewDao.reviewInsert(reviewVo);
		return result;
	}

	@Override
	public boolean reviewUpdate(ReviewVo reviewVo) {
		boolean result = reviewDao.reviewUpdate(reviewVo);
		return result;
	}

	@Override
	public ReviewVo reviewStatus(int rno) {
		ReviewVo reviewVo = reviewDao.reviewStatus(rno);
		return reviewVo;
	}

	@Override
	public boolean reviewDelete(int rno) {
		boolean result = reviewDao.reviewDelete(rno);
		return result;
	}

	@Override
	public List<ReviewVo> reviewListByItem(int ino) {
		List<ReviewVo> list = reviewDao.reviewListByItem(ino);
		return list;
	}

	@Override
	public List<ReviewVo> reviewList(String sid) {
		List<ReviewVo> list = reviewDao.reviewList(sid);
		return list;
	}

	@Override
	public List<ReviewVo> reviewListhole() {
		List<ReviewVo> list = reviewDao.reviewListhole();
		return list;
	}

}
