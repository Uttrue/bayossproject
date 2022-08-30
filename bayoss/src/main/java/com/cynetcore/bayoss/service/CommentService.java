package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.CommentVo;

public interface CommentService {
	//코멘트입력
	public boolean commentInsert(CommentVo commentVo);
	//코멘트 업데이트
	public boolean commentUpdate(CommentVo commentVo);
	//코멘트 조회
	public CommentVo commentStatus(int cmno);
	//코멘트 삭제
	public boolean commentDelete(int cmno);
	//코멘트 아이템별 리스트
	public List<CommentVo> commentListByItem(int ino);
	//코멘트 셀러별 리스트
	public List<CommentVo> commentList(String sid);
	//코멘트 전체리스트 관리자용
	public List<CommentVo> commentListhole();
}
