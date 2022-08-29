package com.cynetcore.bayoss.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.UserDao;
import com.cynetcore.bayoss.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestUser {
	
	@Autowired
	private UserDao userDao;
	
	//유저 등록
	@Test
	public void testuserInsert() {
		UserVo UserVo = new UserVo("test02", "1234", "test02@gmail.com", "0100000000");
		boolean result = userDao.userInsert(UserVo);
		System.out.println("testuserInsert, result : " + result);
	}
	
	//유저 아이디 중복
	@Test
	public void testisuserexist() {
		boolean result = userDao.isuserexist("test01");
		System.out.println("testisuserexist, result : " + result);
	}
	
	//유저 업데이트
	@Test
	public void testuserUpdate() {
		UserVo UserVo = new UserVo("test01", "test01m", "test01m@gmail.com", "010-1234-56789");
		boolean result = userDao.userUpdate(UserVo);
		System.out.println("testuserUpdate, result : " + result);
	}
	
	//유저 일반 탈퇴
	@Test
	public void testuserDelete() {
		UserVo UserVo = new UserVo();
		UserVo.setCid("test01");
		UserVo.setStatus("F");
		boolean result = userDao.userDelete(UserVo);
		System.out.println("testuserDelete" + result);
	}
	
	//유저정보
	@Test
	public void testuserInfo() {
		UserVo UserVo = new UserVo();
		UserVo.setCid("test01");
		UserVo userInfo = userDao.userInfo(UserVo);
		System.out.println("testuserInfo" + userInfo);
	}
	
	//유저 리스트
	@Test
	public void testuserList() {
		List<UserVo> userlist = userDao.userList();
		System.out.println("testuserList" + userlist);
	}
	
}
