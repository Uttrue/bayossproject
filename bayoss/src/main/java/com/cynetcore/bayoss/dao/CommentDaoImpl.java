package com.cynetcore.bayoss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.comment.";
	
	//코멘트 입력
	@Override
	public boolean commentInsert(CommentVo commentVo) {
		int count = sqlSession.insert(NAMESPACE+"commentInsert", commentVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//코멘트 업데이트
	@Override
	public boolean commentUpdate(CommentVo commentVo) {
		int count = sqlSession.update(NAMESPACE+"commentUpdate", commentVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//코멘트 삭제 -업데이트
	@Override
	public boolean commentDelete(int cmno) {
		int count = sqlSession.update(NAMESPACE+"commentDelete", cmno);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<CommentVo> commentListByItem(int ino) {
		List<CommentVo> list = sqlSession.selectList(NAMESPACE+"commentListByItem", ino);
		return list;
	}

	@Override
	public List<CommentVo> commentList(String sid) {
		List<CommentVo> list = sqlSession.selectList(NAMESPACE+"commentList", sid);
		return list;
	}

	@Override
	public List<CommentVo> commentListhole() {
		List<CommentVo> list = sqlSession.selectList(NAMESPACE+"commentListhole");
		return list;
	}

	@Override
	public CommentVo commentStatus(int cmno) {
		CommentVo commentVo = sqlSession.selectOne(NAMESPACE+"reviewStatus", cmno);
		return commentVo;
	}

}
