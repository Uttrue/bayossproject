package com.cynetcore.bayoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynetcore.bayoss.dao.UserDao;
import com.cynetcore.bayoss.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public boolean userInsert(UserVo userVo) {
		boolean result = userDao.userInsert(userVo);
		return result;
	}

	@Override
	public boolean isuserexist(String cid) {
		boolean result = userDao.isuserexist(cid);
		return result;
	}

	
	@Override
	public UserVo userInfo(UserVo userVo) {
		UserVo userinfo = userDao.userInfo(userVo);
		return userinfo;
	}

	@Override
	public boolean userUpdate(UserVo userVo) {
		boolean result = userDao.userUpdate(userVo);
		return result;
	}

	@Override
	public boolean userDelete(UserVo userVo) {
		boolean result = userDao.userDelete(userVo);
		return result;
	}

	@Override
	public List<UserVo> userList() {
		List<UserVo> userList = userDao.userList();
		return userList;
	}

	
}
