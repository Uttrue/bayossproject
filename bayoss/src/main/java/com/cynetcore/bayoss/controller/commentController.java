package com.cynetcore.bayoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cynetcore.bayoss.service.CommentService;
import com.cynetcore.bayoss.vo.CommentVo;

@Controller
@RequestMapping(value = "/comment")
public class commentController {

	@Autowired
	private CommentService commentService;
	
	//코멘트 등록 실행
	@RequestMapping(value = "/commentinsert", method = RequestMethod.POST)
	@ResponseBody
	public String commentinsert(CommentVo commentVo) {
		System.out.println("commentinsert");
		boolean result = commentService.commentInsert(commentVo);
		return String.valueOf(result);
	}
	
	//코멘트 업데이트 실행
	@RequestMapping(value = "/commentupdate", method = RequestMethod.POST)
	@ResponseBody
	public String commentupdate(CommentVo commentVo) {
		System.out.println("commentinsert");
		boolean result = commentService.commentUpdate(commentVo);
		return String.valueOf(result);
	}
	
	//코멘트 조회 - 상태조회
	@RequestMapping(value = "/commentstatus", method = RequestMethod.GET)
	@ResponseBody
	public CommentVo commentstatus(int cmno) {
		System.out.println("commentinsert");
		CommentVo commentVo = commentService.commentStatus(cmno);
		return commentVo;
	}
	
	//코멘트 삭제 - 상태변경
	@RequestMapping(value = "/commentdelete", method = RequestMethod.GET)
	@ResponseBody
	public String commentdelete(int cmno) {
		System.out.println("commentinsert");
		boolean result = commentService.commentDelete(cmno);
		return String.valueOf(result);
	}
	
	
	//코멘트 아이템별 리스트
	@RequestMapping(value = "/commentlistbyitem", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentVo> commentlistbyitem(int ino) {
		List<CommentVo> list = commentService.commentListByItem(ino);
		System.out.println("commentlistbyitem");
		return list;
	}
	
	//코멘트 리스트
	@RequestMapping(value = "/commentlist", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentVo> commentlist(String sid) {
		List<CommentVo> list = commentService.commentList(sid);
		System.out.println("commentlist");
		return list;
	}
	
	//코멘트 전체 리스트
	@RequestMapping(value = "/commentlisthole", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentVo> commentlisthole() {
		List<CommentVo> list = commentService.commentListhole();
		System.out.println("commentlisthole");
		return list;
	}	
}
