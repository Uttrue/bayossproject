package com.cynetcore.bayoss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.UserLikeVo;

@Repository
public class UserLikeDaoImpl implements UserLikeDao {
	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.userlike.";

	@Autowired
	private SqlSession sqlSession;
	
	//좋아요 입력
	@Override
	public boolean likeInsert(UserLikeVo likeVo) {
		int count = sqlSession.insert(NAMESPACE + "likeInsert", likeVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//좋아요 여부
	@Override
	public UserLikeVo islikeexist(String cid, int ino) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("cid", cid);
		parameter.put("ino", ino);
		UserLikeVo likeVo = sqlSession.selectOne(NAMESPACE+"islikeexist", parameter);
		return likeVo;
	}

	//좋아요 상태변경
	@Override
	public boolean likestatus(String status, int lno) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("status", status);
		parameter.put("lno", lno);
		int count = sqlSession.update(NAMESPACE + "likestatus", parameter);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//좋아요 유저 리스트
	@Override
	public List<UserLikeVo> userLikeList(String cid) {
		List<UserLikeVo> likelist = sqlSession.selectList(NAMESPACE+"userLikeList", cid);
		return likelist;
	}

	//좋아요 셀러 리스트
	@Override
	public List<UserLikeVo> sellerLikeList(String sid) {
		List<UserLikeVo> likelist = sqlSession.selectList(NAMESPACE+"sellerLikeList", sid);
		return likelist;
	}

	//게세물별 좋아요 갯수
	@Override
	public int getcountlike(String sid, int ino) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("sid", sid);
		parameter.put("ino", ino);
		int count = sqlSession.selectOne(NAMESPACE + "getcountlike", parameter);
		return count;
	}
	
	

}
