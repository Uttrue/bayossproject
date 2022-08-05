package com.cynetcore.bayoss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynetcore.bayoss.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {

	private final String NAMESPACE = "com.cynetcore.bayoss.mappers.user.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean userInsert(UserVo userVo) {
		int count = sqlSession.insert(NAMESPACE+"userInsert", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isuserexist(String cid) {
		int count = sqlSession.selectOne(NAMESPACE + "isuserexist", cid);
		if(count > 0) {
			return true;
		}
		return false;
	}
	

	@Override
	public UserVo userInfo(UserVo userVo) {
		UserVo uservo = sqlSession.selectOne(NAMESPACE + "userInfo", userVo);
		return uservo;
	}

	@Override
	public boolean userUpdate(UserVo userVo) {
		int count = sqlSession.update(NAMESPACE + "userUpdate", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userDelete(UserVo userVo) {
		int count = sqlSession.update(NAMESPACE + "userDelete", userVo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserVo> userList() {
		List<UserVo> userlist = sqlSession.selectList(NAMESPACE+ "userList");
		return userlist;
	}

}
