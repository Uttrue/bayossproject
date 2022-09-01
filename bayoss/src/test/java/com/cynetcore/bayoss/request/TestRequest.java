package com.cynetcore.bayoss.request;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cynetcore.bayoss.dao.RequestDao;
import com.cynetcore.bayoss.vo.RequestVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class TestRequest {
	
	@Autowired
	private RequestDao requestDao;
	
	//요청 등록
	@Test
	public void testrequestInsert() {
		RequestVo requestVo = new RequestVo("MAIN", "adad", "dddd", "01099992222", "ddd", "2022-09-03");
		boolean result = requestDao.requestInsert(requestVo);
		System.out.println("testCommentInsert, result : " + result);
	}
	
	
	//셀러 스토어 전체 리스트
	@Test
	public void testrequestListhole() {
		List<RequestVo> List = requestDao.requestList();
		System.out.println("testrequestListhole : " + List);
	}
	
}
