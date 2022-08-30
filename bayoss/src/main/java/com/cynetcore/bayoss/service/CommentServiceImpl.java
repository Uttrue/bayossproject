package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.CommentDao;
import com.cynetcore.bayoss.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public boolean commentInsert(CommentVo commentVo) {
		boolean result = commentDao.commentInsert(commentVo);
		return result;
	}

	@Override
	public boolean commentUpdate(CommentVo commentVo) {
		boolean result = commentDao.commentUpdate(commentVo);
		return result;
	}

	@Override
	public boolean commentDelete(int cmno) {
		boolean result = commentDao.commentDelete(cmno);
		return result;
	}

	@Override
	public List<CommentVo> commentListByItem(int ino) {
		List<CommentVo> list = commentDao.commentListByItem(ino);
		return list;
	}

	@Override
	public List<CommentVo> commentList(String sid) {
		List<CommentVo> list = commentDao.commentList(sid);
		return list;
	}

	@Override
	public List<CommentVo> commentListhole() {
		List<CommentVo> list = commentDao.commentListhole();
		return list;
	}

	@Override
	public CommentVo commentStatus(int cmno) {
		CommentVo commentVo = commentDao.commentStatus(cmno);
		return commentVo;
	}

}
