package com.cynetcore.bayoss.service;

import java.util.List;

import com.cynetcore.bayoss.vo.UserLikeVo;

public interface UserLikeService {
	//유저 좋아요 입력
	public boolean likeInsert(UserLikeVo likeVo);
	//유저 좋아요 여부
	public UserLikeVo islikeexist(String cid, int ino);
	//유저 좋아요 상태변경
	public boolean likestatus(String status, int lno);
	//유저 좋아요 리스트
	public List<UserLikeVo> userLikeList(String cid);
	//셀러 좋아요 리스트
	public List<UserLikeVo> sellerLikeList(String sid);
	//셀러 게시물별 좋아요 갯수
	public int getcountlike(String sid, int ino);
	
}
