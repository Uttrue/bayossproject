package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cynetcore.bayoss.dao.UserLikeDao;
import com.cynetcore.bayoss.vo.UserLikeVo;

@Service
public class UserLikeServiceImpl implements UserLikeService {

	@Autowired UserLikeDao likeDao;
	
	//좋아요 최초 입력
	@Override
	public boolean likeInsert(UserLikeVo likeVo) {
		boolean result = likeDao.likeInsert(likeVo);
		return result;
	}

	//좋아요 여부
	@Override
	public UserLikeVo islikeexist(String cid, int ino) {
		UserLikeVo likeVo = likeDao.islikeexist(cid, ino);
		return likeVo;
	}

	//좋아요 상태 변경
	@Override
	public boolean likestatus(String status, int lno) {
		boolean result = likeDao.likestatus(status, lno);
		return result;
	}

	@Override
	public List<UserLikeVo> userLikeList(String cid) {
		List<UserLikeVo> likelist = likeDao.userLikeList(cid);
		return likelist;
	}

	@Override
	public List<UserLikeVo> sellerLikeList(String sid) {
		List<UserLikeVo> likelist = likeDao.sellerLikeList(sid);
		return likelist;
	}

	//셀러 게시물별 좋아요 갯수
	@Override
	public int getcountlike(String sid,int ino) {
		int count = likeDao.getcountlike(sid, ino);
		return count;
	}

}
