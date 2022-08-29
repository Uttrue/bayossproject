package com.cynetcore.bayoss.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.UserLikeDao;
import com.cynetcore.bayoss.vo.UserLikeVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestUserLike {
	
	@Autowired
	private UserLikeDao likeDao;
	
	//like 등록
	@Test
	public void testLikeInsert() {
		UserLikeVo likeVo = new UserLikeVo(252, "test02", "마리콤2장", "test01");
		boolean result = likeDao.likeInsert(likeVo);
		System.out.println("testLikeInsert, result : " + result);
	}
	
	//유저 좋아요 여부
	@Test
	public void testlikeExsist() {
		UserLikeVo count = likeDao.islikeexist("test01", 252);
		System.out.println("count : " + count);
	}
	
	
	//유저 좋아요 상태변경
	@Test
	public void testlikestatus() {
		boolean result = likeDao.likestatus("F", 1);
		System.out.println("testlikestatus" + result);
	}
	
	
	//유저 좋아요 리스트
	@Test
	public void testLikeUserList() {
		List<UserLikeVo> likelist = likeDao.userLikeList("test01");
		System.out.println("testLikeSellerList" + likelist);
	}
	
	//유저 좋아요 리스트
	@Test
	public void testLikeSellerList() {
		List<UserLikeVo> likelist = likeDao.sellerLikeList("test01");
		System.out.println("testLikeSellerList" + likelist);
	}
	
}
