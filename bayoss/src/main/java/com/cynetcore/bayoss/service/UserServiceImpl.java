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
	

	//유저 가입
	@Override
	public boolean userInsert(UserVo userVo) {
		boolean result = userDao.userInsert(userVo);
		return result;
	}

	//유저 아이디 존재여부
	@Override
	public boolean isuserexist(String cid) {
		boolean result = userDao.isuserexist(cid);
		return result;
	}

	//유저 로그인
	@Override
	public UserVo userlogin(String cid, String cpw) {
		UserVo userVo = userDao.userlogin(cid, cpw);
		return userVo;
	}

	//유저 정보조회
	@Override
	public UserVo userInfo(UserVo userVo) {
		UserVo userinfo = userDao.userInfo(userVo);
		return userinfo;
	}

	//유저 정보 업데이트
	@Override
	public boolean userUpdate(UserVo userVo) {
		boolean result = userDao.userUpdate(userVo);
		return result;
	}

	//유저 삭제
	@Override
	public boolean userDelete(UserVo userVo) {
		boolean result = userDao.userDelete(userVo);
		return result;
	}

	//유저 리스트, 관리자용
	@Override
	public List<UserVo> userList() {
		List<UserVo> userList = userDao.userList();
		return userList;
	}

	
	
}
