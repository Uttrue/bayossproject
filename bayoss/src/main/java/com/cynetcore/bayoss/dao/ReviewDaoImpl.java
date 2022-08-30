package com.cynetcore.bayoss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.ReviewVo;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.review.";
	
	@Override
	public boolean reviewInsert(ReviewVo reviewVo) {
		int count = sqlSession.insert(NAMESPACE+"reviewInsert", reviewVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean reviewUpdate(ReviewVo reviewVo) {
		int count = sqlSession.update(NAMESPACE+"reviewUpdate", reviewVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean reviewDelete(int rno) {
		int count = sqlSession.update(NAMESPACE+"reviewDelete", rno);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<ReviewVo> reviewListByItem(int ino) {
		List<ReviewVo> list = sqlSession.selectList(NAMESPACE+"reviewListByItem", ino);
		return list;
	}

	@Override
	public List<ReviewVo> reviewList(String sid) {
		List<ReviewVo> list = sqlSession.selectList(NAMESPACE+"reviewList", sid);
		return list;
	}

	@Override
	public List<ReviewVo> reviewListhole() {
		List<ReviewVo> list = sqlSession.selectList(NAMESPACE+"reviewListhole");
		return list;
	}

	@Override
	public ReviewVo reviewStatus(int rno) {
		ReviewVo reviewVo = sqlSession.selectOne(NAMESPACE+"reviewStatus", rno);
		return reviewVo;
	}

}
