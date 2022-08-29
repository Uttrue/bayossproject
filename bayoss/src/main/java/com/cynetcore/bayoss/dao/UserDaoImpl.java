package com.cynetcore.bayoss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {

	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.user.";
	
	@Autowired
	private SqlSession sqlSession;
	
	//유저 등록
	@Override
	public boolean userInsert(UserVo userVo) {
		int count = sqlSession.insert(NAMESPACE+"userInsert", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	//유저 존재여부
	@Override
	public boolean isuserexist(String cid) {
		int count = sqlSession.selectOne(NAMESPACE + "isuserexist", cid);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	//유저 로그인
	@Override
	public UserVo userlogin(String cid, String cpw) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("cid", cid);
		parameter.put("cpw", cpw);
		UserVo userVo = sqlSession.selectOne(NAMESPACE + "userlogin", parameter);
		return userVo;
	}

	

	//유저정보
	@Override
	public UserVo userInfo(UserVo userVo) {
		UserVo uservo = sqlSession.selectOne(NAMESPACE + "userInfo", userVo);
		return uservo;
	}

	//유저업데이트
	@Override
	public boolean userUpdate(UserVo userVo) {
		int count = sqlSession.update(NAMESPACE + "userUpdate", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//유저삭제
	@Override
	public boolean userDelete(UserVo userVo) {
		int count = sqlSession.update(NAMESPACE + "userDelete", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	//유저리스트,관리자
	@Override
	public List<UserVo> userList() {
		List<UserVo> userlist = sqlSession.selectList(NAMESPACE+ "userList");
		return userlist;
	}


}
