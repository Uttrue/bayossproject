package com.cynetcore.bayoss.comment;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.CommentDao;
import com.cynetcore.bayoss.vo.CommentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestComment {
	
	@Autowired
	private CommentDao commentDao;
	
	//코멘트 등록
	@Test
	public void testCommentInsert() {
		CommentVo commentVo = new CommentVo("test01", 252, "test01", "좋음", "마리콤2장");
		boolean result = commentDao.commentInsert(commentVo);
		System.out.println("testCommentInsert, result : " + result);
	}
	
	@Test
	public void testcommentUpdate() {
		CommentVo commentVo = new CommentVo("test01", 252, "test01", "좋음수정", "마리콤2장");
		boolean result = commentDao.commentUpdate(commentVo);
		System.out.println("testcommentUpdate, result : " + result);
	}
	
	@Test
	public void testcommentDelete() {
		int cmno = 1;
		boolean result = commentDao.commentDelete(cmno);
		System.out.println("testcommentDelete, result : " + result);
	}
	
	@Test
	public void testcommentListByItem() {
		int ino = 252;
		List<CommentVo> List = commentDao.commentListByItem(ino);
		System.out.println("testcommentListByItem : " + List);
	}
	
	@Test
	public void testcommentList() {
		String sid = "test01";
		List<CommentVo> List = commentDao.commentList(sid);
		System.out.println("testcommentList : " + List);
	}
	//셀러 스토어 전체 리스트
	@Test
	public void testcommentListhole() {
		List<CommentVo> List = commentDao.commentListhole();
		System.out.println("testcommentListhole : " + List);
	}
	
}
